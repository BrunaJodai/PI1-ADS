/* Escreva um algoritmo que calcula um valor aproximado para \pi usando a série desenvolvida por Leibniz
(dica: você irá precisar calcular a série com pelo menos 10000 termos).*/

package Exercicios;

import java.util.Scanner;

public class CalculoDoPi {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int pi = 0, pi2 = 0, num = 1;

        for (int i = 1; i <= 10000; i++) {
            
            num = 1/(num + 2);
            
            if (i%2==0) {
                pi = pi + num; 
            }
            if (i%2!=0) {
                pi = pi - num; 
            }
        }
        System.out.println("Valor de pi: " +pi);
    }
}
