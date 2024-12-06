.data
tam: .word 8
pos: .word 0
vector: .word 2, -3, 6, 5, -4, 8, 1, 0
val: .word -4
.text
.global main
main: 	ldr r0, =tam
		ldr r1, [r0]
		ldr r0, =pos
		mov r2, #0
		sub r2, r2, #1
		str r2, [r0]
		ldr r2, =vector
		ldr r0, =val
		ldr r3, [r0]
		ldr r4, [r2], #4
		sub r1, r1, #1
loop:	ldr r0, =pos
		cmp r3, r4
		beq exit
		cmp r1, #0
		beq exit
		ldr r4, [r2], #4
		sub r1, r1, #1
		b loop
exit:	ldr r0, =pos
		cmp r3, r4
		ldreq r0, =tam
		ldreq r0, [r0]
		subeq r1, r0, r1
		sub r1, r1, #1
		ldreq r0, =pos
		streq r1, [r0]
		bx lr