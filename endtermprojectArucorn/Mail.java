package endtermprojectArucorn;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Mail implements Serializable {
	private Date date;
	private String heading;
	private String message;
	private User sender;
	private User receiver;
	private static final long serialVersionUID = 1L;

	public Mail() { 
		message = "";
		date = new Date();
	}

	public Mail(String heading, String message, User sender, User receiver) {
		date = new Date();
		this.heading = heading;
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
	}

	public Date getDate() {
        return this.date;
    }

	public void setDate(Date date) {
        this.date = date;
    }

	public String getMessage() {
        return this.message;
    }

	public void setMessage(String message) {
        this.message = message;
    }

	public User getSender() {
        return this.sender;
    }

	public void setSender(User sender) {
        this.sender = sender;
    }

	public User getReceiver() {
        return this.receiver;
    }

	public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		Mail other = (Mail) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
    
	public String toString() {
    	return "Send by: " + sender.toString() + "\n" + heading + ":: " + date + " \n" + message;
    }
}