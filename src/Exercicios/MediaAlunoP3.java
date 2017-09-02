/*Escreva um programa em Java que lê as notas de duas provas de um aluno e calcula sua média.

Se o aluno tiver média maior ou igual a 6,0, ele passa. Caso contrário, ele fará mais uma prova.

Nesse caso, o programa deve ler essa terceira nota e recalcular a média, substituindo 
a menor nota entre P1 e P2 pela nota da P3.

Indique a nova média do aluno e se ela conseguiu passar ou não.

Atenção: se o aluno fizer a P3, sua média máxima é 6,0. */
package Exercicios;

import java.util.Scanner;

public class MediaAlunoP3 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Nota da P1: ");
        double p1 = Double.parseDouble(console.nextLine());
        System.out.print("Nota da P2: ");
        double p2 = Double.parseDouble(console.nextLine());

        double media = (p1 + p2) / 2;

        if (p1 <= 0 || p1 >= 10 || p2 <= 0 || p2 >= 10) {
            System.out.println("Nota inválida.");
        } else if (media >= 6) {
            System.out.println("Média: " + media + "\nALUNO APROVADO.");
        } else {
            System.out.print("Nota da P3: ");
            double p3 = Double.parseDouble(console.nextLine());

            if (p1 <= p2) {
                media = (p2 + p3 * 0.6) / 2;
                System.out.println("Média: " + media);
                if (media >= 6) {
                    System.out.println("ALUNO APROVADO.");
                } else {
                    System.out.println("ALUNO REPROVADO.");
                }
            } else if (p2 <= p1) {
                media = (p1 + p3 * 0.6) / 2;
                System.out.println("Média: " + media);
                if (media >= 6) {
                    System.out.println("ALUNO APROVADO.");
                } else {
                    System.out.println("ALUNO REPROVADO.");
                }
            }
        }
    }
}