package Exercicios;

import java.util.Scanner;

public class TransporteMateriais_vfinal {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean podeTransportar = false;

        System.out.print("Tipo de material (A-D): ");
        String tipo = console.nextLine();
        System.out.print("Temperatura no transporte (ºC): ");
        double temp = Double.parseDouble(console.nextLine());

        tipo = tipo.toUpperCase();

        //processamento
        switch (tipo) {
            case "A":
                podeTransportar = (temp >= 10 && temp <= 17);
                break;
            case "B":
                podeTransportar = (temp >= 11 && temp <= 16);
                break;
            case "C":
                podeTransportar = (temp >= 12 && temp <= 15);
                break;
            case "D":
                podeTransportar = (temp >= 13 && temp <= 14);
                break;
        }

        //saída
        if (podeTransportar) {
            System.out.println("PODE TRANSPORTAR.");
        } else {
            System.out.println("NÃO PODE TRANSPORTAR.");
        }
    }
}