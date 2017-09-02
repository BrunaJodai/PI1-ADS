/* Escreva um programa que lê um número de 1 a 12 e mostra o dobro. Valide a entrada */
package Exercicios;

import java.util.Scanner;

public class Validacao {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Digite o número (1 a 12): ");
        int num = console.nextInt();

        if (num < 1 && num > 12) {
            System.out.println("Número inválido (fora do intervalo)");
        } else {
            System.out.println("O dobro do número é: " + num * 2);
        }

    }

}
