package Exercicios;

import javax.swing.JOptionPane;

public class DiasDoMesSwitch {

    public static void main(String[] args) {
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Mês (1-12):"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                JOptionPane.showMessageDialog(null, "O mês " + mes + " tem 31 dias.");
                break;
            case 2:
                if (ano % 4 == 0) {
                    JOptionPane.showMessageDialog(null, "O mês " + mes + " tem 29 dias.");
                } else {
                    JOptionPane.showMessageDialog(null, "O mês " + mes + " tem 28 dias.");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                JOptionPane.showMessageDialog(null, "O mês " + mes + " tem 30 dias.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }
}
