package model.Entities.impl;

import model.services.dao.AccountDao;
import model.services.dao.ILogOperationsDao;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class OperationsAccount {

    private static final Connection conn = DB.getConnection();

    public static void transfer(ILogOperationsDao logTransactionDao, AccountDao accountDao, Account from, Account to, Double value) {
        if (value > from.getBalance()){
            throw new DbException("Nao eh possivel transerir esse valor, pois eh maior que o saldo disponivel do cliente!");
        }

        try {
            conn.setAutoCommit(false);

            from.withdraw(value);
            to.deposit(value);

            accountDao.update(from);
            accountDao.update(to);

            Log log = new LogTransactions(null,"Transferencia",value, from.getId(), to.getId());
            logTransactionDao.insert(log);

            conn.commit();
        }
        catch (SQLException e){
            try {
                conn.rollback();
            }
            catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }
    public static void lend(Integer idAccount, Double value, Double interest, Integer term, String status){

    }
}
