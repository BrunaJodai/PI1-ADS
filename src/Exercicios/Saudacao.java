package Exercicios;

import java.util.Scanner;

public class Saudacao {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String nome;

        System.out.print("Nome: ");
        nome = console.nextLine();

        if (nome.equals("")) {
            System.out.println("Olá, mundo!");
        } else {
            System.out.println("Olá " + nome + "!");
        }
    }

}
