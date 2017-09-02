/*
PROJETO 1º SEMESTRE DE ANÁLISE E DESENVOLVIMENTO DE SISTEMAS 2017
jogo: MESA DE GUERRA
deselvolvido por:
                    Bruna Sayuri
                    Bruno Oliveira
                    Jonas Araújo
                    Luana Monteiro
                    Nicolas Costa
professor: Ramon

CHECK LIST
(x) um não comer o outro
(x) mover os três personagens numa mesma rodada
(  ) combate entre os personagens
(  ) quando um personagem morrer, sumir do tabuleiro
(  ) jogo parar quando tiver um vencedor
(  ) organizar o main
(  ) timer
(  ) arrumar combate na linha 0 e coluna 0
(  ) mostrar hp e attack
(  ) conferir se tem todas as possibilidades de combate
(  ) parte gráfica *BÔNUS
 */
package ProjetoIntegrado_MesaDeGuerra;

import java.util.Scanner;

public class MesaDeGuerra {

    static String[][] tab = new String[7][7];//  matriz/tabuleiro

    //personagens {atack, hp}
    static int[] caca1 = {80, 100};
    static int[] caca2 = {80, 100};
    static int[] guer1 = {50, 150};
    static int[] guer2 = {50, 150};
    static int[] assa1 = {60, 110};
    static int[] assa2 = {60, 110};

    public static void main(String[] args) {
        tab = createTab(); //Essa função "cria o tabuleiro" dando um valor inicial para todos os campos

        /*Personagens (imagem do personagens no tabuleiro)*/
        String c1 = "C1 ";
        String c2 = "C2 ";
        String g1 = "G1 ";
        String g2 = "G2 ";
        String a1 = "A1 ";
        String a2 = "A2 ";

        tab[0][1] = c1;//Posição inicial do personagem caca1
        tab[0][3] = g1;//Posição inicial do personagem guer1
        tab[0][5] = a1;//Posição inicial do personagem assa1
        tab[6][1] = c2;//Posição inicial do personagem caca2
        tab[6][3] = g2;//Posição inicial do personagem guer2
        tab[6][5] = a2;//Posição inicial do personagem assa2

        int i = 0;
        int player = 0;

        while (i < 10) {//mudar a lógica do while para (repetir isso enquanto não houver um vencedor).
            System.out.println("(" + i + ")");
            player = deQuemEAVez(player);
            Mostrar(player);

            /* Esse FOR vai ter como parametro 'deQuemEAVez'(player1 ou player2), 
            e só vai sair depois que os três personagens do player terem se movimentado no tabuleiro */
            String personagem = ""; //A variavel personagem, vai receber o valor do personagem que deve ser movimentado
            for (int k = 0; k < 3; k++) {
                if (player == 1) {
                    switch (k) {
                        case 0:
                            personagem = c1;
                            break;
                        case 1:
                            personagem = g1;
                            break;

                        case 2:
                            personagem = a1;
                            break;
                    }
                } else {
                    switch (k) {
                        case 0:
                            personagem = c2;
                            break;
                        case 1:
                            personagem = g2;
                            break;
                        case 2:
                            personagem = a2;
                            break;
                    }

                }

                System.out.println("Personagem: " + personagem);//Mostrando qual personagem vai ser movimentado

                int getL = getLine(tab, personagem, player);//pegando os indices (linha) em que o personagem está localizado
                int getC = getColum(tab, personagem, player);//pegando os indices (coluna)em que o personagem está localizado
                tab = movimentPersona(tab, getL, getC, personagem, player); // movimentando o personagem no tabuleiro
                Mostrar(player);
            }

            lutinha(tab, caca1, caca2, guer1, guer2, assa1, assa2); // função em que o combate acontece
            i++;
        }
    }

    /*static void lutinha(String[][] tab,  String c1, String c2, String g1, String g2, String a1, String a2) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i ==0 ) {
                    i = 1;
                } 
                if (j == 0) {
                    j = 1;
                }
                if (tab[i][j].equals(c1) || tab[i][j].equals(g1) || tab[i][j].equals(a1)) {
                    if (tab[i][j - 1].equals(c2) || tab[i][j + 1].equals(g2) || tab[i][j + 1].equals(a2)) {
                        System.out.println("É LUTINHA DE LADO!!!");
                    } else if (tab[i-1][j].equals(c2) || tab[i+1][j].equals(g2)  || tab[i+1][j].equals(a2)) {
                        System.out.println("É LUTINHA DE FRENTE!!!");
                    }
                } else if (tab[i][j].equals(c2) || tab[i][j].equals(g2) || tab[i][j].equals(a2)){
                    if (tab[i][j - 1].equals(c1) || tab[i][j + 1].equals(g1) || tab[i][j + 1].equals(a1)) {
                        System.out.println("É LUTINHA DE LADO!!!");
                    } else if (tab[i-1][j].equals(c1) || tab[i+1][j].equals(g1)  || tab[i+1][j].equals(a1)) {
                        System.out.println("É LUTINHA DE FRENTE!!!");
                    }
                }
            }
        }

    }*/
    //Tem como parâmetro os vetores, pq nós vamos usar eles para fazer as batalhas
    static void lutinha(String[][] tab, int[] caca1, int[] caca2, int[] guer1, int[] guer2, int[] assa1, int[] assa2) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i == 0) {
                    i = 1;
                }
                if (j == 0) {
                    j = 1;
                }
                if (!tab[i][j].equals(" . ")) {
                    // LUTA DE LADO POR ENQUANTO CANCELADO
                    /*if (!tab[i][j - 1].equals(" . ")) {
                        System.out.println("É LUTINHA DE LADO!!!");
                        String P1 = tab[i][j - 1];
                        String P2 = tab[i][j];

                        System.out.println(P1 + P2);

                        if (P1.equals("C1 ")) {
                            if (P2.equals("C2 ")) {
                                caca1[1] = caca1[1] - caca2[0];
                                caca2[1] = caca2[1] - caca1[0];
                                System.out.println("caçador1 hp " + caca1[1]);
                                System.out.println("caçador2 hp " + caca2[1]);

                            } else if (P2.equals("A2 ")) {

                            } else if (P2.equals("G2 ")) {

                            }
                        } else if (P1.equals("C2 ")) {
                            if (P2.equals("C1 ")) {

                            } else if (P2.equals("A1 ")) {

                            } else if (P2.equals("G1 ")) {
                            }
                        }
                    }*/
                    if (!tab[i - 1][j].equals(" . ")) {
                        String P1 = tab[i - 1][j];
                        String P2 = tab[i][j];

                        System.out.println(P1 + P2);
                        System.out.println("É LUTINHA DE FRENTE!!!");

                        if (P1.equals("C1 ")) {
                            if (P2.equals("C2 ")) {
                                caca1[1] = caca1[1] - caca2[0];
                                caca2[1] = caca2[1] - caca1[0];
                                System.out.println("caçador1 hp " + caca1[1]);
                                System.out.println("caçador2 hp " + caca2[1]);

                            } else if (P2.equals("A2 ")) {
                                caca1[1] = caca1[1] - assa2[0];
                                assa2[1] = assa2[1] - assa1[0];
                                System.out.println("caçador1 hp " + caca1[1]);
                                System.out.println("assasino2 hp " + assa2[1]);

                            } else if (P2.equals("G2 ")) {
                                caca1[1] = caca1[1] - guer2[0];
                                guer2[1] = guer2[1] - guer1[0];
                                System.out.println("caçador1 hp " + caca1[1]);
                                System.out.println("guerreiro2 hp " + guer2[1]);
                            }
                        } else if (P1.equals("A1 ")) {
                            if (P2.equals("C2 ")) {
                                assa1[1] = assa1[1] - caca2[0];
                                caca2[1] = caca2[1] - assa1[0];
                                System.out.println("assassino1 hp " + assa1[1]);
                                System.out.println("caçador2 hp " + caca2[1]);

                            } else if (P2.equals("A2 ")) {
                                assa1[1] = assa1[1] - assa2[0];
                                assa2[1] = assa2[1] - assa1[0];
                                System.out.println("assassino1 hp " + assa1[1]);
                                System.out.println("assassino2 hp " + assa2[1]);

                            } else if (P2.equals("G2 ")) {
                                assa1[1] = assa1[1] - guer2[0];
                                guer2[1] = guer2[1] - assa1[0];
                                System.out.println("assassino1 hp " + assa1[1]);
                                System.out.println("guerreiro2 hp " + guer2[1]);
                            }
                        } else if (P1.equals("G1 ")) {
                            if (P2.equals("C2 ")) {
                                guer1[1] = guer1[1] - caca2[0];
                                caca2[1] = caca2[1] - guer1[0];
                                System.out.println("guerreiro1 hp " + guer1[1]);
                                System.out.println("caçador2 hp " + caca2[1]);

                            } else if (P2.equals("A2 ")) {
                                guer1[1] = guer1[1] - assa2[0];
                                assa2[1] = assa2[1] - guer1[0];
                                System.out.println("guerreiro1 hp " + guer1[1]);
                                System.out.println("assassino2 hp " + assa2[1]);

                            } else if (P2.equals("G2 ")) {
                                guer1[1] = guer1[1] - guer2[0];
                                guer2[1] = guer2[1] - guer1[0];
                                System.out.println("guerreiro1 hp " + guer1[1]);
                                System.out.println("guerreiro2 hp " + guer2[1]);
                            }
                        }
                    }
                }
                /*else if (tab[i][j].equals(c2) || tab[i][j].equals(g2) || tab[i][j].equals(a2)){
                    if (tab[i][j - 1].equals(c1) || tab[i][j + 1].equals(g1) || tab[i][j + 1].equals(a1)) {
                        System.out.println("É LUTINHA DE LADO!!!");
                    } else if (tab[i-1][j].equals(c1) || tab[i+1][j].equals(g1)  || tab[i+1][j].equals(a1)) {
                        System.out.println("É LUTINHA DE FRENTE!!!");
                    }
                }*/
            }
        }

    }

    static String[][] createTab() {
        for (int line = 0; line < tab.length; line++) {
            for (int coluna = 0; coluna < tab[line].length; coluna++) {
                tab[line][coluna] = " . ";
            }
        }
        return tab;
    }

    static int deQuemEAVez(int vez) {
        /*De quem e a vez
        player1 ou player2? */
        if (vez == 1) {
            vez = 2;
        } else {
            vez = 1;
        }
        return vez;
    }

    static int getLine(String tab[][], String personagem, int vez) {
        int getL = 0;

        /*Player1*/
        if (vez == 1) {
            for (int line = 0; line < tab.length; line++) {
                for (int coluna = 0; coluna < tab[line].length; coluna++) {
                    if (tab[line][coluna].equals(personagem)) {
                        getL = line;
                    }
                }
            }

            /*Player2*/
        } else {
            for (int line = 0; line < tab.length; line++) {
                for (int coluna = 0; coluna < tab[line].length; coluna++) {
                    if (tab[line][coluna].equals(personagem)) {
                        getL = line;
                    }
                }
            }
        }

        return getL;
    }

    static int getColum(String tab[][], String personagem, int vez) {
        int getC = 0;

        /*Player1*/
        if (vez == 1) {
            for (int line = 0; line < tab.length; line++) {
                for (int coluna = 0; coluna < tab[line].length; coluna++) {
                    if (tab[line][coluna].equals(personagem)) {
                        getC = coluna;
                        tab[line][coluna] = " . ";
                    }
                }
            }

            /*Player2*/
        } else {
            for (int line = 0; line < tab.length; line++) {
                for (int coluna = 0; coluna < tab[line].length; coluna++) {
                    if (tab[line][coluna].equals(personagem)) {
                        getC = coluna;
                        tab[line][coluna] = " . ";
                    }
                }
            }
        }

        return getC;
    }

    static String[][] movimentPersona(String tab[][], int getL, int getC, String personagem, int vez) {
        Scanner console = new Scanner(System.in);
        String direcao;
        boolean posicaoValida;

        /*Player1*/
        if (vez == 1) {
            posicaoValida = false;
            do {

                posicaoValida = false;
                do {
                    System.out.print("Direção: ");
                    direcao = console.next();
                    direcao = direcao.toLowerCase();
                    //Verificando se direção é igual a (a/d/w/s)
                    if (direcao.equals("a") || direcao.equals("d") || direcao.equals("w") || direcao.equals("s")) {

                        /*Verificando se tem alguma coisa na posição em que o jogador quer jogar
                        e se a posição está dentro dos limites da matriz */
                        if (direcao.equals("w") && (getL - 1) >= 0 && tab[getL - 1][getC].equals(" . ") || direcao.equals("s") && (getL + 1) <= 6 && tab[getL + 1][getC].equals(" . ")) {
                            posicaoValida = true;
                        } else if (direcao.equals("a") && (getC - 1) >= 0 && tab[getL][getC - 1].equals(" . ") || direcao.equals("d") && (getC + 1) <= 6 && tab[getL][getC + 1].equals(" . ")) {
                            posicaoValida = true;
                        }
                    } else {
                        System.out.println("POSIÇÃO INVÁLIDA");
                        posicaoValida = false;
                    }
                } while (!posicaoValida);

                //Dando um novo valor para line e coluna diacordo com a direção escolhida pelo jogador
                switch (direcao) {
                    case "a":
                        getC -= 1;
                        break;
                    case "d":
                        getC += 1;
                        break;
                    case "w":
                        getL -= 1;
                        break;
                    case "s":
                        getL += 1;
                        break;
                }

            } while (!posicaoValida);
            tab[getL][getC] = personagem;//Nova posicao do personagem.

            /*Player2*/
        } else {
            posicaoValida = false;
            do {

                posicaoValida = false;
                do {
                    System.out.print("Direção: ");
                    direcao = console.next();
                    direcao = direcao.toLowerCase();

                    if (direcao.equals("a") || direcao.equals("d") || direcao.equals("w") || direcao.equals("s")) {

                        if (direcao.equals("w") && (getL - 1) >= 0 && tab[getL - 1][getC].equals(" . ") || direcao.equals("s") && (getL + 1) <= 6 && tab[getL + 1][getC].equals(" . ")) {
                            posicaoValida = true;
                        } else if (direcao.equals("a") && (getC - 1) >= 0 && tab[getL][getC - 1].equals(" . ") || direcao.equals("d") && (getC + 1) <= 6 && tab[getL][getC + 1].equals(" . ")) {
                            posicaoValida = true;
                        }
                    } else {
                        System.out.println("POSIÇÃO INVÁLIDA");
                        posicaoValida = false;
                    }
                } while (!posicaoValida);

                switch (direcao) {
                    case "a":
                        getC -= 1;
                        break;
                    case "d":
                        getC += 1;
                        break;
                    case "w":
                        getL -= 1;
                        break;
                    case "s":
                        getL += 1;
                        break;
                }

            } while (!posicaoValida);
            tab[getL][getC] = personagem;//Nova posicao do personagem.
        }
        return tab;
    }

    static void Mostrar(int player) {
        //Mostrando a tabela
        String lookTab = "              MESA DE GUERRA\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";
        lookTab += "| " + tab[0][0] + " | " + tab[0][1] + " | " + tab[0][2] + " | " + tab[0][3] + " | " + tab[0][4] + " | " + tab[0][5] + " | " + tab[0][6] + " |\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";
        lookTab += "| " + tab[1][0] + " | " + tab[1][1] + " | " + tab[1][2] + " | " + tab[1][3] + " | " + tab[1][4] + " | " + tab[1][5] + " | " + tab[1][6] + " |      ↑\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|      w\n";
        lookTab += "| " + tab[2][0] + " | " + tab[2][1] + " | " + tab[2][2] + " | " + tab[2][3] + " | " + tab[2][4] + " | " + tab[2][5] + " | " + tab[2][6] + " |  ←a    d→\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|      s\n";
        lookTab += "| " + tab[3][0] + " | " + tab[3][1] + " | " + tab[3][2] + " | " + tab[3][3] + " | " + tab[3][4] + " | " + tab[3][5] + " | " + tab[3][6] + " |      ↓\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";
        lookTab += "| " + tab[4][0] + " | " + tab[4][1] + " | " + tab[4][2] + " | " + tab[4][3] + " | " + tab[4][4] + " | " + tab[4][5] + " | " + tab[4][6] + " |\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";
        lookTab += "| " + tab[5][0] + " | " + tab[5][1] + " | " + tab[5][2] + " | " + tab[5][3] + " | " + tab[5][4] + " | " + tab[5][5] + " | " + tab[5][6] + " |\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";
        lookTab += "| " + tab[6][0] + " | " + tab[6][1] + " | " + tab[6][2] + " | " + tab[6][3] + " | " + tab[6][4] + " | " + tab[6][5] + " | " + tab[6][6] + " |\n";
        lookTab += "|-----|-----|-----|-----|-----|-----|-----|\n";

        System.out.println(lookTab);

        //Mostrando o jogador que tem a vez
        String jogador;
        if (player == 1) {
            jogador = "player1 ( '3' )";

        } else {
            jogador = "PLAYER2 ( ¬_¬ )";
        }
        System.out.println(jogador);

    }

}
