`timescale 1ns / 1ps
module decoder_2x4_tb;
    reg [1:0] A;
    wire [3:0] D;


decoder_2x4 uut(.A(A), .D(D));          //uut function for decoder


initial begin
    $dumpfile("simulation.vcd");        //for simulation
    $dumpvars;                          //for pass the variables

    A[1] = 0; A[0] = 0;
    #10 A[1] = 0; A[0] = 1;
    #10 A[1] = 1; A[0] = 0;             //all input possibilities with 10ns delay
    #10 A[1] = 1; A[0] = 1;
    #10;
end

endmodule
