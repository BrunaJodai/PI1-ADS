package Exercicios;

import java.util.Scanner;

public class Calculadora_if {

    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);
        int n1, n2, result;
        char ope;
        
        System.out.print("Primeiro valor: ");
        n1 = leitor.nextInt();
        System.out.print("Operador: ");
        ope = leitor.next().charAt(0);
        System.out.print("Segundo valor: ");
        n2 = leitor.nextInt();
        
        if (ope=='+') {
            result = n1 + n2;
            System.out.printf("RESULTADO: %d %c %d = %d\n" ,n1 ,ope ,n2 ,result);
        } else if (ope=='-') {
            result = n1 - n2;
            System.out.printf("RESULTADO: %d %c %d = %d\n" ,n1 ,ope ,n2 ,result);
        } else if (ope=='*') {
            result = n1 * n2;
            System.out.printf("RESULTADO: %d %c %d = %d\n" ,n1 ,ope ,n2 ,result);
        } else if (ope=='/') {
            result = n1 / n2;
            System.out.printf("RESULTADO: %d %c %d = %d\n" ,n1 ,ope ,n2 ,result);
        } else {
            System.out.println("Operador inválido.");
        }

    }
}
