package co.beatrizmota.bank;

import java.util.List;

public class Account {
    private static final int MAX_LENGTH = 12;
    private final String agency;
    private final String cc;
    private String name;
    private double balance;

    private final Log logger = new Log();

    public Account(String agency, String cc, String name){
        this.agency = agency;
        this.cc = cc;
        setName(name);
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public String toString(){
        return "User { " +
                "Agency = " + this.agency + ", " +
                "count = " + this.cc + ", " +
                "Name = " + this.name + ", " +
                "Saldo: " + this.balance + " }";
    }

    public void deposit(double value){
        balance += value;
        logger.out("DEPÓSITO - Seu novo saldo é de: " + balance);
    }
    public boolean withDraw(double value){
        if (balance < value){
            logger.out("SAQUE - Saldo insuficiente");
            return false;
        }
        balance -= value;
        logger.out("SAQUE - Seu novo saldo é de : " + balance);
        return true;
    }

    public double getBalance(){
        return balance;
    }
}
