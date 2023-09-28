module mux_4x1
(
    input[3:0] i,           //4 inputs 
    input[1:0] s,           //2 selectors
    output F                //1 output as usual in 4x1 multiplexer

);
//Used datalow design approach here 
assign F = (!s[1] & !s[0] & i[0]) | (!s[1] & s[0] & i[1]) | (s[1] & !s[0] & i[2]) | (s[1] & s[0] & i[3]);

endmodule
