package general;

import schedule.entity.ShiftLine;

import java.util.List;
import java.util.Optional;

public interface CodeDAO {
    void createCode(Code code);
    Code readCode(String id);
    void updateCode(String id, Code code);
    void deleteCode(String id);
    Optional<Code> findAllCodes();

    List<ShiftLine> findShiftLines(Code code);

}
