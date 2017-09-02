package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class Adivinha1 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random sorteio = new Random();
        int num = sorteio.nextInt(9);
        int chute;

        System.out.print("Tente adivinhar o número sorteado: ");
        chute = leitor.nextInt();

        if (chute == num + 1) {
            System.out.println("Você acertou!");
        } else {
            System.out.printf("Você errou! O número sorteado foi: " + (num + 1) + "\n");
        }
    }
}
