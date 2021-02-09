package Employee;

import General.Code;

import java.sql.*;
import java.time.LocalDate;

public class ContractDAOImpl implements ContractDAO {
    private final Connection connection;

    public ContractDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createContract(ContractLine contractLine) {
        String sql = "INSERT INTO  CONTRACT (" +
                "Employee_ID, " +
                "EmploymentDate, " +
                "ContractSignDate" +
                ") VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, contractLine.getContract().getEmployee().getId());
            statement.setDate(2, Date.valueOf(contractLine.getContract().getEmploymentDate()));
            statement.setDate(3, Date.valueOf(contractLine.getContract().getContractSignDate()));
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                createContractLine(resultSet.getInt(1), contractLine);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createContractLine(int contractID, ContractLine contractLine){
        String sql = "INSERT INTO  CONTRACT_LINE (" +
                "Contract_ID," +
                "StartDate," +
                "EndDate," +
                "Schedule_Code_ID," +
                "Position_Code_ID," +
                "Staff," +
                "AmountType," +
                "Amount" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, contractID);
            statement.setDate(2, Date.valueOf(contractLine.getStartDate()));
            statement.setDate(3, Date.valueOf(contractLine.getEndDate()));
            statement.setString(4, contractLine.getSchedule().getId());
            statement.setString(5, contractLine.getPosition().getId());
            statement.setFloat(6, contractLine.getStaff());
            statement.setObject(7, contractLine.getAmountType());
            statement.setFloat(8, contractLine.getAmount());
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateSchedule(Code schedule) {

    }

    @Override
    public void updatePosition(Code position) {

    }

    @Override
    public void updateStaff(Code staff) {

    }

    @Override
    public void updateAmount(float amount, ContractLine.AmountType amountType) {

    }

    @Override
    public void terminateContract(LocalDate terminationDate) {

    }
}
