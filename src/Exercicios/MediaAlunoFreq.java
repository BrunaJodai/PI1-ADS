/* Melhore o exercício anterior de forma que ele também tenha a frequência do aluno como entrada.
O aluno só passa se sua frequência for maior ou igual a 75% */
package Exercicios;

import java.util.Scanner;

public class MediaAlunoFreq {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Nota da P1: ");
        double p1 = Double.parseDouble(console.nextLine());
        System.out.print("Nota da P2: ");
        double p2 = Double.parseDouble(console.nextLine());
        System.out.print("Frequência (%): ");
        double freq = Double.parseDouble(console.nextLine());

        double media = (p1 + p2) / 2;

        if (p1 < 0 || p1 > 10 || p2 < 0 || p2 > 10) {
            System.out.println("Nota inválida.");
        } else if (media >= 6 && freq >= 75) {
            System.out.println("Média: " + media + "\nALUNO APROVADO.");
        } else if (freq >= 75) {
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
        } else {
            System.out.println("Frequencia menor que 75%. ALUNO REPROVADO.");
        }
    }
}