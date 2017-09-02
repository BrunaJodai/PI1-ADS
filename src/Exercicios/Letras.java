/* Escreva um programa que lê uma letra e mostra se ela é uma vogal ou consoante.*/
package Exercicios;

import javax.swing.JOptionPane;

public class Letras {

    public static void main(String[] args) {
        String letra = JOptionPane.showInputDialog("Digite a letra:");

        letra = letra.toUpperCase();

        switch (letra) {
            case "A":
            case "E":
            case "I":
            case "O":
            case "U":
                JOptionPane.showMessageDialog(null, letra+ " é uma vogal.");
                break;
            default:
                JOptionPane.showMessageDialog(null, letra +" é uma consoante.");
        }
    }
}
