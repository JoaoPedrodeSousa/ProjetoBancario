package main;

import main.Entities.Account;

public class Program {
    public static void main(String[] args){

        Account acc1 = new Account("Josue","1234567890",500);

        System.out.println(acc1.getBalance());
        acc1.Deposit(1000);
        System.out.println(acc1.getBalance());
        acc1.withdraw(450);
        System.out.println(acc1.getBalance());
    }
}
