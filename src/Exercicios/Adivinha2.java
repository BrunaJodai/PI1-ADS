/* Escreva um algoritmo que sorteia um número entre 1 e 10 (inclusos) e depois pede para o 
usuário tentar adivinhá-lo. Caso o número lido seja igual ao sorteado, mostre a mensagem 
“Você acertou em (Tentativas) tentativas!”. Caso contrário, mostre a mensagem “Você errou! 
O número é (Dica). Tente novamente!” e permita uma nova chance, mostrando uma dica se o número 
sorteado é (maior) ou (menor) ao lido. */
package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class Adivinha2 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random sorteio = new Random();
        int num = sorteio.nextInt(9);
        int tent = 0;
        int chute = 0;
        String dica = "maior";
        
        System.out.println("numero " +(num+1));

        do {
            System.out.print("Tente adivinhar o número sorteado: ");
            chute = Integer.parseInt(console.nextLine());
            tent = tent + 1;
            if (chute > num) {
                dica = "menor";
            }
            if (chute != (num + 1)) {
                System.out.printf("Você errou! O número é %s. Tente novamente!\n\n" ,dica);
            }
        } while (chute != (num + 1));
        System.out.println("Você acertou em " + tent + " tentativas!");
    }
}
