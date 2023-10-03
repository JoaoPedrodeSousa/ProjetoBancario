package main.Entities;

import java.util.Random;

public class Account implements IOperationsAccount{

    private String owner;
    private final String register;
    private Integer balance;

    public Account(String owner, String register) {
        this.owner = owner;
        this.register = register;
    }

    public Account(String owner, String register, Integer balance) {
        this.owner = owner;
        this.balance = balance;
        if(register.length() > 10 || register.length() < 10){
            throw new RuntimeException();
        }
        else {
            this.register = register;
        }
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


    @Override
    public void withdraw(Integer value) {
        balance -= value;
    }

    @Override
    public void Deposit(Integer value) {
        balance += value;
    }
}
