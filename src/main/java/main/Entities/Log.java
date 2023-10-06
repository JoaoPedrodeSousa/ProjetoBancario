package main.Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public abstract class Log implements ILog{
    private Integer id = null;

    private Date date;

    private String tipo;

    private Double valor;

    public Log(String tipo, Double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log log = (Log) o;
        return Objects.equals(getId(), log.getId()) && Objects.equals(getTipo(), log.getTipo()) && Objects.equals(getDate(), log.getDate()) && Objects.equals(getValor(), log.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipo(), getDate(), getValor());
    }

    @Override
    public String toString() {
        return "log{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", date=" + date +
                ", valor=" + valor +
                '}';
    }
}
