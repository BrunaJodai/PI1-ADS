package Conecta4;

//Resolução Prof Ramon
import java.util.Random;

public class ProgramFuncoes_versaoProf {

    // exemplo de variável GLOBAL, ou seja, ela está disponível para todas as funções! PERIGO!!!
    public static Random rng = new Random();

    public static void main(String[] args) {
        String[][] tabuleiro = new String[6][7];

        iniciaTabuleiro(tabuleiro);
        colocaJogadaEmPosicaoAleatoria(tabuleiro);
        imprimeTabuleiro(tabuleiro);
    }

    public static void iniciaTabuleiro(String[][] tabuleiro) {
        // inicia o tabuleiro inteiro com "."
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = "□";
            }
        }
    }

    public static void colocaJogadaEmPosicaoAleatoria(String[][] tabuleiro) {
        // sorteia uma posicao:
        int linha = rng.nextInt(tabuleiro.length);
        int coluna = rng.nextInt(tabuleiro[linha].length);
        // coloca um "#" na posição sorteada:
        tabuleiro[linha][coluna] = "#";
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
}