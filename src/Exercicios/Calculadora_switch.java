package Exercicios;

import javax.swing.JOptionPane;

public class Calculadora_switch {

    public static void main(String[] args) {
        double result;
        double n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "CALCULADORA\nPrimeiro valor: "));
        String ope = JOptionPane.showInputDialog(null, "Operador: ");
        double n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Segundo valor: "));

        switch (ope) {
            case "+":
                result = n1 + n2;
                JOptionPane.showMessageDialog(null,
                        String.format("Resultado:\n %.2f %s %.2f = %.2f", n1, ope, n2, result));
                break;
            case "-":
                result = n1 - n2;
                JOptionPane.showMessageDialog(null,
                        String.format("Resultado:\n %.2f %s %.2f = %.2f", n1, ope, n2, result));
                break;
            case "*":
                result = n1 * n2;
                JOptionPane.showMessageDialog(null,
                        String.format("Resultado:\n %.2f %s %.2f = %.2f", n1, ope, n2, result));
                break;
            case "/":
                result = n1 / n2;
                JOptionPane.showMessageDialog(null,
                        String.format("Resultado:\n %.2f %s %.2f = %.2f", n1, ope, n2, result));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operador inválido.");
        }

    }

}