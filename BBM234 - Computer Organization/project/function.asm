# Umut Güngör
# b21946198

.text

.globl main
	main:
		# Getting user integer input a into register v0
 		li $v0, 5
 		syscall
 	
 		# Moving the integer input to another register: $t0 <- a
 		move $t0, $v0
 	
		# Getting the second user integer input a into register v0
 		li $v0, 5
 		syscall
 	
 		# Moving the integer input to another register: $t1 <- b
 		move $t1, $v0
 			
 		addi $v1, $0, 0
 		
 		beq $t0, $t1, els
 		
 		jal compare
 		j end
 		
 		els:
			# here means numbers are equal set v1 to 2 * (a + b)
			add $t2, $t0, $t1				# t2 = a + b
			sll $t2, $t2, 1					# t2 = t2 * 2
			addi $v1, $t2, 0				# v1 = t2
					
			j exit
 		
 		end:
 			# here means numbers are not equal set v1 according to the award and punish functions(maybe set v1 to $ra)
 			j exit

	
		# Exit from the simulator function
		exit:
			li $v0, 10
			syscall
		
	
	compare:
		
		addi $sp, $sp, -4
 		sw $ra, 0($sp)
 		
	
		slt $s0, $t0, $t1
		bne $s0, $0, else
					
		jal award
		j endIf
	
		else:
			jal punish
			j endOfFunc
		
		
		endIf:
			j endOfFunc
	
	
		endOfFunc:
			lw $ra, 0($sp)
			addi $sp, $sp, 4
			jr $ra
		

	punish:
		# t0 = a ; t1 = b
		sll $t3, $t1, 2			# t3 = 4b
		sub $t3, $t3, $t1		# t3 = 4b - b	-> t3 = 3b
		sub $t4, $t0, $t3		# t4 = a - 3b
		
		addi $v1, $t4, 0
				
		jr $ra
		
	award:
		# t0 = a ; t1 = b
		sll $t3, $t0, 2			# t3 = 4a
		sub $t3, $t3, $t0		# t3 = 4a - a	-> t3 = 3a
		add $t4, $t3, $t1		# t4 = 3a + b
		
		addi $v1, $t4, 0
		
		jr $ra
			