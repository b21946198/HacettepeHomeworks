`timescale 1ms / 100ns

module siganfu_machine_gun (
	input sysclk,
	input reboot,
	input target_locked,
	input is_enemy,
	input fire_command,
	input firing_mode, // 0 single, 1 auto
	input overheat_sensor,
	output reg[2:0] current_state,
	output reg criticality_alert = 0,			// initially this is 0
	output reg fire_trigger = 0					// initially this is 0
);

	reg[2:0] next_state;

	parameter s0 = 3'b000, s1 = 3'b001, s2 = 3'b010,		// 6 states for system specifications
			  s3 = 3'b011, s4 = 3'b100, s5 = 3'b101;

	integer bullet = 25, magazine = 3;			// 25 bullets and 3 magazines
	integer flag = 1;							// this is for break the loop
	
	always@ (posedge sysclk, posedge reboot)	// posedge clock

		if (reboot == 1) begin 					// set current state to initial state

			current_state <= s0;
			magazine = 3;
		  	bullet = 25;
		  	next_state = s0;
		  	criticality_alert = 0;
		  	flag = 1;
		  	#3;

		end

		else begin current_state <= next_state; end					// update the current state

	
	always@ (current_state, target_locked, is_enemy, fire_command, firing_mode, overheat_sensor, fire_trigger) begin

	  case (current_state)

	  	s0: if (target_locked & is_enemy & fire_command & ~firing_mode & ~overheat_sensor) begin		// IDLE state no shooting
			  fire_trigger = 0;
			  next_state = s1;
			  flag = 1;
		  end

			else if (target_locked & is_enemy & fire_command & firing_mode & ~overheat_sensor) begin 
				fire_trigger = 0;
				next_state = s2;
				flag = 1;
			end

			else begin 
				next_state = s0;
				flag = 1;
			end


		s1: if (overheat_sensor) next_state = s4;					// single shooting state
			else if (bullet == 0) begin
				flag = 1;
				fire_trigger = 1;
				#5;
				fire_trigger = 0;
				if (magazine > 0) next_state = s3;
				else next_state = s5;

			end	

			else if (~target_locked | ~is_enemy | ~fire_command) begin 		// if these 3 conditions are not satisfied back to thte initial state
				next_state = s0;
				flag = 1;
			end


			else if (target_locked & is_enemy & fire_command & ~firing_mode & ~overheat_sensor) begin
			  
				fire_trigger = 1;
				#5;
				fire_trigger = 0;
				bullet = bullet - 1;
				#25;
				next_state = s0;
				flag = 1;

			end	

		s2: if (overheat_sensor) next_state = s4;							// auto shooting state

			else if (bullet == 0) begin
			  
			  	if (magazine > 0) next_state = s3;
			  	else next_state = s5;
			end

			else if (~target_locked | ~is_enemy | ~fire_command) next_state = s0;		// if these 3 conditions are not satisfied back to thte initial state

			else if (target_locked & is_enemy & fire_command & firing_mode & ~overheat_sensor) begin
				
				while(bullet > 0 && flag) begin								// gun shoots until it has no bullet
				  	fire_trigger <= ~fire_trigger;
					
					if(fire_trigger) bullet = bullet - 1;
				  	
					if(bullet == 1) fire_trigger = 0;
				  	#5;

				  	if (overheat_sensor) begin 								// if overheat happens first go to that state
						  next_state = s4;
						  flag = 0;
					  end

					else if (bullet == 0) begin								// otherwise if it has magazine go to the reload state if not go to the reboot state
			  
			  			if (magazine > 0) next_state = s3;
			  			else next_state = s5;
						flag = 0;
					end

					else if (~target_locked | ~is_enemy | ~fire_command) begin 
						next_state = s0;
						flag = 0;
					end

				end
				
			end

		s3: if (overheat_sensor) next_state = s4; 						// reload state

			else if (magazine == 1) begin
				
				#45;
				bullet = 25;						// reload bullets
				magazine = magazine - 1;			// decreases the magazine
				criticality_alert = 1;				// if there is not another magazine criticality alert is goes to high
				#5;
				flag = 1;

				if (~target_locked | ~is_enemy | ~fire_command) next_state = s0;
				else if (target_locked & is_enemy & fire_command & ~firing_mode & ~overheat_sensor) next_state = s1;
				else if (target_locked & is_enemy & fire_command & firing_mode & ~overheat_sensor) next_state = s2;
			end

			else if (magazine > 1) begin
				
				#50;						// wait 50 ms
				bullet = 25;
				magazine = magazine - 1;
				flag = 1;
	
				if (~target_locked | ~is_enemy | ~fire_command) next_state = s0;											// conditions are not satisfied go to the IDLE state
				else if (target_locked & is_enemy & fire_command & ~firing_mode & ~overheat_sensor) next_state = s1;		// firing mode is low go to the single shoot state
				else if (target_locked & is_enemy & fire_command & firing_mode & ~overheat_sensor) next_state = s2;			// firing mode is high go to the auto shoot state
			  
			end

		s4: if (bullet == 0 && magazine == 0) begin							// overheat state
		  		#100;					// wait 100 ms
		  		next_state = s5;
				flag = 1;
			end

			else if (bullet == 0 && magazine > 0) begin						// if reload needed go to the reload state
			  	#100;
			 	next_state = s3;
				flag = 1;
			end

			else if (!target_locked | !is_enemy | !fire_command) begin
			  	#10;
				next_state = s0;
				flag = 1;
			end

			else if (target_locked & is_enemy & fire_command & ~firing_mode) begin
			  	#100;
			  	next_state = s1;
				flag = 1;
			end 

			else if (target_locked & is_enemy & fire_command & firing_mode) begin
				#100;

					if(!target_locked | !is_enemy | !fire_command) begin
					  next_state = s0;
					  flag = 1;
					end
				
					else begin
					  	next_state = s2;
						flag = 1;
					end
			end

		s5: if (reboot == 1) begin					// if reboot is high reload magazines bullets and go to the initial state to start over again
		  magazine = 3;
		  bullet = 25;
		  next_state = s0;
		  criticality_alert = 0;
		  flag = 1;
		  #5;
		  
		end
			else begin								// if reboot signal is low and gun in this state it remains in this state until reboot signal is high
				next_state = s5;
				flag = 1;
			end
			
	  endcase

	end

endmodule
