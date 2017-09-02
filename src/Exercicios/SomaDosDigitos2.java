/* Escreva um programa que lê um número e mostra a soma dos seus dígitos, 
cada um múltiplicado por um peso, da seguinte forma:

Se o número tem 4 dígitos, o primeiro dígito deve ser multiplicado por 4, 
o segundo por 3, o terceiro por 2 e assim por diante.
Se o número tem 10 dígitos, o primeiro dígito deve ser multiplicado por 10, 
o segundo por 9, o terceiro por 8 e assim por diante. 

Número: 123
Resultado: 10
Explicação: 1x3 + 2x2 + 3x1 = 10*/
package Exercicios;

import java.util.Scanner;

public class SomaDosDigitos2 {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int soma =0;
        
        System.out.print("Digite um número: ");
        String n = console.nextLine();
              
        for (int i = 0; i < n.length(); i++) {
            String d = n.substring(i, i+1); //retorna uma parte da string
            int di = Integer.parseInt(d); //converte essa parte para inteiro
            int peso = n.length() - i; 
            soma = soma + (di * peso);
            //System.out.printf("\n %d = %d + (%d * %d - 1)\n" ,soma ,soma , di ,peso);
        }
        System.out.println("Soma dos dígitos (com peso): " +soma);        
    }
}