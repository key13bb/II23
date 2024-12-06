.global _start
_start:
	
.data
len:	.word 8
datos:	.word 8,-3,4,-7,9,-7,6,-1
res:	.word 0
 
.text
.global main
main:
		ldr r0, =len
		ldr r4, [r0]
		ldr r5, =datos
		ldr r1, [r5]
		ldr r2, [r5], #4
		ldr r3, [r5], #4
		sub r4, r4, #2
loop:
		cmp r4, #0
		blt exit
		cmp r3, r1
		movlt r1, r3
		cmp r3, r2
		movgt r2, r3
		ldr r3, [r5], #4
		sub r4, r4, #1
		b loop
exit:
		sub r6, r2, r1
		ldr r0, =res
		str r6, [r0]
		bx lr