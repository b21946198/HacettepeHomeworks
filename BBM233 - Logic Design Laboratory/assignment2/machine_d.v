`timescale 1ns/1ps

module machine_d
(
    input x,
    input rst,
    input clk,
    output F

);

reg[2:0] present_state = 3'b000;            // 2->A     1->B    0->C
wire[2:0] next_state;                       // 2->DA     1->DB    0->DC

//we have 3 states so we need 3 D FFs. 3 discrete FF equations are shown below
dff DA                                      
(
    .d( (present_state[2]) | (present_state[1] & x) ), .rst(rst), .clk(clk), .q(next_state[2])
);

dff DB
(
    .d( (present_state[1] & ~x) | (~present_state[2] & ~present_state[1] & x) ), .rst(rst), .clk(clk), .q(next_state[1])
);

dff DC
(
    .d( (~present_state[0] & ~x) | (present_state[0] & x) ), .rst(rst), .clk(clk), .q(next_state[0])
);


always @(rst or next_state) begin

  if(rst) begin present_state <= 3'b000; end                        //if reset is high state backs to the initial state which is 000
  else begin present_state <= next_state; end                       //otherwise go to the next state

end

assign F = present_state[2] & present_state[0];                     //o/p function according to the given state diagram

endmodule
