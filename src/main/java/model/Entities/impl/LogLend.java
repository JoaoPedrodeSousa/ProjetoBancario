package model.Entities.impl;

import model.Entities.IInterestOperations;

import java.util.Objects;

public class LogLend implements IInterestOperations {
    private Integer id = null;
    private Double valueLend;
    private Double interest;
    private Integer term;
    private Double tax;
    private String status;
    private String type;

    public LogLend(Integer id, Double valueLend, Double interest, Double tax, Integer term, String type) {
        this.id = id;
        this.valueLend = valueLend;
        this.interest = interest;
        this.tax = tax;
        this.term = term;
        this.type = type;
    }

    public LogLend(Integer id, Double valueLend, Double interest, Double tax,Integer term, String status, String type) {
        this.id = id;
        this.valueLend = valueLend;
        this.interest = interest;
        this.tax = tax;
        this.term = term;
        this.status = status;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValueLend() {
        return valueLend;
    }

    public void setValueLend(Double valueLend) {
        this.valueLend = valueLend;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double compoundInterest() {
        return IInterestOperations.super.compoundInterest(valueLend, term, tax);
    }

    public Double simpleInterest() {
        return IInterestOperations.super.simpleInterest(valueLend, term, tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogLend)) return false;
        LogLend logLend = (LogLend) o;
        return Objects.equals(getValueLend(), logLend.getValueLend()) && Objects.equals(getInterest(), logLend.getInterest()) && Objects.equals(getTerm(), logLend.getTerm()) && Objects.equals(getStatus(), logLend.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValueLend(), getInterest(), getTerm(), getStatus());
    }

    @Override
    public String toString() {
        return "LogLend{" +
                "valueLend=" + valueLend +
                ", interest=" + interest +
                ", term=" + term +
                ", status='" + status + '\'' +
                '}';
    }
}
