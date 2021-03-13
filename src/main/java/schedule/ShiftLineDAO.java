package schedule;

import java.util.Optional;

public interface ShiftLineDAO {
    void createShiftLine(ShiftLine shiftLine);
    Optional<ShiftLine> readShiftLine(Integer id);
    void updateShiftLine(Integer id, ShiftLine shiftLine);
    void deleteShiftLine(Integer id);
}
