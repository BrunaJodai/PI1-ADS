/*Escreva um programa que lê um número e mostra a soma dos seus dígitos.

Exemplos:

Número: 123
Soma: 6  */

package Exercicios;

import java.util.Scanner;

public class SomaDosDigitos {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int soma =0;
        
        System.out.print("Digite um número: ");
        String n = console.nextLine();
              
        for (int i = 0; i < n.length(); i++) {
            String d = n.substring(i, i+1);
            int di = Integer.parseInt(d);
            soma = soma + di;
        }
        System.out.println("Soma dos dígitos: " +soma);
    }

}