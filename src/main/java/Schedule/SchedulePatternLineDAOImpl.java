package Schedule;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class SchedulePatternLineDAOImpl implements SchedulePatternLineDAO {
    private final Connection connection;

    public SchedulePatternLineDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createSchedulePatternLine(SchedulePatternLine schedulePatternLine) {
        String sql = "INSERT INTO SCHEDULE_PATTERN_LINE (" +
                "Schedule_Code_ID, " +
                "InitialDate, " +
                "Shift_Code_ID " +
                ") VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, schedulePatternLine.getScheduleCodeID());
            statement.setDate(2, Date.valueOf(schedulePatternLine.getInitialDate()));
            statement.setString(3, schedulePatternLine.getShiftCodeID());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<SchedulePatternLine> readSchedulePatternLine(Integer id) {
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String scheduleCodeID = resultSet.getString("Schedule_Code_ID");
                LocalDate initialDate = resultSet.getDate("InitialDate").toLocalDate();
                String shiftCodeID = resultSet.getString("Shift_Code_ID");
                return Optional.of(new SchedulePatternLine(id, scheduleCodeID, initialDate, shiftCodeID));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void updateSchedulePatternLine(Integer id, SchedulePatternLine schedulePatternLine) {
        String sql = "UPDATE SCHEDULE_PATTERN_LINE SET " +
                "Schedule_Code_ID = ?, " +
                "InitialDate = ?, " +
                "Shift_Code_ID = ?" +
                "WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, schedulePatternLine.getScheduleCodeID());
            statement.setDate(2, Date.valueOf(schedulePatternLine.getInitialDate()));
            statement.setString(3, schedulePatternLine.getShiftCodeID());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteSchedulePatternLine(Integer id) {
        String sql = "DELETE FROM SCHEDULE_PATTERN_LINE SET WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
