package eight.sport.dao;

import dao.PlayerInfo;
import eight.sport.connection.DerbyConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PlayerInfoDAO implements DAO<PlayerInfo> {

    private final DerbyConnectionPool connectionPool;

    public PlayerInfoDAO(DerbyConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void save(PlayerInfo entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PlayerInfo> loadAll() throws SQLException {
        String sql = "SELECT *FROM PLAYERINFO FETCH FIRST 100 ROWS ONLY";
        List<PlayerInfo> playerInfos = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PlayerInfo playerInfo = new PlayerInfo(
                        resultSet.getInt(1),//id
                        resultSet.getString(2),//firstName 
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getBoolean(6));
                playerInfos.add(playerInfo);
            }
            connectionPool.releaseConnection(connection);
            return playerInfos;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public PlayerInfo get(int id) throws SQLException {
        String sql = "SELECT *FROM PLAYERINFO WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            PlayerInfo playerInfo = null;
            while (resultSet.next()) {
                playerInfo = new PlayerInfo(
                        resultSet.getInt(1),//id
                        resultSet.getString(2),//firstName 
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getBoolean(6));
            }
            connectionPool.releaseConnection(connection);
            return playerInfo;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void update(PlayerInfo playerInfo) throws SQLException {
        String sql = "UPDATE PLAYERINFO SET FIRSTNAME=?,LASTNAME=?,SPORT=?,OFYEARS=?,VEGETARIAN=? WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (null != playerInfo && null != playerInfo.getId()) {
                preparedStatement.setString(1, playerInfo.getFirstName());
                preparedStatement.setString(2, playerInfo.getLastName());
                preparedStatement.setString(3, playerInfo.getSport());
                preparedStatement.setInt(4, playerInfo.getOfYears());
                preparedStatement.setBoolean(5, playerInfo.getVegetarian());
                preparedStatement.setInt(6, playerInfo.getId());
                preparedStatement.execute();
            }
            connectionPool.releaseConnection(connection);
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(PlayerInfo playerInfo) throws SQLException {
        if (null != playerInfo && null != playerInfo.getId()) {
            String sql = "DELETE FROM PLAYERINFO WHERE id=?";
            Connection connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, playerInfo.getId());
                ps.execute();
                connectionPool.releaseConnection(connection);
            } catch (SQLException exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
    }

    public Vector getColumnNames() {
        String sql = "SELECT *FROM PLAYERINFO";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i < columns; i++) {
                String name = metaData.getColumnName(i);
                columnNames.add(name);
            }
            connectionPool.releaseConnection(connection);
            return columnNames;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
