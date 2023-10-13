package model.services.dao.impl;

import model.Entities.impl.LogInvestiment;
import model.services.dao.ILogInvestimentDao;
import model.services.database.DB;
import model.services.database.DbException;

import java.sql.*;

public class LogInvestimentJDBC implements ILogInvestimentDao {

    private final Connection conn;

    public LogInvestimentJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(LogInvestiment logInvestiment) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO investimentos(" +
                    "id_conta, " +
                    "tipo_ativo, " +
                    "valor_investido " +
                    "VALUES( ? , ? , ? )", Statement.RETURN_GENERATED_KEYS
            );

            st.setInt(1,logInvestiment.getIdAccount());
            st.setString(2,logInvestiment.getAssetType());
            st.setDouble(3, logInvestiment.getValue());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    logInvestiment.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
        }

        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(LogInvestiment logInvestiment) {

    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public LogInvestiment findById(Integer id) {
        return null;
    }
}
