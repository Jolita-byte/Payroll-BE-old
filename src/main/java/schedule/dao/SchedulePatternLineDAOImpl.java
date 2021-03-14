package schedule.dao;

import schedule.entity.SchedulePatternLine;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public SchedulePatternLine readSchedulePatternLine(Integer id) {
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String scheduleCodeID = resultSet.getString("Schedule_Code_ID");
                LocalDate initialDate = resultSet.getDate("InitialDate").toLocalDate();
                String shiftCodeID = resultSet.getString("Shift_Code_ID");
                return new SchedulePatternLine(id, scheduleCodeID, initialDate, shiftCodeID);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
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

    @Override
    public List<SchedulePatternLine> getAllSchedulePatternLines(String scheduleCodeID) {
        List<SchedulePatternLine> schedulePatternLines = new ArrayList<>();
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, scheduleCodeID);
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                LocalDate initialDate = resultSet.getDate("InitialDate").toLocalDate();
                String shiftCodeID = resultSet.getString("Shift_Code_ID");
                schedulePatternLines.add(new SchedulePatternLine(id, scheduleCodeID, initialDate, shiftCodeID));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return schedulePatternLines;
    }
}
