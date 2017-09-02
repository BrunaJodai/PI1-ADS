/*neste algoritmo a saída está misturanda com o processamento (surge o problema de caso o cliente queira mudar a frase, 
seria necessário copiar e colar a frase em todos os cases.*/
package Exercicios;

import java.util.Scanner;

public class TransporteMateriais {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Tipo de material (A-D): ");
        String tipo = console.nextLine();
        System.out.print("Temperatura no transporte (ºC): ");
        double temp = Double.parseDouble(console.nextLine());

        switch (tipo.toUpperCase()) {
            case "A":
                if (temp >= 10 && temp <= 17) {
                    System.out.println("É possível fazer o transporte.");
                } else {
                    System.out.println("Não é possível fazer o transporte.");
                }
                break;
            case "B":
                if (temp >= 11 && temp <= 16) {
                    System.out.println("É possível fazer o transporte.");
                } else {
                    System.out.println("Não é possível fazer o transporte.");
                }
                break;
            case "C":
                if (temp >= 12 && temp <= 15) {
                    System.out.println("É possível fazer o transporte.");
                } else {
                    System.out.println("Não é possível fazer o transporte.");
                }
                break;
            case "D":
                if (temp >= 13 && temp <= 14) {
                    System.out.println("É possível fazer o transporte.");
                } else {
                    System.out.println("Não é possível fazer o transporte.");
                }
                break;
            default:
                System.out.println("Tipo de material inválido.");
        }
    }

}
