package main.Entities;

import java.util.Random;

public class Account implements IOperationsAccount{

    private String owner;
    private final String register;
    private Integer balance;

    public Account(String owner, Integer balance) {
        this.owner = owner;
        this.register = generateRegister();
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRegister() {
        return register;
    }

    public Integer getBalance() {
        return balance;
    }

    private String generateRegister() {
        String result = null;

        for(int i=0;i<10;i++){
            result += String
                    .valueOf(new Random().nextInt(10));;
        }

        return result;
    }

    @Override
    public void withdraw(Integer value) {
        balance -= value;
    }

    @Override
    public void Deposit(Integer value) {
        balance += value;
    }
}
