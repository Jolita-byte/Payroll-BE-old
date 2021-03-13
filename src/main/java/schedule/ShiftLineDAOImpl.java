package schedule;

import java.sql.*;
import java.time.LocalTime;
import java.util.Optional;

public class ShiftLineDAOImpl implements ShiftLineDAO {
    private final Connection connection;

    public ShiftLineDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createShiftLine(ShiftLine shiftLine) {
        String sql = "INSERT INTO SHIFT_LINE (" +
                "Shift_Code_ID, " +
                "Time_Code_ID, " +
                "Begin, " +
                "End" +
                ") VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, shiftLine.getShiftCodeID());
            statement.setString(2, shiftLine.getTimeCodeID());
            statement.setTime(3, Time.valueOf(shiftLine.getBegin()));
            statement.setTime(4, Time.valueOf(shiftLine.getEnd()));
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<ShiftLine> readShiftLine(Integer id) {
        String sql = "SELECT * FROM SHIFT_LINE WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String shiftCodeID = resultSet.getString("Shift_Code_ID");
                String timeCodeID = resultSet.getString("Time_Code_ID");
                LocalTime begin = resultSet.getTime("Begin").toLocalTime();
                LocalTime end = resultSet.getTime("End").toLocalTime();
                return Optional.of(new ShiftLine(id, shiftCodeID, timeCodeID, begin, end));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void updateShiftLine(Integer id, ShiftLine shiftLine) {
        String sql = "UPDATE SHIFT_LINE SET " +
                "Shift_Code_ID = ?, " +
                "Time_Code_ID = ?, " +
                "Begin = ?, " +
                "End = ? " +
                "WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, shiftLine.getShiftCodeID());
            statement.setString(2, shiftLine.getTimeCodeID());
            statement.setTime(3, Time.valueOf(shiftLine.getBegin()));
            statement.setTime(4, Time.valueOf(shiftLine.getEnd()));
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteShiftLine(Integer id) {
        String sql = "DELETE FROM SHIFT_LINE WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
