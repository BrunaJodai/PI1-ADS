/*Escreva um algoritmo que lê o seu tipo sanguíneo e mostra:

Para quais tipos você pode fazer uma doação de sangue
De quais tipos você pode receber uma doação de sangue
Exemplo:

Qual seu tipo sanguíneo: A-
Você pode doar para: A+, A-, AB-, AB+
Você pode receber de: A-, O-
 */
package Exercicios;

import java.util.Scanner;

public class DoacaoSangue {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        
        System.out.print("Qual seu tipo sanguíneo: ");
        String sang = console.nextLine();
        
        if (sang.equals("A+")) {
            System.out.println("Você pode receber de: A+, A-, O+ e O-");
            System.out.println("Você pode doar para: AB+ e A+");
        } else if (sang.equals("A-")) {
            System.out.println("Você pode receber de: A- e O-");
            System.out.println("Você pode doar para: A+, A-, Ab+ e AB-");
        } else if (sang.equals("B+")) {
            System.out.println("Você pode receber de: B+,B-, O+ e O-");
            System.out.println("Você pode doar para: B+ e AB+");
        } else if (sang.equals("B-")) {
            System.out.println("Você pode receber de: B- e O-");
            System.out.println("Você pode doar para: B+, B-, AB+ e AB-");
        } else if (sang.equals("AB+")) {
            System.out.println("Você pode receber de: A+, B+, O+, AB+, A-, B-, O- e AB- (todos).");
            System.out.println("Você pode doar para: AB+");
        } else if (sang.equals("AB-")) {
            System.out.println("Você pode receber de: A-, B-, O- e AB-");
            System.out.println("Você pode doar para: AB+ e AB-");
        } else if (sang.equals("O+")) {
            System.out.println("Você pode receber de: O+ e O-");
            System.out.println("Você pode doar para: A+, B+, O+ e AB+");
        } else if (sang.equals("O-")) {
            System.out.println("Você pode receber de: O-");
            System.out.println("Você pode doar para: A+, B+, O+, AB+, A-, B-, O- e AB- (todos)");
        } else {
            System.out.println("Tipo sanguineo inválido.");
        }
    }
}