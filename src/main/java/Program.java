import model.Entities.impl.Account;
import model.Entities.impl.AccountTransaction;
import model.services.dao.impl.AccountJDBC;
import model.services.dao.impl.LogTransactionJDBC;
import model.services.database.DB;
import java.sql.Connection;

public class Program {
    public static void main(String[] args){
        Connection pg = DB.getConnection();
        AccountJDBC accountJDBC = new AccountJDBC(pg);

        Account acc1 = accountJDBC.findById(105);
        Account acc2 = accountJDBC.findById(106);
        Account acc3 = accountJDBC.findById(107);
        Account acc4 = accountJDBC.findById(108);

//        Account acc1 = new Account("Joao","9001002345",2000.0);
//        Account acc2 = new Account("Maria","1258976435",500.0);
//        Account acc3 = new Account("Joaquim","3125897643",1500.0);
//        Account acc4 = new Account("Helena","2548976435",1500.0);
//
//        accountJDBC.insert(acc1);
//        accountJDBC.insert(acc2);
//        accountJDBC.insert(acc3);
//        accountJDBC.insert(acc4);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);

        LogTransactionJDBC logTransactionJDBC = new LogTransactionJDBC(pg,acc1,acc2);
        LogTransactionJDBC logTransactionJDBC2 = new LogTransactionJDBC(pg,acc3,acc4);

        AccountTransaction.transfer(logTransactionJDBC, accountJDBC, acc1, acc2, 300.0);
        AccountTransaction.transfer(logTransactionJDBC2, accountJDBC, acc3, acc4, 300.0);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);


    }
}