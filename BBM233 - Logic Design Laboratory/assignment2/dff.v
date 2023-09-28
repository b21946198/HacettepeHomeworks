`timescale 1ns/1ps

module dff
(
    input d,            //data i/p
    input rst,          //reset i/p
    input clk,          //clock i/p
    output reg q        //the output in the D FF
);

always @(posedge clk or posedge rst) begin        //rising edge clock and reset

  if(rst)
    q <= 0;

  else
    q <= d;

end

endmodule
