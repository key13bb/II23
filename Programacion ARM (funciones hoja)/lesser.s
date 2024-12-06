.data
tam: .word 10
vector: .word 1, 2, 3, 4, 1, 2, 1, 2, 5, 6
val: .word 3
res: .word 0
.text
 push {lr}
 ldr r0, =vector
 ldr r1, =tam
 ldr r1, [r1]
 ldr r2, =val
 ldr r2, [r2]
 bl lesser
 ldr r1, =res
 str r0, [r1]
 pop {lr}
 bx lr
lesser:
		mov r3, #0
loop:
		push {r1}
		ldr r1, [r0], #4
		cmp r1, r2
		addlt r3, r3, #1
		pop {r1}
		sub r1, r1, #1
		cmp r1, #0
		bne loop
		mov r0, r3
		mov pc, lr
