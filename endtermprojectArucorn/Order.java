package endtermprojectArucorn;

import java.util.*;
import java.io.Serializable;
import java.lang.*;

public class Order implements Serializable {
	int userId;
	int number;
    private String orderName;
    private Date date;
    private boolean isAccepted;
	private static final long serialVersionUID = 1L;
    
    public Order() {
    	
    }
    
    public Order(int userId, String orderName, int number) {
    	this.userId = userId;
    	this.orderName = orderName;
    	this.number = number;
    }
    
    public String getName() {
        return this.orderName;
    }
    
    public void setName(String orderName) {
        this.orderName = orderName;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public boolean getIsAccepted() {
        return isAccepted;
    }
    
    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
    /**
     * Transforms string to integer in order to contribute the function "equals" run faster                         
     */
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

    public String toString() {
        return "Name: " + orderName;
    }
    
}