package application;

import javafx.beans.property.*;

public class EmployeePayRecord {
	 //STEP 1:Declare Customer Model variables
	private IntegerProperty  pay_code;
	private IntegerProperty  emp_id;
	private DoubleProperty bonus_amount;
	protected double bonusIncentive;
	
	//STEP 2: Constructor
    public EmployeePayRecord() {
        this.pay_code = new SimpleIntegerProperty();
        this.emp_id = new SimpleIntegerProperty();
        this.bonus_amount = new SimpleDoubleProperty();
      
       }
    
    //STEP 3: get and set methods for each database field 
    //payment code. 	
   
    public int pay_code() {
        return pay_code.get();
    }
 
    public void setPaymentCode(int paymentCode){
    	pay_code.set(paymentCode);
    }
 
    public IntegerProperty paymentCodeProperty(){
        return pay_code;
    }
            
    
    //employee_id 	

    public int getemp_id() {
        return emp_id.get();
    }
 
    public void setEmployeeID(int employeeID){
    	emp_id.set(employeeID);
    }
 
    public IntegerProperty employeeIDProperty(){
        return emp_id;
    }
            
  //bonus amount
    
    public double getbonus_amount () {
        return bonus_amount.get();
    }
 
    public void setBonusAmount (double bonusAmount){
    	bonus_amount.set(bonusAmount);
    }
 
    public DoubleProperty bonusAmountProperty() {
        return bonus_amount;
    }
    
      
public   void CalculateBonusAmount  (double annualSalary, int numYearsEmployed, int performanceScore) {
	 
	   //private variables that will be returned from the method and passed to the GUI

	double bonusIncentive =0;
	bonusIncentive = ((annualSalary * (performanceScore * 0.01 )) + (annualSalary *  (numYearsEmployed * 0.001)));
		
		System.out.println("Total Bonus Amount Due : " + bonusIncentive);
		// construct return multiple values from method
					this.bonusIncentive = bonusIncentive;
					
	}
	 
 public double getBonusIncentiveAmount () {
 	return bonusIncentive;
 }

}

class ManagerPayRecord extends EmployeePayRecord {
	public   void CalculateBonusAmount  (double annualSalary, int numYearsEmployed, int performanceScore) {
		 
		   //private variables that will be returned from the method and passed to the GUI

		double bonusIncentive =0;
		bonusIncentive =((annualSalary * (performanceScore * 0.015)) + (annualSalary *  (numYearsEmployed * 0.0015)));
			
			System.out.println("Total Bonus Amount Due : " + bonusIncentive);
			// construct return multiple values from method
						this.bonusIncentive = bonusIncentive;
						
		}
		 
	 public double getBonusIncentiveAmount () {
	 	return bonusIncentive;
	 }
}





