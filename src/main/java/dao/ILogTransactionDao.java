package dao;

import main.Entities.ILog;
import main.Entities.Log;

public interface ILogTransactionDao {
    void insert(Log log);
    Log findById(Integer id);

}
