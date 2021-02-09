package Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    //void createTable();
    //void deleteTable();
    void createEmployee(final Employee employee);
    void deleteEmployee(int id);
    //void updateEmployeeName(int id, String newTitle);
    //Optional<Movie> findMovieById(int id);
    //List<Movie> findAll();

}
