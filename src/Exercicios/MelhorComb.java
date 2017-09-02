package Exercicios;

import java.util.Scanner;

public class MelhorComb {
    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);
        double kmgaso, kmalc, pgaso, palc;
        
        System.out.print("Qntos km/l o carro anda com gasolina: ");
        kmgaso = Double.parseDouble(leitor.nextLine());
        System.out.print("Preço da gasolina: ");
        pgaso = Double.parseDouble(leitor.nextLine());
        System.out.print("Qntos km/l o carro anda com álcool: ");
        kmalc = Double.parseDouble(leitor.nextLine());
        System.out.print("Preço do álcool: ");
        palc = Double.parseDouble(leitor.nextLine());
        
        double tgaso = kmgaso/pgaso;
        double talc = kmalc/palc;
        
        if (tgaso > talc) {
            System.out.println("Melhor opção é abastecer com gasolina.");
        } else if (talc > tgaso){
            System.out.println("Melhor opção é abastecer com álcool.");
        } else {
            System.out.println("Mesmo custo/benefício. Escolha de sua preferência.");
        }
    }
}