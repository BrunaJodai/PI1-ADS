package Exercicios;

import java.util.Scanner;

public class Salario1 {
    public static void main (String[]args) {
        Scanner leitor = new Scanner (System.in);
        
        System.out.print("Nome do funcionário: ");
        String func = leitor.nextLine();
        System.out.print("Quantidade de horas trabalhadas: ");
        int qntd = leitor.nextInt();
        System.out.print("Valor da hora de trabalho: ");
        double valor = leitor.nextDouble();
                
        double sal = valor*qntd;
        
        System.out.printf("O funcionário %s trabalhou %d horas por R$ %.2f e deve receber R$ %.2f.\n"
                ,func ,qntd ,valor ,sal);
    }
    
}
