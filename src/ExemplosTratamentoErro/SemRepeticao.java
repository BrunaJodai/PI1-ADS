package ExemplosTratamentoErro;

import java.util.Scanner;

public class SemRepeticao {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try {
            System.out.print("Número 1: ");
            double n1 = Double.parseDouble(console.nextLine()); // essa linha pode LANÇAR uma NumberFormatException

            System.out.print("Número 2: ");
            double n2 = Double.parseDouble(console.nextLine()); // essa linha pode LANÇAR uma NumberFormatException

            System.out.print("Operação: ");
            String op = console.nextLine();

            double resultado = 0;
            switch (op) {
                case "+":
                    resultado = n1 + n2;
                    break;
                case "-":
                    resultado = n1 - n2;
                    break;
                case "*":
                    resultado = n1 * n2;
                    break;
                case "/":
                    resultado = n1 / n2;
                    break;
                default:
                    throw new IllegalArgumentException(); // se a operação for inválida, NÓS LANÇAMOS uma IllegalArgumentException
            }

            System.out.println(n1 + " " + op + " " + n2 + " = " + resultado);
        } catch (NumberFormatException ex) { // PEGA a NumberFormatException e trata ela
            System.out.println("Número inválido!");
        } catch (IllegalArgumentException ex) { // PEGA a IllegalArgumentException e trata ela
            System.out.println("Operação inválida!");
        }
    }

}
