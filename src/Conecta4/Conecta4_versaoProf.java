/* Desenvolva o jogo Conecta-4 usando, também, os conceitos de tratamento de erros, 
funções e matrizes.
O Conecta-4 é um jogo de tabuleiro parecido com o Jogo-da-Velha. As diferenças são:
Joga-se em um tabuleiro de 6 linhas por 7 colunas;
Ganha que faz uma linha, coluna ou diagonal de 4 peças;
Não se pode jogar em qualquer linha. Escolhe-se uma coluna e sua peça é colocada nessa 
coluna "caindo" até a posição disponível. 

Resolução Prof Ramon*/
package Conecta4;

import java.util.Scanner;

public class Conecta4_versaoProf {
    

    //tabuleiro inicial
    public static void tabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = "□";
            }
        }
    }

    // entrada da coluna desejada pra jogada
    public static int coluna() {
        Scanner console = new Scanner(System.in);
        System.out.print("Coluna desejada: ");
        int coluna = Integer.parseInt(console.nextLine());
        return coluna;
    }

    //verifica em qual linha vai cair
    public static int verificaLinha() {
        int coluna = coluna();
        int linha = 0;
        switch (coluna) {
            case 1:
                linha = linha + 1;
                break;
            case 2:
                linha = linha + 1;
                break;
            case 3:
                linha = linha + 1;
                break;
            case 4:
                linha = linha + 1;
                break;
            case 5:
                linha = linha + 1;
                break;
            case 6:
                linha = linha + 1;
                break;
            case 7:
                linha = linha + 1;
                break;
        }
        return linha;
    }
    
    // verifica de quem é a vez
    public static String jogador () {
        int cont = 0;
                String jogador = "0";
        if (cont%2 ==0) {
            jogador = "X";
        } else {
            jogador = "#";
        }
        return jogador;
    }

    // coloca o simbolo na coluna que o jogador escolheu
    public static void jogada(String[][] tabuleiro) {
        int coluna = coluna();
        int linha = verificaLinha();

        // coloca um "X" na posição:
        tabuleiro[linha][coluna] = jogador();
    }
    
    public static void imprimeTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            // imprime a linha i:
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println(); // para cada linha impressa, pula uma
        }
    }
    
    //verifica qm é vencedor
    public static String vencedor (){
        String vencedor= "";
        int jog = 0;
        if (jog==0) {
            vencedor = "X";
        }
        return vencedor;
    }

    public static void main(String[] args) {
        String[][] tabuleiro = new String[6][7];
        String vencedor = vencedor();

        while (!vencedor.equals("#") || !vencedor.equals ("X")) {
            System.out.println(coluna());
            
            if (vencedor.equals("#") || vencedor.equals ("X")) {
                System.out.println("O vencedor é " +vencedor);
                break;
            }
            
        }
        
        tabuleiro (tabuleiro);
        jogada (tabuleiro);
        imprimeTabuleiro(tabuleiro);
    }

}
