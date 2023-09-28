module circuit
(
    input a,            //decoder's first input
    input b,            //decoder's second input
    input c,            //multiplexer's first selector
    input d,            //multiplexer's second selctor
    output F

);

wire[3:0] w;            //a vector to connect decoder and multiplexer
mux_4x1 m1(.i(w), .s({c,d}), .F(F));        //mux initiation
decoder_2x4 d1(.A({a,b}), .D(w));           //decoder initiation



wire t1, t2, t3, t4;    //four wires to structural design approach
//used structural design approach here
and(t1, !a, !b, !c, !d);        //m0
and(t2, !a, b, !c, d);          //m5
and(t3, a, b, c, d);            //m15 
and(t4, a, !b, c, !d);          //m10
or(F3, t1, t2, t3, t4);         //function F


endmodule
