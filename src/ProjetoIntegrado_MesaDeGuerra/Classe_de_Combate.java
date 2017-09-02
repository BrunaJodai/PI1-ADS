package ProjetoIntegrado_MesaDeGuerra;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Classe_de_Combate {

    static Scanner entrada = new Scanner(System.in);

    static int escolhaPerso() {
        System.out.println("Irá começar o combate!");

        System.out.println("1 = Caçador;\n"
                + "2 = Guerreiro;\n"
                + "3 = Assassino.");
        System.out.print("Qual personagem você escolhe? ");
        int escolhaP = Integer.parseInt(entrada.nextLine());

        return escolhaP;
    }

    static int escolhaPC() {
        Random gerador = new Random();
        int escolhaPC = gerador.nextInt(3);

        escolhaPC = escolhaPC + 1;

        System.out.println("PC escolheu " + escolhaPC);

        return escolhaPC;
    }

    static void criaPerso(int escolhaP) {
        // definição de personagem escolhido
        int[] pEscolhido = new int[2];

        //variavel para validar escolha dos personagens
        boolean escolhaOK = false;
        do {
            switch (escolhaP) {

                case 1:
                    pEscolhido = criaCacador();
                    mostraArquivo("Personagem/mago.txt");
                    escolhaOK = true;
                    break;

                case 2:
                    pEscolhido = criaGuerreiro();
                    mostraArquivo("Personagem/warrior.txt");
                    escolhaOK = true;
                    break;

                case 3:
                    pEscolhido = criaAssassino();
                    mostraArquivo("Personagem/assassin.txt");
                    escolhaOK = true;
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    System.out.print("Qual personagem você escolhe? ");
                    escolhaP = Integer.parseInt(entrada.nextLine());
            }
        } while (escolhaOK != true);
    }

    public static void mostraArquivo(String arquivo) {
        try {
            Scanner leitor = new Scanner(new File(arquivo));

            boolean terminou = false;
            do {
                try {
                    String linha = leitor.nextLine();
                    System.out.println(linha);
                } catch (NoSuchElementException ex) {
                    terminou = true;
                }
            } while (!terminou);
        } catch (FileNotFoundException ex) {
            System.out.println("ARQUIVO NÃO ENCONTRADO! POR FAVOR, VERIFIQUE SEU CÓDIGO!!!");
        }
    }

    static int[] criaCacador() {
        //[0] é igual a HP e [1] força
        int[] caca = new int[2];

        caca[0] = 80;
        caca[1] = 100;

        return caca;
    }

    static int[] criaGuerreiro() {
        //[0] é igual a HP e [1] força
        int[] guer = new int[2];

        guer[0] = 150;
        guer[1] = 50;

        return guer;
    }

    static int[] criaAssassino() {
        //[0] é igual a HP e [1] força
        int[] assa = new int[2];

        assa[0] = 60;
        assa[1] = 110;

        return assa;
    }
    
    public static void main(String[] args) {
        int escolhaP = escolhaPerso();
       //cria personagem do p1
        criaPerso(escolhaP);

        int escolhaPC = escolhaPC();
        //cria personagem do pc
        criaPerso(escolhaPC);
    }
}
