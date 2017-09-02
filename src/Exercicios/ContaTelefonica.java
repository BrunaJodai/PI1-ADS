package Exercicios;

import java.util.Scanner;

public class ContaTelefonica {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double assin = 23.32;
        double ll = 0.09;
        double ddd = 0.26;
        double ddi = 0.86;
        double mll, mddd, mddi, tll, tddd, tddi;

        System.out.print("Minutos gastos em ligações locais: ");
        mll = console.nextDouble();
        System.out.print("Minutos gastos em ligações interurbanas (DDD): ");
        mddd = console.nextDouble();
        System.out.print("Minutos gastos em ligações internacionais (DDI): ");
        mddi = console.nextDouble();

        System.out.println("--------------------------------------------------");
        System.out.println("Ligações locais = " + (tll = mll * ll));
        System.out.println("Ligações Interurbanas = " + (tddd = mddd * ddd));
        System.out.println("Ligações Internacionais = " + (tddi = mddi * ddi));
        System.out.println("TOTAL (incluindo assinatura) = " + (tll + tddd + tddi + assin));
    }
}
