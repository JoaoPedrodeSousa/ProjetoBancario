package main.Entities;

import dao.AccountDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface Transaction {

    default void transfer(AccountDao accountDao, IOperationsAccount from, IOperationsAccount to, Double value) throws SQLException {}
}
