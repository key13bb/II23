.data
tam:	.word 8
ocur:	.word 0
vector:	.word 2, -3, 6, 5, -4, 8, 2, 0
val:	.word 2
.text
.global	main
main:	ldr r0, =tam
		ldr r1, [r0]
		ldr r2, =vector
		ldr r0, =val
		ldr r3, [r0]
		mov r5, #0
loop:	ldr r4, [r2], #4
		sub r1, r1, #1
		cmp r3, r4
		addeq r5, r5, #1
		cmp r1, #0
		beq exit
		b loop
exit:	ldr r0, =ocur
		str r5, [r0]
		bx lr