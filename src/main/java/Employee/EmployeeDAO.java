package Employee;

public interface EmployeeDAO {

    //void createTable();
    //void deleteTable();
    void createEmployee(Employee employee);
    void readEmployee(Integer id);
    void updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);

    //void updateEmployeeName(int id, String newTitle);
    //Optional<Movie> findMovieById(int id);
    //List<Movie> findAll();

}
