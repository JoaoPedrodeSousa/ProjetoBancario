package main.Entities;

import dao.AccountDao;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountTransaction implements Transaction{

    private final Connection conn;
    public AccountTransaction(Connection conn, AccountDao accountDao, IOperationsAccount from, IOperationsAccount to, Double value) {
        this.conn = conn;
        transfer(accountDao, from, to, value);
    }

    @Override
    public void transfer(AccountDao accountDao, IOperationsAccount from, IOperationsAccount to, Double value) {
        try {
            conn.setAutoCommit(false);
            from.withdraw(value);
            to.Deposit(value);
            accountDao.update((Account) from);
            accountDao.update((Account) to);

            conn.commit();
        }
        catch (SQLException e){

           try {
                conn.rollback();
            }

            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
           finally {
               e.getStackTrace();
           }
        }
    }
}
