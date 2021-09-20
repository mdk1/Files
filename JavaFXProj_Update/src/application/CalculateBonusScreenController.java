//*************************************
//Class Activity:  AB Corp Bonus Incentive Calculation Application
//CalculateBonusScreenController java class
//*************************************
package application;
import java.awt.Checkbox;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.scene.control.TextArea;

             
public class CalculateBonusScreenController {
	//Define/inject the UI components
	
	//1.  All the TextFields 

	@FXML 
	private TextField TextFieldEnterEmployeeNum; 
	
	@FXML
	private TextField TextFieldAnnualSalary;
	
	@FXML
	private TextField TextFieldYearsEmp;
	
	@FXML
	private TextField TextFieldPerformScore;
	
	@FXML
	private TextField TextFieldPaymentCode;
	
	//2.  All the Buttons 
	@FXML
	private Button ButtonDisplayEmplDetails;
	
	@FXML
	private Button ButtonCalculateBonus;
	
	//3.  The TextArea 
	@FXML
	 private TextArea TextAreaDisplayEmplDetails;
	
	//4.  The TextField  
	
	@FXML
	private Text  TextBonusAmount;
	
	//5.  The CheckBox for Manager field
	
	@FXML
	private CheckBox CheckBoxManager;
	
	
	@FXML //define the DisplayEmployeeDetails method
	protected void DisplayEmployeeDetails (ActionEvent event) throws ClassNotFoundException, SQLException {
		Window owner = ButtonDisplayEmplDetails.getScene().getWindow();
		 //check if No Employee Number is entered!
		
		
		 
		 if(TextFieldEnterEmployeeNum.getText().isEmpty()) {
	            MessageScreen.showAlert(Alert.AlertType.ERROR, owner, "Blank Field!", 
	                    "Please enter a valid Employee Number");
	            return;
	        }else
	        	try{
	        		       //Get Employee  information
	        	             Employee emp = EmployeeDAO.DisplayEmployeeDetails(TextFieldEnterEmployeeNum.getText());
	        	             ShowEmployeeDetails (emp);
	        	            } catch (SQLException e) {
	        	            e.printStackTrace();
	        	            TextAreaDisplayEmplDetails.setText("Error occurred while getting employee information from DB.\n" + e);
	        	            throw e;
	        	        }
	        	    }
		        	
	
	public  void initialize(Employee emp) throws ClassNotFoundException {
		ShowEmployeeDetails (emp);
  }
  
  //Populate Customer to display on  TextArea

  private void setEmpInfoToTextArea ( Employee emp) {
	  TextAreaDisplayEmplDetails.setText("Employee Name : " + emp.getemp_name() + "\n" 
  						               + "Employee Surname: " + emp.getemp_surname ());
  		             			          
  						         
  }
	 	 
		    //Let the user know if captured employee number doesn't exist in the database
		   
		    private void ShowEmployeeDetails(Employee emp) throws ClassNotFoundException {
		        if (emp != null) {
		        	setEmpInfoToTextArea(emp);
		        } else {
		        	TextAreaDisplayEmplDetails.setText("This Employee does not exist!\n");
	        		
		        }
	}
			   
	@FXML //define the CalculateBonusAmount method
	protected void CalculateBonusAmount (ActionEvent event) throws ClassNotFoundException, SQLException {
		if (CheckBoxManager.isSelected()) {
			// create instance of Employee Payment Record  Class
			ManagerPayRecord managerPayRecord = new ManagerPayRecord(); 
		
			
			//declare variables from the GUI which will be used to calculate the Employee Payment Record
			double annualSalary = Double.parseDouble(TextFieldAnnualSalary.getText()) ; 
			int numYearsEmployed = Integer.parseInt(TextFieldYearsEmp.getText());
			int performanceScore = Integer.parseInt(TextFieldPerformScore.getText()) ;

			// pass variables to the CalculateBonusAmount method of the Employee Payment  class 
			managerPayRecord.CalculateBonusAmount(annualSalary, numYearsEmployed, performanceScore);
			
			
			//retrieve value from CalculateBonusAmount method returned from EmployeePaymentRecord Class method
			//display output fields for EmployeePaymentto the GUI
			
		
			String bonusAmount = String.valueOf(managerPayRecord.getBonusIncentiveAmount());
			TextBonusAmount.setText(bonusAmount);
			
			
					
			
			//Insert Employee payment record into the  DB
		    try
		    {
		    	EmployeePayRecordDAO.insertPaymentRecord(Integer.parseInt(TextFieldPaymentCode.getText()), Integer.parseInt(TextFieldEnterEmployeeNum.getText()), Double.parseDouble(TextBonusAmount.getText()));
	   
		    } catch (SQLException e) {
		            throw e;
		        }
					
			

		} else {
			// create instance of Employee Payment Record  Class
						EmployeePayRecord employeePayRecord = new EmployeePayRecord(); 
					
						
						//declare variables from the GUI which will be used to calculate the Employee Payment Record
						double annualSalary = Double.parseDouble(TextFieldAnnualSalary.getText()) ; 
						int numYearsEmployed = Integer.parseInt(TextFieldYearsEmp.getText());
						int performanceScore = Integer.parseInt(TextFieldPerformScore.getText()) ;

						// pass variables to the CalculateBonusAmount method of the Employee Payment  class 
						employeePayRecord.CalculateBonusAmount(annualSalary, numYearsEmployed, performanceScore);
						
						
						//retrieve value from CalculateBonusAmount method returned from EmployeePaymentRecord Class method
						//display output fields for EmployeePaymentto the GUI
						
					
						String bonusAmount = String.valueOf(employeePayRecord.getBonusIncentiveAmount());
						TextBonusAmount.setText(bonusAmount);
						
						
								
						
						//Insert Employee payment record into the  DB
					    try
					    {
					    	EmployeePayRecordDAO.insertPaymentRecord(Integer.parseInt(TextFieldPaymentCode.getText()), Integer.parseInt(TextFieldEnterEmployeeNum.getText()), Double.parseDouble(TextBonusAmount.getText()));
				   
					    } catch (SQLException e) {
					            throw e;
					        }
	}
}
}