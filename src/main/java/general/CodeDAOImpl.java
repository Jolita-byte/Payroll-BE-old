package general;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CodeDAOImpl implements CodeDAO {
    private final Connection connection;
    private final String table;

    public CodeDAOImpl(Connection connection, String table) {
        this.connection = connection;
        this.table = table.toUpperCase();
    }

    @Override
    public void createCode(Code code) {
        String sql = "INSERT INTO " + table + " (ID, Description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code.getId());
            statement.setString(2, code.getDescription());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<Code> readCode(String id) {
        String sql = "SELECT * FROM " + table + " WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String description = resultSet.getString("Description");
                return Optional.of(new Code(id, description));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void updateCode(String id, Code code) {
        String sql = "UPDATE " + table + " SET Description = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code.getDescription());
            statement.setString(2, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCode(String id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

