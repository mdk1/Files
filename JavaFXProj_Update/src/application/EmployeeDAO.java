package application;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public static Employee DisplayEmployeeDetails (String empNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM EMPLOYEE WHERE emp_id ="+ empNo;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmployee = DatabaseUtility.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeResultSetmethod and get employee object
            Employee  employee = getEmployeeResultSet(rsEmployee);
 
            //Return employee
            return employee;
        } catch (SQLException e) {
            System.out.println("While searching employee with " + empNo+ " , an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
    
    
  //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Employee getEmployeeResultSet(ResultSet rs) throws SQLException
    {
        Employee emp = null;
        if (rs.next()) {
        	emp = new Employee();
            emp.setEmployeeID(rs.getInt("emp_id"));
            emp.setEmployeeName (rs.getString("emp_name"));
            emp.setEmployeeSurname (rs.getString("emp_surname"));
            emp.setEmployeeAge (rs.getInt("emp_age"));
            emp.setJobTitlee (rs.getString("job_title"));
            emp.setAnnualSalary (rs.getDouble("annual_salary"));
            emp.setYearsEmployed (rs.getInt("years_employed"));
            emp.setLeaveDays (rs.getInt("leave_days"));
            emp.setPerfScore (rs.getInt("perf_score"));
            emp.setManInd (rs.getInt("manager_indicator"));
            System.out.println(emp);
        }
        return emp ;
    }
	
}