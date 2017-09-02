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
( ) combate entre os personagens
( ) quando um personagem morrer, sumir do tabuleiro
( ) jogo parar quando tiver um vencedor
( ) organizar o main
( ) timer *BÔNUS
( ) arrumar combate na linha 0 e coluna 0
(x) mostrar hp e attack
(x) conferir se tem todas as possibilidades de combate
( ) parte gráfica *BÔNUS
 */
package ProjetoIntegrado_MesaDeGuerra;

import java.util.Scanner;

public class jogo_MesaDeGuerra_V1J {

    static String[][] tab = new String[7][7];//  matriz/tabuleiro

    //personagens {attack, hp}
    static int[] caca1 = {80, 100};
    static int[] caca2 = {80, 100};
    static int[] guer1 = {50, 150};
    static int[] guer2 = {50, 150};
    static int[] assa1 = {60, 110};
    static int[] assa2 = {60, 110};

    /*Personagens (imagem do personagens no tabuleiro)*/
    static String c1 = "C1 ";
    static String c2 = "C2 ";
    static String g1 = "G1 ";
    static String g2 = "G2 ";
    static String a1 = "A1 ";
    static String a2 = "A2 ";

    static boolean deathC1 = false;
    static boolean deathA1 = false;
    static boolean deathG1 = false;
    static boolean deathC2 = false;
    static boolean deathA2 = false;
    static boolean deathG2 = false;


    public static void main(String[] args) {
        tab = createTab(); //Essa função "cria o tabuleiro" dando um valor inicial para todos os campos

        tab[0][1] = c1;//Posição inicial do personagem caca1
        tab[0][3] = g1;//Posição inicial do personagem guer1
        tab[0][5] = a1;//Posição inicial do personagem assa1
        tab[6][1] = c2;//Posição inicial do personagem caca2
        tab[6][3] = g2;//Posição inicial do personagem guer2
        tab[6][5] = a2;//Posição inicial do personagem assa2

        int i = 0;
        int player = 0;
        String vencedor = "ninguém";

        while (i < 20) {

            System.out.println("(" + i + ")");
            player = deQuemEAVez(player);
            Mostrar(player);

            deathP1();
            deathP2();
            

            vezPersonagem(player);

            lutinha(); // função em que o combate acontece, utiliza as variáveis globais
            
            vencedor = vencedor(vencedor);
            if (!vencedor.equals("ninguém")) {
                break;
            }
            i++;
        }        
        
    }

    static void vezPersonagem(int player) {
        String personagem = ""; //A variavel personagem, vai receber o valor do personagem que deve ser movimentado

        /* Esse FOR vai ter como parametro 'deQuemEAVez'(player1 ou player2), 
            e só vai sair depois que os três personagens do player terem se movimentado no tabuleiro */
        for (int k = 0; k < 3; k++) {
//                

            if (player == 1) {
                if (deathC1) {
                    k = k + 1;
                }
                if (deathG1) {
                    k = k + 1;
                }
                if (deathA1) {
                    k = k + 1;
                }
                //0 = C1 // 1 = G1 // 2 = A1
                switch (k) {
                    case 0:
                        personagem = c1;
                        System.out.println("Personagem c1: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + caca1[0] + " Vida: " + caca1[1]);
                        break;
                    case 1:
                        personagem = g1;
                        System.out.println("Personagem g1: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + guer1[0] + " Vida: " + guer1[1]);
                        break;

                    case 2:
                        personagem = a1;
                        System.out.println("Personagem a1: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + assa1[0] + " Vida: " + assa1[1]);
                        break;
                }
            } else {
                if (deathC2) {
                    k = k + 1;
                }
                if (deathG2) {
                    k = k + 1;
                }
                if (deathA2) {
                    k = k + 1;
                }
                //0 = C2 // 1 = G2 // 2 = A1
                switch (k) {
                    case 0:
                        personagem = c2;
                        System.out.println("Personagem c2: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + caca2[0] + " Vida: " + caca2[1]);
                        break;
                    case 1:
                        personagem = g2;
                        System.out.println("Personagem g2: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + guer2[0] + " Vida: " + guer2[1]);
                        break;
                    case 2:
                        personagem = a2;
                        System.out.println("Personagem a2: " + personagem);//Mostrando qual personagem vai ser movimentado
                        System.out.println("Força: " + assa2[0] + " Vida: " + assa2[1]);
                        break;
                }

            }

            int getL = getLine(personagem, player);//pegando os indices (linha) em que o personagem está localizado
            int getC = getColum(personagem, player);//pegando os indices (coluna)em que o personagem está localizado

            tab = movimentPersona(getL, getC, personagem, player); // movimentando o personagem no tabuleiro
            Mostrar(player);

        }
    }

    static String status() {
        String status = " aaa ";

        return status;
    }

    static void lutinha() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                /*if (i == 0) {
                    i = 1;
                }
                if (j == 0) {
                    j = 1;
                }*/
                if (!tab[i][j].equals(" . ")) {
                    if (!tab[i - 1][j].equals(" . ")) {
                        String P1 = tab[i - 1][j];
                        String P2 = tab[i][j];

                        System.out.println("--- COMBATE ---");
                        System.out.println(P1 + P2);

                        if (P1.equals("C1 ") && !deathC1) {
                            if (P2.equals("C2 ") && !deathC2) {
                                caca1[1] = caca1[1] - caca2[0];
                                caca2[1] = caca2[1] - caca1[0];
                                System.out.printf("C1 - %dhp = %d\n", caca2[0], caca1[1]);
                                System.out.printf("C2 - %dhp = %d\n", caca1[0], caca2[1]);

                            } else if (P2.equals("A2 ") && !deathA2) {
                                caca1[1] = caca1[1] - assa2[0];
                                assa2[1] = assa2[1] - caca1[0];
                                System.out.printf("C1 -%dhp = %d\n", assa2[0], caca1[1]);
                                System.out.printf("A2 -%dhp = %d\n", caca1[0], assa2[1]);

                            } else if (P2.equals("G2 ") && !deathG2) {
                                caca1[1] = caca1[1] - guer2[0];
                                guer2[1] = guer2[1] - caca1[0];
                                System.out.printf("C1 -%dhp = %d\n", guer2[0], caca1[1]);
                                System.out.printf("G2 -%dhp = %d\n", caca1[0], guer2[1]);

                            }
                        } else if (P1.equals("A1 ") && !deathA1) {
                            if (P2.equals("C2 ") && !deathC2) {
                                assa1[1] = assa1[1] - caca2[0];
                                caca2[1] = caca2[1] - assa1[0];
                                System.out.printf("A1 -%dhp = %d\n", caca2[0], assa1[1]);
                                System.out.printf("C2 -%dhp = %d\n", assa1[0], caca2[1]);

                            } else if (P2.equals("A2 ") && !deathA2) {
                                assa1[1] = assa1[1] - assa2[0];
                                assa2[1] = assa2[1] - assa1[0];
                                System.out.printf("A1 -%dhp = %d\n", assa2[0], assa1[1]);
                                System.out.printf("A2 -%dhp = %d\n", assa1[0], assa2[1]);

                            } else if (P2.equals("G2 ") && !deathG2) {
                                assa1[1] = assa1[1] - guer2[0];
                                guer2[1] = guer2[1] - assa1[0];
                                System.out.printf("A1 -%dhp = %d\n", guer2[0], assa1[1]);
                                System.out.printf("G2 -%dhp = %d\n", assa1[0], guer2[1]);

                            }
                        } else if (P1.equals("G1 ") && !deathG1) {
                            if (P2.equals("C2 ") && !deathC2) {
                                guer1[1] = guer1[1] - caca2[0];
                                caca2[1] = caca2[1] - guer1[0];
                                System.out.printf("G1 -%dhp = %d\n", caca2[0], guer1[1]);
                                System.out.printf("C2 -%dhp = %d\n", guer1[0], caca2[1]);

                            } else if (P2.equals("A2 ") && !deathA2) {
                                guer1[1] = guer1[1] - assa2[0];
                                assa2[1] = assa2[1] - guer1[0];
                                System.out.printf("G1 -%dhp = %d\n", assa2[0], guer1[1]);
                                System.out.printf("A2 -%dhp = %d\n", guer1[0], assa2[1]);

                            } else if (P2.equals("G2 ") && !deathG2) {
                                guer1[1] = guer1[1] - guer2[0];
                                guer2[1] = guer2[1] - guer1[0];
                                System.out.printf("G1 -%dhp = %d\n", guer2[0], guer1[1]);
                                System.out.printf("G2 -%dhp = %d\n", guer1[0], guer2[1]);

                            }
                        } else if (P1.equals("C2 ") && !deathC2) {
                            if (P2.equals("C1 ") && !deathC1) {
                                caca2[1] = caca2[1] - caca1[0];
                                caca1[1] = caca1[1] - caca2[0];
                                System.out.printf("C2 - %dhp = %d\n", caca1[0], caca2[1]);
                                System.out.printf("C1 - %dhp = %d\n", caca2[0], caca1[1]);

                            } else if (P2.equals("A1 ") && !deathA1) {
                                caca2[1] = caca2[1] - assa1[0];
                                assa1[1] = assa1[1] - caca2[0];
                                System.out.printf("C2 -%dhp = %d\n", assa1[0], caca2[1]);
                                System.out.printf("A1 -%dhp = %d\n", caca2[0], assa1[1]);

                            } else if (P2.equals("G1 ") && !deathG1) {
                                caca2[1] = caca2[1] - guer1[0];
                                guer1[1] = guer1[1] - caca2[0];
                                System.out.printf("C2 -%dhp = %d\n", guer1[0], caca2[1]);
                                System.out.printf("G1 -%dhp = %d\n", caca2[0], guer1[1]);

                            }
                        } else if (P1.equals("A2 ") && !deathA2) {
                            if (P2.equals("C1 ") && !deathC1) {
                                assa2[1] = assa2[1] - caca1[0];
                                caca1[1] = caca1[1] - assa2[0];
                                System.out.printf("A2 -%dhp = %d\n", caca1[0], assa2[1]);
                                System.out.printf("C1 -%dhp = %d\n", assa2[0], caca1[1]);

                            } else if (P2.equals("A1 ") && !deathA1) {
                                assa1[1] = assa1[1] - assa2[0];
                                assa2[1] = assa2[1] - assa1[0];
                                System.out.printf("A2 -%dhp = %d\n", assa1[0], assa2[1]);
                                System.out.printf("A1 -%dhp = %d\n", assa2[0], assa1[1]);

                            } else if (P2.equals("G1 ") && !deathG1) {
                                assa2[1] = assa2[1] - guer1[0];
                                guer1[1] = guer1[1] - assa2[0];
                                System.out.printf("A2 -%dhp = %d\n", guer1[0], assa2[1]);
                                System.out.printf("G1 -%dhp = %d\n", assa2[0], guer1[1]);

                            }
                        } else if (P1.equals("G2 ") && !deathG2) {
                            if (P2.equals("C1 ") && !deathC1) {
                                guer2[1] = guer2[1] - caca1[0];
                                caca1[1] = caca1[1] - guer2[0];
                                System.out.printf("G2 -%dhp = %d\n", caca1[0], guer2[1]);
                                System.out.printf("C1 -%dhp = %d\n", guer2[0], caca1[1]);

                            } else if (P2.equals("A1 ") && !deathA1) {
                                guer2[1] = guer2[1] - assa1[0];
                                assa1[1] = assa1[1] - guer2[0];
                                System.out.printf("G2 -%dhp = %d\n", assa1[0], guer2[1]);
                                System.out.printf("A1 -%dhp = %d\n", guer2[0], assa1[1]);

                            } else if (P2.equals("G1 ") && !deathG1) {
                                guer2[1] = guer2[1] - guer1[0];
                                guer1[1] = guer1[1] - guer2[0];
                                System.out.printf("G2 -%dhp = %d\n", guer1[0], guer2[1]);
                                System.out.printf("G1 -%dhp = %d\n", guer2[0], guer1[1]);

                            }

                        }

                        System.out.println("DEATH C1: " + deathC1);
                        System.out.println("DEATH A1: " + deathA1);
                        System.out.println("DEATH G1: " + deathG1);
                        System.out.println("DEATH C2: " + deathC2);
                        System.out.println("DEATH A2: " + deathA2);
                        System.out.println("DEATH G2: " + deathG2);
                    }
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
                }

            }
        }

    }
    //função para verificar se o personagem está morto

    static void deathP1() {
        //boolean deathC1 = false;
        if (caca1[1] <= 0) {
            deathC1 = true;
            c1 = " X ";
        }
        if (assa1[1] <= 0) {
            deathA1 = true;
            a1 = " X ";
        }
        if (guer1[1] <= 0) {
            deathG1 = true;
            g1 = " X ";
        }
    }

    static void deathP2() {
        if (caca2[1] <= 0) {
            deathC2 = true;
            c2 = " X ";
        }
        if (assa2[1] <= 0) {
            deathA2 = true;
            a2 = " X ";
        }
        if (guer2[1] <= 0) {
            deathG2 = true;
            g2 = " X ";
        }
    }

    static String vencedor(String vencedor) {
     
        if (deathC2 && deathA2 && deathG2) {
            vencedor = "PLAYER 1";
            System.out.println("PLAYER 1 VENCEU! PARABÉNS");
        } 
        if (deathC1 && deathA1 && deathG1) {
            System.out.println("PLAYER 2 VENCEU! PARABÉNS");
            vencedor = "PLAYER 2";
        } 
        if (deathC2 && deathA2 && deathG2 && deathC1 && deathA1 && deathG1) {
            System.out.println("EMPATE!");
            vencedor = "EMPATE";
        }
        
        return vencedor;
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
        //De quem é a vez: player1 ou player2?
        if (vez == 1) {
            vez = 2;
        } else {
            vez = 1;
        }
        return vez;
    }

    static int getLine(String personagem, int vez) {
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

    static int getColum(String personagem, int vez) {
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

    static String[][] movimentPersona(int getL, int getC, String personagem, int vez) {
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
            //se o personagem não estiver morto, mover

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
            jogador = "PLAYER 1";

        } else {
            jogador = "PLAYER 2";
        }
        System.out.println(jogador);

    }

}
