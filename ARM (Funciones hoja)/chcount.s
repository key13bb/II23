.data
res: .word 0
char: .ascii "a"
padding: .byte 0,0,0
cadena: .asciz "Hola, esto es una prueba"
.text
 push {lr}
 ldr r0, =cadena // en r0 cargamos direccion de la cadena
 ldr r1, =char 
 ldrb r1, [r1] // en r1 el caracter a buscar
 bl chcount // llamamos a la funcion
 ldr r1, =res 
 str r0, [r1] // almacenamos en res el valor devuelto por la funcion
 pop {lr}
 bx lr
chcount: // aqui tu funcion
mov r3, #0
push {r1}
loop:
pop {r1}
ldrb r2, [r0], #8
cmp r1, r2
add r3, r3, #1
push {r1}
ldrb r1, "0"
cmp r1, r2
bne loop
mov r0, r3
mov pc, lr