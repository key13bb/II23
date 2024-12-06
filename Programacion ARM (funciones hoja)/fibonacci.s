.data
minumr:     .word 8
res:        .word 0
.text
.global main
main:
		ldr r1, =minumr
		ldr r0, [r1]
		ldr r4, =res
		push {lr}
		bl fib
		pop {lr}
		str r0, [r4]
		bx lr
fib:
		mov r2, #0
		mov r3, r0
		mov r0, #0
		mov r1, #1
loop:
		add r2, r1, r0
		mov r0, r1
		mov r1, r2
		sub r3, r3, #1
		cmp r3, #0
		bne loop
		mov r0, r2
		mov pc, lr
