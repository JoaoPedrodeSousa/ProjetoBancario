package dao.impl;

import dao.ILogTransactionDao;
import main.Entities.Log;
import main.Entities.LogTransactions;
import main.services.db.DB;
import main.services.db.DbException;

import java.sql.*;
import java.time.LocalDateTime;

public class logTransactionJDBC implements ILogTransactionDao {

    private Connection conn;

    public logTransactionJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Log log) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO " +
                    "transacoes(tipo,data,valor,conta_origem,conta_destino) " +
                    "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1,log.getTipo());
            st.setDate(2, new java.sql.Date(log.getDate().getTime()));
            st.setDouble(3, log.getValor());
            st.setString(4,log.getOriginAccount());
            st.setString(5, log.getDestinyAccount());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()){
                    int id = rs.getInt(1);
                    log.setId(id);
                }

            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }


    @Override
    public Log findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM transacoes WHERE id = ?");

            st.setInt(1,id);
            rs = st.executeQuery();

            if (rs.next()){
                Log log = new LogTransactions(rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
                return log;
            }
            return null;

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
