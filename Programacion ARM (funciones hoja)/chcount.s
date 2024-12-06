.data
res: .word 0
char: .ascii "a"
padding: .byte 0,0,0
cadena: .asciz "Hola, esto es una prueba"
.text
 push {lr}
 ldr r0, =cadena
 ldr r1, =char
 ldrb r1, [r1]
 bl chcount
 ldr r1, =res
 str r0, [r1]
 pop {lr}
 bx lr
chcount:
		mov r3, #0
loop:
		ldr r2, [r0], #4
		cmp r1, r2
		addeq r3, r3, #1
		cmp r2, #0
		bne loop
		mov r0, r3
		mov pc, lr
