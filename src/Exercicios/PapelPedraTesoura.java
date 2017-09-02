package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class PapelPedraTesoura {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random rng = new Random();
        int pc = rng.nextInt(2);
        int hum;

        System.out.print("Escolha:\n"
                + "(1) Pedra;\n"
                + "(2) Papel;\n"
                + "(3) Tesoura.\n"
                + "Insira sua escolha: ");
        hum = leitor.nextInt();

        if (hum >= 1 && hum <= 3) {
            System.out.printf("O computador escolheu a opção: %d\n\n", pc + 1);
            if (pc + 1 == hum) {
                System.out.println("EMPATE!");
            } else if (pc + 1 > hum) {
                System.out.println("PC VENCEU!");
            } else if (pc + 1 < hum) {
                if (pc + 1 != 1) {
                    System.out.println("VOCÊ VENCEU!");
                } else {
                    System.out.println("PC VENCEU!");
                }
            }
        } else {
            System.out.println("OPÇÃO INVÁLIDA.");
        }
    }
}
