package schedule.dao;

import schedule.entity.SchedulePatternLine;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

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
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ?";
        return getSchedulePatternLines(scheduleCodeID, sql);

    }

    @Override
    public List<SchedulePatternLine> getPatternlinesOnDate(LocalDate date, String scheduleCodeID) {
        LocalDate PatternFirstLineDate = getPatternFirstLineDate(scheduleCodeID);
        Long diff = Math.abs(DAYS.between(date, PatternFirstLineDate));
        Long patternLineNo = diff % getPatternLength(scheduleCodeID);
        LocalDate patternLineDate = DAYS.addTo(PatternFirstLineDate, patternLineNo);
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ? AND InitialDate = ?";
        return getSchedulePatternLines2(scheduleCodeID, sql, patternLineDate);
    }

    @Override
    public LocalDate getPatternFirstLineDate(String scheduleCodeID) {
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ? ORDER BY InitialDate ASC LIMIT 1";
        return getSchedulePatternLines(scheduleCodeID, sql).stream().findFirst().get().getInitialDate();
    }

    @Override
    public Integer getPatternLength(String scheduleCodeID) {
        String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ? GROUP BY InitialDate";
        return getSchedulePatternLines(scheduleCodeID, sql).size();
    }

    private List<SchedulePatternLine> getSchedulePatternLines(String scheduleCodeID, String sql) {
        List<SchedulePatternLine> schedulePatternLines = new ArrayList<>();
        //String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ?";

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
    private List<SchedulePatternLine> getSchedulePatternLines2(String scheduleCodeID, String sql, LocalDate date) {
        List<SchedulePatternLine> schedulePatternLines = new ArrayList<>();
        //String sql = "SELECT * FROM SCHEDULE_PATTERN_LINE WHERE Schedule_Code_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, scheduleCodeID);
            statement.setDate(2, Date.valueOf(date));
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
