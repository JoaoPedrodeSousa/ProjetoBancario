package dao;

import main.Entities.Account;

import java.util.List;

public interface AccountDao {
    void insert(Account obj);
    void update(Account obj);
    void deleteById(Integer id);
    Account findById(Integer id);
    Account findByOwner(String owner);
    Account findByRegister(String register);


}
