package endtermprojectArucorn;

import java.io.Serializable;

public class Mark implements Serializable{
    private String grade;
    private int score;
    
    public Mark() {
    	
    }
    
    public Mark(int score) {
    	this.score = score;
    	setGrade(score);
    }
    
    public void setGrade(int score) {
    	if (score >= 95)
    		grade = "A";
    	else if (score >= 90)
    		grade = "A-";
    	else if (score >= 85)
    		grade = "B";
    	else if (score >= 80)
    		grade = "B-";
    	else if (score >= 75)
    		grade = "C";
    	else if (score >= 70)
    		grade = "C-";
    	else if (score >= 65)
    		grade = "D";
    	else if (score >= 60)
    		grade = "D-";
    	else if (score >= 55)
    		grade = "E";
    	else if (score >= 50)
    		grade = "E-";
    	else if (score < 50)
    		grade = "F";
    }
    
    public String getGrade() {
    	return grade;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public String toString() {
    	return  grade + ": " + score;
    }
}