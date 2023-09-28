module decoder_2x4
(
    input[1:0] A,       //2 inputs
    output[3:0] D       //4 outputs as usual in 2x4 decoder

);
    //Used dataflow design approach here
    assign D[0] = !A[1] & !A[0];
    assign D[1] = !A[1] & A[0];
    assign D[2] = A[1] & !A[0];
    assign D[3] = A[1] & A[0];


endmodule
