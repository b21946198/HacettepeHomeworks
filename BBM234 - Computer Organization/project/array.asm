# Umut Güngör
# b21946198

.data
	A: .word 2, 3, 1, 4, 8, 20, 30, 7, 9, 15 # Initialize the array A in memory

.text
.globl main
	main:
		# Load the address of A[0] to $t1
		addi $t1, $0, 0
		
		# Getting user integer input K into register v0
 		li $v0, 5
 		syscall
 
 		# Moving the integer input to another register: $t0 <- K
 		move $t0, $v0
 		
 		addi $t2, $0, 0					# iterator like i when it becomes 10 break the loop
 		addi $t3, $0, 10				# size of the array
 		addi $v1, $v1, 0				# counter
 		
 		while:
 			beq $t2, $t3, exit			# break condition
 			
 			lw $t4, A($t1)				# load the array value
 			
 			slt $s0, $t4, $t0			# compare array's value according to the index and input value
 			bne $s0, $0, eFound			# if condition is satisfied move eFound
 			
 			
 			addi $t2, $t2, 1			# increment iterator i
 			addi $t1, $t1, 4			# increment array's address value
 			
 		
 			j while					# back to the loop
 			
 		eFound:						# if element is less than i/p value
 			addi $v1, $v1, 1			# counter adds up by 1
 			addi $t2, $t2, 1
 			addi $t1, $t1, 4
 			j while					# back to the while loop
 		
 		exit:						# if loop breaks
 		
		
		# Exit from the simulator function
		li $v0, 10
		syscall
		