package main;

import dao.impl.AccountJDBC;
import main.Entities.Account;
import main.Entities.AccountTransaction;
import main.services.db.DB;

import java.sql.Connection;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException {

        AccountJDBC pg = new AccountJDBC(DB.getConnection());

        Account acc1 = new Account("Josue","1234567800",105.00);
        Account acc2 = new Account("Camila","0133456559",905.00);
        Account acc3 = new Account("Robson","9301239012",905.00);

        pg.insert(acc3);
        pg.insert(acc2);
        pg.insert(acc1);

//        acc3.withdraw(15.0);
//        acc2.Deposit(15.0);
//        pg.update(acc3);
//        pg.update(acc2);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);

        AccountTransaction accountTransaction = new AccountTransaction(DB.getConnection(),pg,acc1,acc2,50.0);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);

    }
}
