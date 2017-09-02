/* Escreva um programa em Java que lê o login e a senha de um usuário e valide sua autorização de acordo com a seguinte tabela:

Login	   Senha
guilherme  0f5
jair	   0706 */
package Exercicios;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String login, senha;

        System.out.print("Login: ");
        login = console.nextLine();

        System.out.print("Senha: ");
        senha = console.nextLine();

        if (login.equals("guilherme") && senha.equals("0f5") || login.equals("jair") && senha.equals("0706")) {
            System.out.println("Login e senha válidos. Acesso Autorizado.");
        } else {
            System.out.println("Login e/ou senha inválidos.");
        }
    }
}
