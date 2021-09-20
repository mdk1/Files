package application;

public class InsertEmployeeDB {
	public static void main(String args[]){  

	//Declare a DELETE statement
    String updateStmt = "INSERT INTO EMPLOYEE VALUES (989, 'Heiburg', 'Maria', '45', 'Developer', 950000.00', '2', '5', '5', '0')";

    //Execute DELETE operation
    try {
        DatabaseUtility.dbExecuteUpdate(updateStmt);
         DatabaseUtility.dbDisconnect();
     } catch (Exception e) { 
         System.err.println("Got an exception! "); //manage exceptions
         System.err.println(e.getMessage()); 
     } 

 }
} 


