package ExemplosTratamentoErro;

import java.util.Scanner;

public class ComRepeticao {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double n1 = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Número 1: ");
                n1 = Double.parseDouble(console.nextLine()); // essa linha pode LANÇAR uma NumberFormatException
                valido = true;
            } catch (NumberFormatException ex) { // PEGA a NumberFormatException e trata ela
                System.out.println("Por favor, entre com um número válido...");
            }
        } while (!valido);

        double n2 = 0;
        valido = false;
        do {
            try {
                System.out.print("Número 2: ");
                n2 = Double.parseDouble(console.nextLine()); // essa linha pode LANÇAR uma NumberFormatException
                valido = true;
            } catch (NumberFormatException ex) { // PEGA a NumberFormatException e trata ela
                System.out.println("Por favor, entre com um número válido...");
            }
        } while (!valido);

        // note que, para a leitura do operador, não há necessidade de se usar exceções para o tratamento de erro
        String op = "";
        valido = false;
        do {
            System.out.print("Operação: ");
            op = console.nextLine();
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                valido = true;
            } else {
                System.out.println("Por favor, entre com um operador válido (+, -, *, /)...");
            }
        } while (!valido);

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
        }

        System.out.println(n1 + " " + op + " " + n2 + " = " + resultado);
    }

}
