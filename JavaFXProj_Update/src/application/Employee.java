package application;

import javafx.beans.property.*;

public class Employee {
	 //STEP 1:Declare Customer Model variables
	private IntegerProperty  emp_id;
	private StringProperty emp_name;
	private StringProperty emp_surname;
	private IntegerProperty emp_age;
	private StringProperty job_title;
	private DoubleProperty annual_salary;
	private IntegerProperty years_employed; 
	private IntegerProperty leave_days;
	private IntegerProperty perf_score;
	private IntegerProperty manager_indicator;
	
	
	//STEP 2: Constructor
    public Employee() {
        this.emp_id = new SimpleIntegerProperty();
        this.emp_name = new SimpleStringProperty();
        this.emp_surname = new SimpleStringProperty();
        this.emp_age = new SimpleIntegerProperty();
        this.job_title = new SimpleStringProperty();
        this.annual_salary = new SimpleDoubleProperty();
        this.years_employed = new SimpleIntegerProperty();
        this.leave_days = new SimpleIntegerProperty();
        this.perf_score = new SimpleIntegerProperty();
        this.manager_indicator = new SimpleIntegerProperty();

       }
    
    //STEP 3: get and set methods for each database field 
    //employee id 
    public int getemp_id() {
        return emp_id.get();
    }
 
    public void setEmployeeID(int employeeID){
    	emp_id.set(employeeID);
    }
 
    public IntegerProperty employeeIDProperty(){
        return emp_id;
    }
            
  //employee Name
    public String getemp_name () {
        return emp_name.get();
    }
 
    public void setEmployeeName(String employeeName){
    	emp_name.set(employeeName);
    }
 
    public StringProperty employeeNameProperty() {
        return emp_name;
    }
  
   //employee surname
    public String getemp_surname () {
        return emp_surname.get();
    }
 
    public void setEmployeeSurname(String employeeSurname){
    	emp_surname.set(employeeSurname);
    }
 
    public StringProperty employeeSurnameProperty() {
        return emp_surname;
    }
   
   
    //employee_age
    
    public int getemp_age () {
        return emp_age.get();
    }
 
    public void setEmployeeAge(int employeeAge){
    	emp_age.set(employeeAge);
    }
 
    public IntegerProperty employeeAgeProperty() {
        return emp_age;
    }
    
    
  //job title
    public String getjob_title () {
        return job_title.get();
    }
 
    public void setJobTitlee(String jobTitle){
    	job_title.set(jobTitle);
    }
 
    public StringProperty jobTitleProperty() {
        return job_title;
    }
    
  //annual_salary
    
    public double getannual_salary () {
        return annual_salary.get();
    }
 
    public void setAnnualSalary(double annualSalary){
    	annual_salary.set(annualSalary);
    }
 
    public DoubleProperty annualSalaryProperty() {
        return annual_salary;
    }
    
//years employed
    
    public int getyears_employed () {
        return years_employed.get();
    }
 
    public void setYearsEmployed (int yearsEmployed){
    	years_employed.set(yearsEmployed);
    }
 
    public IntegerProperty yearsEmployedProperty() {
        return years_employed;
    }
    
//leave days
    
    public int getleave_days () {
        return leave_days.get();
    }
 
    public void setLeaveDays(int leaveDays){
    	leave_days.set(leaveDays);
    }
 
    public IntegerProperty leaveDaysProperty() {
        return leave_days;
    }   
    
    
//performance score
    
    public int getperf_score () {
        return perf_score.get();
    }
 
    public void setPerfScore (int perfScore){
    	perf_score.set(perfScore);
    }
 
    public IntegerProperty perfScoreProperty() {
        return perf_score;
    } 
    
//manager indicator
    
    public int getmanager_indicator () {
        return manager_indicator.get();
    }
 
    public void setManInd (int manInd){
    	manager_indicator.set(manInd);
    }
 
    public IntegerProperty manIndProperty() {
        return manager_indicator;
    } 

}





