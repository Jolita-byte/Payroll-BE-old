package employee;

public interface EmployeeDAO {

    //void createTable();
    //void deleteTable();
    void createEmployee(Employee employee);
    Employee readEmployee(Integer id);
    void updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);

    //void updateEmployeeName(int id, String newTitle);
    //Optional<Movie> findMovieById(int id);
    //List<Movie> findAll();

}
