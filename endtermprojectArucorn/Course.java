package endtermprojectArucorn;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable{
    private String courseName;
    private Vector<CourseFile> files;
    private String speciality;
    private static int num = 0;
    private int courseId;
    private boolean status = false;
    private int year;
    private static final long serialVersionUID = 1L;
    
    public Course() {
    	status = false;
    	files = new Vector<CourseFile>();
    	speciality = null;
    	num++;
    	courseId = num;
    }
   
    public Course(String courseName, int year, String speciality) {
    	this();
    	this.courseName = courseName;
    	this.year = year;
    	this.speciality = speciality;
    }
    
    public int getCourseID() {
		return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getYear() {
    	return year;
    }
    
    public void setYear(int year) {
    	this.year = year;
    }
    
    public boolean getStatus() {
    	return status;
    }
    
    public void setStatus(boolean status) {
    	this.status = status;
    }
    
    public void addFile(CourseFile file) {
    	files.add(file);
    }
    
    public void addFile(Vector<CourseFile> f) {
    	files.addAll(f);
    }
    
    public void deleteFile(CourseFile file) {
    	files.remove(file);
    }
    
    public Vector<CourseFile> getFiles() {
        return files;
    }
    
    public String getSpeciality() {
        return this.speciality;
    }
    
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
     
    public void openforReg() {
    	status = true;
    }
    
    public void closeforReg() {
    	status = false;
    }

    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + year;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}
	
    public String toString() {
    	return "Name: " + courseName + " speciality: " + speciality; 
    }
   
}
