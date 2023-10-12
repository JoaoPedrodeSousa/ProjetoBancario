package model.Entities.impl;

import model.Entities.IInterestOperations;

import java.util.Date;
import java.util.Objects;

public class LogLend extends Log implements IInterestOperations {
    private Integer idAccount;
    private Double interest;
    private Integer term;
    private String status;
    private Double amount;

    public LogLend(String interestType, Double valueLend){
        super(interestType,valueLend);
    }

    public LogLend(Integer idAccount, Double valueLend, Double interest, Integer term, String status, String interestType){
        super(interestType,valueLend);

        this.idAccount = idAccount;
        this.interest = interest;
        this.term = term;
        this.status = status;
    }

    public LogLend(Integer idAccount, Double valueLend, Double interest, Integer term, String status, String interestType, Date date, Double amount){
        super(interestType,valueLend);

        this.idAccount = idAccount;
        this.interest = interest;
        this.term = term;
        this.status = status;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void compoundInterest() {
        setAmount(IInterestOperations.super.compoundInterest(getValue(), term, getInterest()));
    }

    public void simpleInterest() {
        setAmount(IInterestOperations.super.simpleInterest(getValue(), term, getInterest()));
    }

}
