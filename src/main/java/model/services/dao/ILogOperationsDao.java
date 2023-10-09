package model.services.dao;

import model.Entities.impl.Log;

public interface ILogOperationsDao {
    void insert(Log log);
    Log findById(Integer id);

}
