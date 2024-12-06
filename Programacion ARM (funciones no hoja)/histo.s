.data
tam: .word 11
vector1: .word 1, 2
vector2: .word 1, 2, 1, 2, 3, 2, 4, 1, 2, 2, 3
vector3: .word 0, 0
.text
 push {lr}
 ldr r0, =vector1
 ldr r1, =vector2
 ldr r2, =tam
 ldr r2, [r2]
 ldr r3, =vector3
 bl histo
 pop {lr}
 bx lr
histo:
		push {r3}
		mov r3, #2
loop:

count:
