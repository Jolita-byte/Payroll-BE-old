package general;

import schedule.entity.ShiftLine;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
    public Code readCode(String id) {
        String sql = "SELECT * FROM " + table + " WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String description = resultSet.getString("Description");
                return new Code(id, description);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
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

    @Override
    public Optional<Code> findAllCodes() {
        String sql = "SELECT * FROM " + table;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String id = resultSet.getString("ID");
                String description = resultSet.getString("Description");
                return Optional.of(new Code(id, description));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<ShiftLine> findShiftLines(String code) {
        List<ShiftLine> shiftLines = new ArrayList<>();
        String sql = "SELECT * FROM SHIFT_LINE WHERE Shift_Code_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code);
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String shiftCodeID = resultSet.getString("Shift_Code_ID");
                String timeCodeID = resultSet.getString("Time_Code_ID");
                LocalTime begin = resultSet.getTime("Begin").toLocalTime();
                LocalTime end = resultSet.getTime("End").toLocalTime();
                shiftLines.add(new ShiftLine(id, shiftCodeID, timeCodeID, begin, end));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

       return shiftLines;
    }
}

