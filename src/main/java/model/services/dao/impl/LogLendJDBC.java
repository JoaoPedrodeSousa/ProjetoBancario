package model.services.dao.impl;

import model.Entities.impl.LogLend;
import model.services.dao.ILogLendDao;

import java.sql.Connection;

public class LogLendJDBC implements ILogLendDao {

    private final Connection conn;
    private LogLend logLend;

    public LogLendJDBC(Connection conn, LogLend logLend) {
        this.conn = conn;
        this.logLend = logLend;
    }

    @Override
    public void insert(LogLend logLend) {

    }

    @Override
    public void update(LogLend logLend) {

    }

    @Override
    public LogLend findById(Integer id) {
        return null;
    }

    @Override
    public void DeleteById(Integer id) {

    }
}

