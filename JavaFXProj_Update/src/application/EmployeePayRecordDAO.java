package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePayRecordDAO {

	//*************************************
	//INSERT an Employee Payment Record in the Payment Record Table
	//*************************************
	public static  void insertPaymentRecord (int paymentCode, int employeeNumber, double bonusAmount) throws SQLException, ClassNotFoundException {
		 System.out.print("starting payment record insert method: ");
		//Declare an INSERT  statement
			String updateStmt =
                         "INSERT INTO PAYMENT_RECORD\n" +
                         "(pay_code, emp_id, bonus_amount)\n" +
                       "VALUES\n" +
                        "('"+paymentCode+"', '"+employeeNumber+"', '"+bonusAmount+"')";
                
            
	    //Execute INSERT operation
	    try {
	        DatabaseUtility.dbExecuteUpdate(updateStmt);
	    } catch (SQLException e) {
	        System.out.print("Error occurred while INSERT  Operation: " + e);
	        throw e;
	    }
	}
	
	//*******************************
    //SELECT fields from Employee Payment Record table to build employee payment record object
    //*******************************
    public static EmployeePayRecord buildEmployeePayRecord (String empNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
       
    	
    	String selectStmt = "SELECT * FROM PAYMENT_RECORD";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmpRec = DatabaseUtility.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            EmployeePayRecord  employeePayRecord = getEmployeePayRecord(rsEmpRec);
          
            
            //Return customer  object
            return employeePayRecord;
        } catch (SQLException e) {
            System.out.println("While searching employee no:  " + empNo + "  an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
	
  //Use ResultSet from DB as parameter and set CustomerOrder  Object's attributes and return CustoemrORder object.
    @SuppressWarnings("null")
	private static EmployeePayRecord getEmployeePayRecord (ResultSet rs) throws SQLException
    {
    	EmployeePayRecord employeePayRecord = null;
        if (rs.next()) {
             	
        	employeePayRecord.setPaymentCode(rs.getInt("pay_code"));
        	employeePayRecord.setEmployeeID (rs.getInt("emp_id"));
        	employeePayRecord.setBonusAmount (rs.getInt("bonus_amount"));
        		        	
            System.out.println(employeePayRecord);
        }
        return employeePayRecord;
    }
    
    
  //*******************************
    //SELECT fields from CUSTOMER ACCOUNT ORDER TABLE to build view of customer order
    //*******************************
    public static ManagerPayRecord buildManagerPayRecord (String empNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM PAYMENT_RECORD";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmpRec = DatabaseUtility.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            ManagerPayRecord  managerPayRecord = getManagerPayRecord(rsEmpRec);
          
            
            //Return customer  object
            return managerPayRecord;
        } catch (SQLException e) {
            System.out.println("While searching customer with " + empNo + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
	
    
    
    //Use ResultSet from DB as parameter and set CustomerOrder  Object's attributes and return CustoemrORder object.
    @SuppressWarnings("null")
	private static ManagerPayRecord getManagerPayRecord (ResultSet rs) throws SQLException
    {
    	ManagerPayRecord managerPayRecord = null;
        if (rs.next()) {
        	managerPayRecord.setPaymentCode(rs.getInt("pay_code"));
        	managerPayRecord.setEmployeeID (rs.getInt("emp_id"));
        	managerPayRecord.setBonusAmount (rs.getInt("bonus_amount"));
            System.out.println(managerPayRecord);
        }
        return managerPayRecord;
    }
}
        
  
    
