package dao.impl;

import dao.AccountDao;
import main.Entities.Account;
import main.services.db.DB;
import main.services.db.DbException;

import java.sql.*;

public class AccountJDBC implements AccountDao {

    private Connection conn;

    public AccountJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Account acc) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO " +
                            "contas(numero_conta,saldo,titular)" +
                            "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, acc.getRegister());
            st.setDouble(2, acc.getBalance());
            st.setString(3, acc.getOwner());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    int id = rs.getInt(1);
                    acc.setId(id);
                }
                DB.closeResultSet(rs);

            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Account acc) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE contas SET numero_conta = ?, saldo = ?, titular = ? WHERE id = ?");

            st.setString(1, acc.getRegister());
            st.setDouble(2, acc.getBalance());
            st.setString(3, acc.getOwner());
            st.setInt(4, acc.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM contas WHERE id = ?");
            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Account findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM contas WHERE id = ?");

            st.setInt(1,id);
            rs = st.executeQuery();

            if (rs.next()) {
                Account acc = new Account(rs.getString(4), rs.getString(2), rs.getDouble(3));
                return acc;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Account findByOwner(String owner) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM contas WHERE titular = ?");

            st.setString(1,owner);
            rs = st.executeQuery();

            if (rs.next()) {
                Account acc = new Account(rs.getString(4), rs.getString(2), rs.getDouble(3));
                return acc;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Account findByRegister(String register) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM contas WHERE titular = ?");

            st.setString(1,register);
            rs = st.executeQuery();

            if (rs.next()) {
                Account acc = new Account(rs.getString(4), rs.getString(2), rs.getDouble(3));
                return acc;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}