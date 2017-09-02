package Exercicios;

import java.util.Scanner;

public class Salario2 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double valor, sal;

        System.out.print("Nome do funcionário: ");
        String func = leitor.nextLine();
        System.out.print("Nível: ");
        int nivel = leitor.nextInt();
        System.out.print("Quantidade de horas trabalhadas: ");
        int qntd = leitor.nextInt();

        if (nivel == 1) {
            valor = 15;
            sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
        } else if (nivel == 2) {
            valor = 18;
            sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
        } else if (nivel == 3) {
            valor = 22;
            sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
        } else if (nivel == 4) {
            valor = 27;
            sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
        } else if (nivel == 5) {
            valor = 33;
            sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
        } else {
            System.out.println("Nível inválido.");
        }
    }
}
