package endtermprojectArucorn;

import java.io.Serializable;
import java.lang.*;

public class CourseFile implements Serializable{
    private String fileName;
    
    public CourseFile() {
    	
    }
    
    public CourseFile(String fileName) {
		this.fileName = fileName;
	}
    
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());	
		return result;
	}
		
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseFile other = (CourseFile)obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		}
		if (! other.fileName.equals(fileName))
			return false;
		return true;
	}
	
	public String toString() {
		return fileName;
	}
}