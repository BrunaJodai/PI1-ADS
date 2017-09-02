/* utilizando somente uma linha de comando */
package Exercicios;

import java.util.Scanner;

public class TransporteMateriais_v3 {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        
        System.out.print("Tipo de material (A-D): ");
        String tipo = console.nextLine();
        tipo = tipo.toUpperCase();
        System.out.print("Temperatura no transporte (ºC): ");
        double temp = Double.parseDouble(console.nextLine());
        
        if (tipo.equals ("A") && temp >=10 && temp <=17 ||
                tipo.equals("B") && temp >=11 && temp <=16 ||
                tipo.equals ("C") && temp >=12 && temp<=15 ||
                tipo.equals("D") && temp >=13 && temp <=14){          
            System.out.println("Pode transportar.");
        } else {
            System.out.println("Não pode transportar.");
        }       
    }
}
