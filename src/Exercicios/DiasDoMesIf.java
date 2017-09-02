package Exercicios;

import java.util.Scanner;

public class DiasDoMesIf {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Digite o mês (1-12): ");
        int mes = Integer.parseInt(console.nextLine());

        if (mes == 2) {
            System.out.printf("O mês %d tem 28 dias.\n", mes);
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7
                || mes == 8 || mes == 10 || mes == 12) {
            System.out.printf("O mês %d tem 31 dias.\n", mes);
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            System.out.printf("O mês %d tem 30 dias.\n", mes);
        } else {
            System.out.println("Mês inválido.");
        }
    }
}
