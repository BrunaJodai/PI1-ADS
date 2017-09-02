package Exercicios;

import java.util.Scanner;

public class Imc {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String nome;

        System.out.print("Nome: ");
        nome = console.nextLine();

        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(console.nextLine());

        System.out.print("Altura (m): ");
        double altura = Double.parseDouble(console.nextLine());

        double imc = peso / (altura * altura);

        if (imc < 18.5) {
            System.out.println(nome + " está com Índice de Massa Corporal " + imc + " (abaixo do peso).");
        } else if (imc >= 18.5 || imc < 25) {
            System.out.println(nome + " está com Índice de Massa Corporal " + imc + " (peso normal).");
        } else if (imc >= 25 || imc < 30) {
            System.out.println(nome + " está com Índice de Massa Corporal " + imc + " (acima do peso).");
        } else if (imc >= 30) {
            System.out.println(nome + " está com Índice de Massa Corporal " + imc + " (obesidade).");
        }
    }

}
