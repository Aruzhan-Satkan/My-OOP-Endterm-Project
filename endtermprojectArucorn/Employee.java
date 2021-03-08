package endtermprojectArucorn;

import java.io.Serializable;

public class Employee extends User implements Comparable<Employee>{
	
    private String insuranceNumber;
    private int salary;
    
    public Employee() {
    	super();
    	salary = 0;
    	insuranceNumber = null;
    }
    
    public Employee(String name, String surname) {
    	super(name, surname);
    }
    
    public String getInsuranceNumber() {
        return insuranceNumber;
    }
    
    private void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    
    private int getSalary() {
        return salary;
    }
    
    private void setSalary(Integer salary) {
        this.salary = salary;
    }
    /**
     * Transforms string to integer in order to contribute the function "equals" run faster                         
     */
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + salary;
		result = prime * result + ((insuranceNumber == null) ? 0 : insuranceNumber.hashCode());
		return result;
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee e = (Employee) obj;
		if (insuranceNumber == null) {
			if (e.getInsuranceNumber() != null)
				return false;
		}
		else if (!insuranceNumber.equals(e.getInsuranceNumber()))
			return false;
		if (e.getSalary() != salary)
			return false;
		return true;
	}
	
	public String toString(){
			return super.toString();
	} 
	/**
	 * Function in order to compare employee by salary
	 */
	@Override
	public int compareTo(Employee o) {
		return this.salary - o.salary; 
	}
    
}
