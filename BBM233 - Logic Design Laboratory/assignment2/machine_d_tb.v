`timescale 1ns/1ps

module machine_d_tb;

    reg x = 0;
    reg rst;
    reg clk;
    wire F;

    machine_d uut(.x(x), .rst(rst), .clk(clk), .F(F));                  //uut function for machine

    reg[21:0] input_data;                       //22 bit data input
    integer shift_amount;                       //for testing


    initial begin

        $dumpfile("simulation.vcd");
        $dumpvars;
        input_data = 22'b0001111000000111000100;
        shift_amount = 0;
        rst = 1; #30;                           //at first 30 ns the machine rests.
        rst = 0; #100;
        rst = 1; #5;                            //again 5 ns rest cut
        rst = 0; #90;

        $finish;

    end

    initial begin
        clk = 0;
        forever begin                           //clock is low and high at every 5 ns
            #5;
            clk = ~clk;
        end
  
    end


    always @ (posedge clk) begin                //read all 22 bit input by shifting
        x = input_data>>shift_amount;
        shift_amount = shift_amount + 1;

    end


endmodule
