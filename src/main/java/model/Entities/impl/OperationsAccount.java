package model.Entities.impl;

import model.services.dao.AccountDao;
import model.services.dao.ILogLendDao;
import model.services.dao.ILogTransferDao;
import model.services.dao.impl.LogLendJDBC;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class OperationsAccount {

    private static final Connection conn = DB.getConnection();

    public static void transfer(ILogTransferDao logTransactionDao, AccountDao accountDao, Account from, Account to, Double value) {
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
    public static void lend(Integer idAccount, Double valueLend, Double interest, Integer term, String status, String InterestType) throws SQLException {
        try {
            conn.setAutoCommit(false);

                LogLend logLend = new LogLend(InterestType, valueLend);

                logLend.setIdAccount(idAccount);
                logLend.setTerm(term);
                logLend.setInterest(interest);
                logLend.setStatus(status);

                if (InterestType.toLowerCase().equals("compound")) {
                    logLend.compoundInterest();
                }

                else {
                    logLend.simpleInterest();
                }

                ILogLendDao logLendDao = new LogLendJDBC(conn);

                logLendDao.insert(logLend);


            conn.commit();
        }
        catch (SQLException e){
            conn.rollback();
            throw new DbException(e.getMessage());
        }
    }
}
