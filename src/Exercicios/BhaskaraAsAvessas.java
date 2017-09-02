package Exercicios;

import java.util.Scanner;

public class BhaskaraAsAvessas {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //entrada
        System.out.print("x1: ");
        double x1 = Double.parseDouble(console.nextLine());

        System.out.print("x2: ");
        double x2 = Double.parseDouble(console.nextLine());

        System.out.print("c: ");
        double c = Double.parseDouble(console.nextLine());

        //processamento
        double s = x1 + x2;
        double p = x1 * x2;
        double a = c / p;
        double b = -(s * a);

        //saída
        System.out.println("A equação que tem raízes " + x1 + " e " + x2 + " e " + a + "x² + " + b + "x + " + c);
    }

}
