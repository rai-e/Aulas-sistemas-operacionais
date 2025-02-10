.data
    num1:   .byte 6   # Primeiro número
    num2:   .word 32   # Segundo número
    x:   .word 10   # Segundo número
    y:   .word 11   # Segundo número
    result: .word 0    # Variável para armazenar o resultado
    msg:    .asciiz "A media e = " # Mensagem de saída

.text
    li $v0, 4          # Código da syscall para imprimir string
    la $a0, msg        # Carrega endereço da mensagem
    syscall            # Imprime a mensagem "A média é: "

    lw $t0, num1       # Carrega num1 em $t0
    lw $t1, num2       # Carrega num2 em $t1

    add $t2, $t0, $t1  # Soma num1 e num2 → $t2 = num1 + num2
    sra $t3, $t2, 1    # Divide por 2 (shift right arithmetic) → $t3 = média

    sw $t3, result     # Armazena a média na variável result

    move $a0, $t3      # Move resultado para $a0 para exibir
    li $v0, 1          # Código da syscall para imprimir inteiro
    syscall            # Exibe a média

    li $v0, 10         # Código da syscall para sair
    syscall
