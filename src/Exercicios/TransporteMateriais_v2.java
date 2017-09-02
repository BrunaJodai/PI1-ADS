/* vários formas de usar switch e if, sem colocar a saída no processamento
já deixa declarado que o boolean podeTransportar = false, assim não é necessário colocar default*/
package Exercicios;

import java.util.Scanner;

public class TransporteMateriais_v2 {

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
                if (temp >= 10 && temp <= 17) {
                    podeTransportar = true;
                } else {
                    podeTransportar = false;
                }
                break;
            //lógica inversa    
            case "B":
                if (temp < 11 || temp > 16) {
                    podeTransportar = false;
                } else {
                    podeTransportar = true;
                }
                break;
            //sem o uso do if    
            case "C":
                podeTransportar = (temp >= 12 && temp <= 15);
                break;
            //sem o uso do if com a lógica inversa
            case "D":
                podeTransportar = !(temp < 13 || temp > 14);
                break;
        }

        //saída
        if (podeTransportar) {
            System.out.println("Pode transportar.");
        } else {
            System.out.println("Não pode transportar.");
        }
    }
}