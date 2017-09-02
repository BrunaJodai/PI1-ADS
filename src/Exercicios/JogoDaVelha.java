package Exercicios;

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String a = "1", b = "2", c = "3", d = "4", e = "5", f = "6", g = "7", h = "8", i = "9";
        int cont = 0;
        String jogadas = " ", posi = "0", vencedor = "EMPATE";

        //tabuleiro
        System.out.println("Posições no tabuleiro: ");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---|---|---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---|---|---");
        System.out.println(" 7 | 8 | 9 \n");

        //escolher
        System.out.print("Escolha entre X ou O: ");
        String jogador = console.nextLine();
        String jog = jogador.toUpperCase();

        if (jog.equals("X") || jog.equals("O")) {
            do {
                //vez de qm
                if (cont % 2 != 0 && jog.equals("X")) {
                    jog = "O";
                } else if (cont % 2 == 0 && jog.equals("O")) {
                    jog = "X";
                }
                System.out.println("VEZ " + jog);
                System.out.print("Posição: ");
                posi = console.nextLine();

                if (!jogadas.contains(posi)) {
                    if (posi.equals("1") || posi.equals("2") || posi.equals("3")
                            || posi.equals("4") || posi.equals("5") || posi.equals("6")
                            || posi.equals("7") || posi.equals("8") || posi.equals("9")) {
                        jogadas = jogadas + posi;
                        cont = cont + 1;

                        switch (posi) {
                            case "1":
                                a = jog;
                                break;
                            case "2":
                                b = jog;
                                break;
                            case "3":
                                c = jog;
                                break;
                            case "4":
                                d = jog;
                                break;
                            case "5":
                                e = jog;
                                break;
                            case "6":
                                f = jog;
                                break;
                            case "7":
                                g = jog;
                                break;
                            case "8":
                                h = jog;
                                break;
                            case "9":
                                i = jog;
                                break;
                        }

                        String tab = " " + a + " | " + b + " | " + c + "\n";
                        tab += "-----------\n";
                        tab += " " + d + " | " + e + " | " + f + "\n";
                        tab += "-----------\n";
                        tab += " " + g + " | " + h + " | " + i + "\n";

                        System.out.println(tab);

                        //linhas X
                        if (a.equals("X") && b.equals("X") && c.equals("X")
                                || d.equals("X") && e.equals("X") && f.equals("X")
                                || g.equals("X") && h.equals("X") && i.equals("X")) {
                            vencedor = "X";
                            break;
                            //linhas O
                        } else if (a.equals("O") && b.equals("O") && c.equals("O")
                                || d.equals("O") && e.equals("O") && f.equals("O")
                                || g.equals("O") && h.equals("O") && i.equals("O")) {
                            vencedor = "O";
                            break;
                            //colunas X
                        } else if (a.equals("X") && d.equals("X") && g.equals("X")
                                || b.equals("X") && e.equals("X") && h.equals("X")
                                || c.equals("X") && f.equals("X") && i.equals("X")) {
                            vencedor = "X";
                            break;
                            //colunas O
                        } else if (a.equals("O") && d.equals("O") && g.equals("O")
                                || b.equals("O") && e.equals("O") && h.equals("O")
                                || c.equals("O") && f.equals("O") && i.equals("O")) {
                            vencedor = "O";
                            break;
                            //diagonais X
                        } else if (a.equals("X") && e.equals("X") && i.equals("X")
                                || c.equals("X") && e.equals("X") && g.equals("X")) {
                            vencedor = "X";
                            break;
                            //diagonais O
                        } else if (a.equals("O") && e.equals("O") && i.equals("O")
                                || c.equals("O") && e.equals("O") && g.equals("O")) {
                            vencedor = "O";
                            break;
                        }
                    }
                } else {
                    System.out.println("Jogada inválida. Escolha outra posição.\n");
                }
            } while (cont < 9);
            System.out.println("VENCEDOR: " + vencedor);
        } else {
            System.out.println("Escolha inválida.");
        }
    }
}
