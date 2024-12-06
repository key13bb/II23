.global _start
_start:
	
.data
tam:   .word 8
datos: .word 2, 4, 6, 8, -2, -4, -6, -7
res:   .word 0
.text
.global main
main: ldr r0, =tam
ldr r1, [r0]
ldr r2, =datos
ldr r4, [r2], #4
sub r1, r1, #1
mov r3, r4
loop: cmp r1, #0
beq exit
ldr r3, [r2], #4
cmp r4, r3
movle r4, r3
sub r1, r1, #1
b loop
exit: ldr r0, =res
str r4, [r0]
bx lr