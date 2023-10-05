package main.Entities;

import dao.AccountDao;
import main.services.db.DB;
import main.services.db.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountTransaction {

    private static final Connection conn = DB.getConnection();

    public static void transfer(AccountDao accountDao, Account from, Account to, Double value) {
        if (value > from.getBalance()){
            throw new DbException("Nao eh possivel transerir esse valor, pois eh maior que o saldo disponivel do cliente!");
        }

        try {
            conn.setAutoCommit(false);

            from.withdraw(value);
            to.deposit(value);
            accountDao.update(from);
            accountDao.update(to);

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
