package Exercicios;

import java.util.Scanner;
import java.util.Random;

public class ParImpar {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rng = new Random();
        int num1 = rng.nextInt(10);
        int num2, res;
        String escolha;

        System.out.print("Escolha par ou ímpar: ");
        escolha = console.nextLine();

        if (escolha.equals("par") || escolha.equals("ímpar")) {

            System.out.print("Digite um número: ");
            num2 = console.nextInt();
            System.out.println("Número escolhido pelo computador: " + num1);

            res = num1 % num2;

            if (res == 0) {
                System.out.println("Par ganhou.");
            } else {
                System.out.println("Ímpar ganhou.");
            }
        } else {
            System.out.println("Escolha incorreta.");
        }
    }
}
