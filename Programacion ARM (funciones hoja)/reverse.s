.data
vector1:  .word 1,2,3,4,5,6,7,8
vector2:  .word 0,0,0,0,0,0,0,0
len:      .word 8
.text
push {lr}
ldr r0, =vector1
ldr r1, =len
ldr r1, [r1]
ldr r2, =vector2
bl reverse
pop {lr}
bx lr
reverse:
		mov r3, #4
		mul r3, r1, r3
		add r0, r0, r3
		sub r0, r0, #4
loop:
		ldr r3, [r0]
		str r3, [r2]
		sub r0, r0, #4
		add r2, r2, #4
		sub r1, r1, #1
		cmp r1, #0
		bne loop
		mov pc, lr
