package General;

import Employee.Employee;

import java.util.Optional;

public interface CodeDAO {
    void createCode(Code code);
    Optional<Code> readCode(String id);
    void updateCode(String id, Code code);
    void deleteCode(String id);
}
