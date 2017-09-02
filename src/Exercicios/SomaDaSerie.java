/* Escreva um programa que mostra a soma dos 10000 primeiros termos da seguinte série:

soma = 1 + 3 + 5 + 7 + 9 + ... = 100 000 000 (100 milhões)*/
package Exercicios;

import java.util.Scanner;

public class SomaDaSerie {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int soma=0, num=1;
        
        for (int i=1; i<=10000; i++) {
            soma = soma + num;
            num = num+2;
        }
        System.out.println("Soma dos 10000 primeiros termos: " +soma);
    }
}