package Exercicios;

import java.util.Scanner;

public class Triangulo {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Primeira medida: ");
        double a = leitor.nextDouble();
        System.out.print("Segunda medida: ");
        double b = leitor.nextDouble();
        System.out.print("Terceira medida: ");
        double c = leitor.nextDouble();

        if (a < b + c && b < c + a && c < a + b) {
            if (a == b && b == c && c == a) {
                System.out.printf("As medidas %.2f, %.2f e %.2f formam um triângulo Triângulo Equilátero.\n", a, b, c);
            } else if (a == b || b == c || c == a) {
                System.out.printf("As medidas %.2f, %.2f e %.2f formam um triângulo Triângulo Isósceles.\n", a, b, c);
            } else if (a!=b && b!=c && c!=a) {
                System.out.printf("As medidas %.2f, %.2f e %.2f formam um triângulo Triângulo Escaleno.\n", a, b, c);
            } else {
                System.out.printf("As medidas %.2f, %.2f e %.2f formam um outro tipo de triângulo.\n", a, b, c);
            }
        } else {
            System.out.printf("As medidas %.2f, %.2f e %.2f não formam um triângulo.\n", a, b, c);
        }
    }

}
