package Exercicios;

import java.util.Scanner;

public class Bhaskara {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        double a, b, c, x1, x2, delta;
        
        System.out.println("Equação de 2 grau");
        System.out.print("Valor de a: ");
        a = console.nextDouble();
        System.out.print("Valor de b: ");
        b = console.nextDouble();
        System.out.print("Valor de c: ");
        c = console.nextDouble();
        
        //processamento
        delta = (b*b)-4*a*c;
        x1 = (-b + Math.sqrt(delta)) / (2*a);
        x2 = (-b - Math.sqrt(delta)) / (2*a);
        
        if (delta > 0) {
            System.out.println("As raízes são: " +x1+ ", " +x2);
        } else if (delta == 0){
            System.out.println("As raízes são iguais: " +x1);
        } else {
            System.out.println("Não existe raíz real.");
        }
    }
}
