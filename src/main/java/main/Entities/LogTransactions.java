package main.Entities;

import java.util.Objects;

public class LogTransactions extends Log{
    private String originAccount;
    private String destinyAccount;

    public LogTransactions(String tipo, Double valor, String originAccount, String destinyAccount) {
        super(tipo, valor);
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(String destinyAccount) {
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
