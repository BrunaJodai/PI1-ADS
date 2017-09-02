package Exercicios;

import java.util.Scanner;

public class CodigoMorse {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String cod, cod1 = "", letra;

        System.out.print("Digite o texto: ");
        String text = console.nextLine();

        for (int i = 0; i < text.length(); i++) {
            letra = text.substring(i, i + 1);

            letra = letra.toUpperCase();

            switch (letra) {
                case "A":
                    cod = ".-";
                    break;
                case "B":
                    cod = "-...";
                    break;
                case "C":
                    cod = "-.-.";
                    break;
                case "D":
                    cod = "-..";
                    break;
                case "E":
                    cod = ".";
                    break;
                case "F":
                    cod = "..-.";
                    break;
                case "G":
                    cod = "--.";
                    break;
                case "H":
                    cod = "....";
                    break;
                case "I":
                    cod = "..";
                    break;
                case "J":
                    cod = ".---";
                    break;
                case "K":
                    cod = ".-..";
                    break;
                case "L":
                    cod = ".-..";
                    break;
                case "M":
                    cod = "--";
                    break;
                case "N":
                    cod = "-.";
                    break;
                case "O":
                    cod = "---";
                    break;
                case "P":
                    cod = ".--.";
                    break;
                case "Q":
                    cod = "--.-";
                    break;
                case "R":
                    cod = ".-.";
                    break;
                case "S":
                    cod = "...";
                    break;
                case "T":
                    cod = "-";
                    break;
                case "U":
                    cod = "..-";
                    break;
                case "V":
                    cod = "...-";
                    break;
                case "W":
                    cod = ".--";
                    break;
                case "X":
                    cod = "-..-";
                    break;
                case "Y":
                    cod = "-.--";
                    break;
                case "Z":
                    cod = "--..";
                    break;
                case "1":
                    cod = ".----";
                    break;
                case "2":
                    cod = "..---";
                    break;
                case "3":
                    cod = "...--";
                    break;
                case "4":
                    cod = "....-";
                    break;
                case "5":
                    cod = ".....";
                    break;
                case "6":
                    cod = "-....";
                    break;
                case "7":
                    cod = "--...";
                    break;
                case "8":
                    cod = "---..";
                    break;
                case "9":
                    cod = "----.";
                    break;
                case "0":
                    cod = "-----";
                    break;
                case " ":
                    cod = "  ";
                    break;
                default:
                    cod = letra;
                    break;
            }
            cod1 = cod1 + " " + cod;
        }
        System.out.println(cod1);
    }
}
