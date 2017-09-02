/* Escreva um programa que mostra a soma dos 10000 primeiros termos da seguinte série:

soma = 1/1 + 1/3 + 1/5 + 1/7 + 1/9 + ... */
package Exercicios;

import java.util.Scanner;

public class SomaDaSerie2 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int soma = 0, num = 1;

        for (int i = 1; i <= 10000; i++) {
            soma = soma + num;
            num = 1/(num + 2);
        }
        System.out.println("Soma dos 10000 primeiros termos: " + soma);
    }
}