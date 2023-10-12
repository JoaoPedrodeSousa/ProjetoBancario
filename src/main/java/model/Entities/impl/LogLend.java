package model.Entities.impl;

import model.Entities.IInterestOperations;

import java.util.Date;
import java.util.Objects;

public class LogLend extends Log implements IInterestOperations {
    private Integer idAccount;
    private Double interest;
    private Integer term;
    private String status;
    private final Double TAX = 1.05;

    public LogLend(Integer idAccount, Double valueLend, Double interest, Integer term, String status, String InterestType){
        super(InterestType,valueLend);

        this.idAccount = idAccount;
        this.interest = interest;
        this.term = term;
        this.status = status;
    }

    public LogLend(Integer idAccount, Double valueLend, Double interest, Integer term, String status, String InterestType, Date date){
        super(InterestType,valueLend);

        this.idAccount = idAccount;
        this.interest = interest;
        this.term = term;
        this.status = status;

        setDate(date);
    }

    public LogLend(Integer id,Integer idAccount, Double valueLend, Double interest, Integer term, String status, String InterestType, Date date){
        super(InterestType,valueLend);

        this.setId(id);
        this.idAccount = idAccount;
        this.interest = interest;
        this.term = term;
        this.status = status;

        setDate(date);
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void compoundInterest() {
        setInterest(IInterestOperations.super.compoundInterest(getValue(), term, TAX));
    }

    public void simpleInterest() {
        setInterest(IInterestOperations.super.simpleInterest(getValue(), term, TAX));
    }
}
