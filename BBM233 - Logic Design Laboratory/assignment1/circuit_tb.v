`timescale 1ns / 1ps
module circuit_tb;
    reg a;
    reg b;
    reg c;
    reg d;
    output F;


circuit uut(.a(a), .b(b), .c(c), .d(d), .F(F));     //uut function for circuit with explicit association

initial begin
    //so here again I cannot manage for loop beacuse there are 4 different inputs
    a = 0; b = 0; c = 0; d = 0;
    #5 a = 0; b = 0; c = 0; d = 1;
    #5 a = 0; b = 0; c = 1; d = 0;
    #5 a = 0; b = 0; c = 1; d = 1;
    #5 a = 0; b = 1; c = 0; d = 0;
    #5 a = 0; b = 1; c = 0; d = 1;
    #5 a = 0; b = 1; c = 1; d = 0;
    #5 a = 0; b = 1; c = 1; d = 1;          //all 16 possibilities with 4 inputs
    #5 a = 1; b = 0; c = 0; d = 0;
    #5 a = 1; b = 0; c = 0; d = 1;
    #5 a = 1; b = 0; c = 1; d = 0;
    #5 a = 1; b = 0; c = 1; d = 1;
    #5 a = 1; b = 1; c = 0; d = 0;
    #5 a = 1; b = 1; c = 0; d = 1;
    #5 a = 1; b = 1; c = 1; d = 0;
    #5 a = 1; b = 1; c = 1; d = 1;
    #5;
end


endmodule
