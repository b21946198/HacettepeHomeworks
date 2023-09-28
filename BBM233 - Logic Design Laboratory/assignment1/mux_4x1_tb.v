`timescale 1ns / 1ps
module mux_4x1_tb;
    reg [3:0] i;
    reg [1:0] s;
    output F;



mux_4x1 uut(.i(i), .s(s), .F(F));           //uut function for mux

initial begin
    //I cannot manage for loops here because two distinct for loops needed one for inputs another for selectors
    //So, I just write some cases
    //The cases which I don't include are shown as don't cares in simulation
    #5 i[3] = 0; i[2] = 0; i[1] = 0; i[0] = 1; s[1] = 0; s[0] = 0;
    #5 i[3] = 1; i[2] = 1; i[1] = 1; i[0] = 0; s[1] = 0; s[0] = 0;

    #5 i[3] = 0; i[2] = 0; i[1] = 1; i[0] = 0; s[1] = 0; s[0] = 1;
    #5 i[3] = 1; i[2] = 1; i[1] = 0; i[0] = 1; s[1] = 0; s[0] = 1;
    
    #5 i[3] = 0; i[2] = 1; i[1] = 0; i[0] = 0; s[1] = 1; s[0] = 0;
    #5 i[3] = 1; i[2] = 0; i[1] = 1; i[0] = 1; s[1] = 1; s[0] = 0;
    
    #5 i[3] = 1; i[2] = 0; i[1] = 0; i[0] = 0; s[1] = 1; s[0] = 1;
    #5 i[3] = 0; i[2] = 1; i[1] = 1; i[0] = 1; s[1] = 1; s[0] = 1;

    #5;
end


endmodule
