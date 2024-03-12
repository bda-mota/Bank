package co.beatrizmota.bank;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");

        while (true) {
            System.out.println("O que deseja fazer? C=criar uma conta, E=sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome: ");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);
                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }
    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Qual operação deseja fazer? D=depósito, S=saque, E=sair da conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Não foi possível prosseguir com a solicitação");
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido");
            }
            scanner = new Scanner(System.in);
        }
    }
}
