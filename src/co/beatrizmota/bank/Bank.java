package co.beatrizmota.bank;

import java.util.List;
import java.util.ArrayList;
public class Bank {
    private final String ag;
    private final List<Account> accounts;
    private int numberAccount = 1;

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public void insertAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public void outputTotal() {
        double total = 0;
        for (Account account : accounts){
            double balance = account.getBalance();
            total += balance;
        }
        System.out.println("O banco possui: " + total);
    }

    public Account generateAccount(String name){
        Account account = new Account(ag, "" + numberAccount, name);
        numberAccount++;
        return account;
    }

}
