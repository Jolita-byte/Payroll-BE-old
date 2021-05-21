package lt.Payroll.schedule.dao;

import lt.Payroll.schedule.entity.ShiftLine;

import java.util.Optional;

public interface ShiftLineDAO {
    void createShiftLine(ShiftLine shiftLine);
    ShiftLine readShiftLine(Integer id);
    void updateShiftLine(Integer id, ShiftLine shiftLine);
    void deleteShiftLine(Integer id);
    Optional<ShiftLine> findAll();

}
