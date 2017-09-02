package Exercicios;

import java.util.Scanner;

public class PlanoCarreiraSwitch {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double valor=0;

        System.out.print("Nome do funcionário: ");
        String func = console.nextLine();
        System.out.print("Nível: ");
        int nivel = Integer.parseInt(console.nextLine());
        System.out.print("Quantidade de horas trabalhadas: ");
        int qntd = Integer.parseInt(console.nextLine());

        switch (nivel) {
            case 1:
                valor = 15;
                break;
            case 2:
                valor = 18;
                break;
            case 3:
                valor = 22;
                break;
            case 4:
                valor = 27;
                break;
            case 5:
                valor = 33;
                break;
            default:
                System.out.println("Nível inválido.");
        }
            double sal = qntd * valor;
            System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f (Nível %d) "
                    + "e deve receber R$ %.2f.\n", func, qntd, valor, nivel, sal);
    }
}