package employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContractDAOImpl implements ContractDAO {
    private final Connection connection;

    public ContractDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createContract(Contract contract, ContractLine contractLine) {
        String sql = "INSERT INTO  CONTRACT (" +
                "Employee_ID, " +
                "EmploymentDate, " +
                "ContractSignDate" +
                ") VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, contract.getEmployeeID());
            statement.setDate(2, Date.valueOf(contract.getEmploymentDate()));
            statement.setDate(3, Date.valueOf(contract.getContractSignDate()));
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                createContractLine(resultSet.getInt(1), contract.getEmploymentDate(), contractLine);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateContract(int id, LocalDate newDate, ContractLine contractUpdates) {
        Optional<ContractLine> currentContractLine = findLastContractLine(id);
        ContractLine newContractLine = currentContractLine.get();
        if (contractUpdates.getScheduleID() != null){newContractLine.setScheduleID(contractUpdates.getScheduleID());}
        if (contractUpdates.getPositionID() != null){newContractLine.setPositionID(contractUpdates.getPositionID());}
        if (contractUpdates.getStaff() != null){newContractLine.setStaff(contractUpdates.getStaff());}
        if (contractUpdates.getAmountType() != null){newContractLine.setAmountType(contractUpdates.getAmountType());}
        if (contractUpdates.getAmount() != null){newContractLine.setAmount(contractUpdates.getAmount());}

        if (newDate.isEqual(newContractLine.getStartDate())){
            updateContractLine(id, newDate, newContractLine);
        } else createContractLine(id, newDate, newContractLine);
    }

    @Override
    public void createContractLine(int contractID, LocalDate startDate, ContractLine contractLine){
        String sql = "INSERT INTO  CONTRACT_LINE (" +
                "StartDate," +
                "Contract_ID," +
                "Schedule_Code_ID," +
                "Position_Code_ID," +
                "Staff," +
                "AmountType," +
                "Amount" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(startDate));
            statement.setInt(2, contractID);
            statement.setString(3, contractLine.getScheduleID());
            statement.setString(4, contractLine.getPositionID());
            statement.setFloat(5, contractLine.getStaff());
            statement.setObject(6, contractLine.getAmountType().toString());
            statement.setFloat(7, contractLine.getAmount());
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateContractLine(int contractID, LocalDate startDate, ContractLine contractLine) {
        String sql = "UPDATE CONTRACT_LINE SET " +
                "Schedule_Code_ID = ?," +
                "Position_Code_ID = ?," +
                "Staff = ?," +
                "AmountType = ?," +
                "Amount = ? " +
                "WHERE Contract_ID = ? AND " +
                "StartDate = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, contractLine.getScheduleID());
            statement.setString(2, contractLine.getPositionID());
            statement.setFloat(3, contractLine.getStaff());
            statement.setObject(4, contractLine.getAmountType().toString());
            statement.setFloat(5, contractLine.getAmount());
            statement.setInt(6, contractID);
            statement.setDate(7, Date.valueOf(startDate));
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void terminateContract(LocalDate terminationDate) {

    }

    public Optional<ContractLine> findLastContractLine(int contractID){
        String sql = "SELECT max(StartDate) AS startDate FROM CONTRACT_LINE WHERE Contract_ID = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, contractID);
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()){
                return findContractLineByPK(contractID, resultSet.getDate("startDate").toLocalDate());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<ContractLine> findContractLineByPK(int contractID, LocalDate startDate) {
        String sql = "SELECT * FROM CONTRACT_LINE WHERE Contract_ID = ? AND StartDate = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, contractID);
            statement.setDate(2, Date.valueOf(startDate));
            if (!statement.execute()) {
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String scheduleCodeID = resultSet.getString("Schedule_Code_ID");
                String positionCodeID = resultSet.getString("Position_Code_ID");
                Integer staff = resultSet.getInt("Staff");
                ContractLine.AmountType amountType = ContractLine.AmountType.valueOf(resultSet.getString("AmountType").toUpperCase());
                float amount = resultSet.getFloat("Amount");
                return Optional.of(new ContractLine(contractID, startDate, scheduleCodeID, positionCodeID, staff, amountType, amount));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public ContractLine findContractLineByDate(Integer employeeID, LocalDate date){
        String sql ="SELECT CONTRACT_LINE.* FROM EMPLOYEE" +
                "LEFT JOIN CONTRACT on EMPLOYEE.id = CONTRACT.Employee_ID" +
                "LEFT JOIN CONTRACT_LINE on CONTRACT.ID = CONTRACT_LINE.Contract_ID" +
                "WHERE EMPLOYEE.ID = ? and CONTRACT_LINE.StartDate < ? ORDER BY StartDate DESC LIMIT 1";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeID);
            statement.setDate(2, Date.valueOf(date));
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                Integer contractID = resultSet.getInt("Contract_ID");
                LocalDate startDate = resultSet.getDate("StartDate").toLocalDate();
                String scheduleCodeID = resultSet.getString("Schedule_Code_ID");
                String positionCodeID = resultSet.getString("Position_Code_ID");
                Integer staff = resultSet.getInt("Staff");
                ContractLine.AmountType amountType = ContractLine.AmountType.valueOf(resultSet.getString("AmountType").toUpperCase());
                float amount = resultSet.getFloat("Amount");
                return new ContractLine(contractID, startDate, scheduleCodeID, positionCodeID, staff, amountType, amount);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ContractContractLine> findEmployeeContractContractLinesByDate(Integer employeeID, LocalDate date) {
        List<ContractContractLine> contractContractLines = new ArrayList<>();
        String sql = "SELECT ccl.* FROM CONTRACT_CONTRACT_LINE AS ccl INNER JOIN (SELECT Contract_ID, max(StartDate) as StartDate FROM CONTRACT_CONTRACT_LINE WHERE Employee_ID = ? AND StartDate < ? GROUP BY Contract_ID) AS max ON ccl.Contract_ID = max.Contract_ID AND ccl.StartDate = max.StartDate";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeID);
            statement.setDate(2, Date.valueOf(date));
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer contractID = resultSet.getInt("Contract_ID");
                LocalDate employmentDate = resultSet.getDate("EmploymentDate").toLocalDate();
                LocalDate contractSignDate = resultSet.getDate("ContractSignDate").toLocalDate();
                LocalDate terminationDate = (resultSet.getDate("Termination date"))!=null
                        ?resultSet.getDate("Termination date").toLocalDate()
                        :null;

                LocalDate startDate = resultSet.getDate("StartDate").toLocalDate();
                String scheduleCodeID = resultSet.getString("Schedule_Code_ID");
                String positionCodeID = resultSet.getString("Position_Code_ID");
                Integer staff = resultSet.getInt("Staff");
                ContractLine.AmountType amountType = ContractLine.AmountType.valueOf(resultSet.getString("AmountType").toUpperCase());
                float amount = resultSet.getFloat("Amount");

                contractContractLines.add(new ContractContractLine(
                        new Contract(contractID, employeeID, employmentDate, contractSignDate, terminationDate),
                        new ContractLine(contractID, startDate, scheduleCodeID, positionCodeID, staff, amountType, amount)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return contractContractLines;
    }


}
