package model.Entities.impl;

import java.util.Date;

public class LogInvestiment extends Log{

    public LogInvestiment(String type, Double value) {
        super(type, value);
    }

    public LogInvestiment(String type, Double value, Date date) {
        super(type, value, date);
    }

    public LogInvestiment(Integer id, String type, Double value) {
        super(id, type, value);
    }

    public LogInvestiment(Integer id, String type, Double value, Date date) {
        super(id, type, value, date);
    }

    public LogInvestiment(Integer id, Integer idAccount, String type, Double value, Date date) {
        super(id, type, value, date);
        setIdAccount(idAccount);
    }

}
