package model.services.dao;

import model.Entities.impl.Account;
import model.Entities.impl.Log;

public interface ILogTransactionDao {
    void insert(Log log);
    Log findById(Integer id);

}
