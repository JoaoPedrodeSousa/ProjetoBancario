package model.Entities.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogTransactions extends Log implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer originAccount;
    private Integer destinyAccount;

    public LogTransactions(String tipo, Double valor, Integer originAccount, Integer destinyAccount) {
        super(tipo, valor);
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public LogTransactions(String tipo, Double valor, Date date, Integer originAccount, Integer destinyAccount) {
        super(tipo, valor, date);
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public LogTransactions(Integer id, String tipo, Double valor, Integer originAccount, Integer destinyAccount) {
        super(id, tipo, valor);
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public LogTransactions(Integer id, String tipo, Double valor, Date date, Integer originAccount, Integer destinyAccount) {
        super(id, tipo, valor, date);
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public Integer getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Integer originAccount) {
        this.originAccount = originAccount;
    }

    public Integer getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(Integer destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogTransactions)) return false;
        if (!super.equals(o)) return false;
        LogTransactions that = (LogTransactions) o;
        return Objects.equals(getOriginAccount(), that.getOriginAccount()) && Objects.equals(getDestinyAccount(), that.getDestinyAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOriginAccount(), getDestinyAccount());
    }

    @Override
    public String toString() {
        return "logTransactions{" +
                "originAccount='" + originAccount + '\'' +
                ", destinyAccount='" + destinyAccount + '\'' +
                '}';
    }


}
