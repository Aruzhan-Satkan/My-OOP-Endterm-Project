package endtermprojectArucorn;

import java.util.*;

public class Student extends User {

    private String studentId; //carries the unique id number of each student
    private Date birthDate = new Date(); //carries birthdate of each student which uses new format of data type called "Date"
    private int semester; //carries number of semesters
    private int yearofStudy = 3; //carries the year of study
    private Faculty faculty; //carries info about faculty of each student
    private HashMap<Course, Mark> currentCourses = new HashMap<>();
    private static final long serialVersionUID = 1L;

    public Student() { //constructor
        super(); //extending by the class User
        semester = 3;
        faculty = Faculty.BASE;
    }

    public Student(String name, String surname) {
        super(name, surname);
        studentId = "20IT" + name;
        semester = 3;
        faculty = Faculty.FIT;
    }

    /**
     * Returns unique number of student
     *
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets unique number of student
     *
     * @param studentId
     */
    public void setId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns birthdate of student
     *
     * @return
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Returns year of study
     *
     * @return
     */
    public int getYearofStudy() {
        return yearofStudy;
    }

    /**
     * Sets year of study
     *
     * @param yearofStudy
     */
    public void setYearofStudy(int yearofStudy) {
        this.yearofStudy = yearofStudy;
    }

    /**
     * Returns semester
     *
     * @return
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Sets semester
     *
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
    /**
     * Returns current courses names of student
     * @return
     */
    /**
     * Returns faculty
     *
     * @return
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets faculty
     *
     * @param faculty
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Gets mark that teacher sets 
     *
     * @param mark
     */
    public void addMark(Course course, Mark mark) {
        if (currentCourses.containsKey(course)) {
            currentCourses.put(course, mark);
            System.out.println("Mark added ");
        } else {
            System.out.println("No such course");
        }
    }

    /**
     * 
     *
     * @param
     * @return
     */
    public void getCourseMark(int id) {
        int count = 1;
        for (Course course : currentCourses.keySet()
        ) {
            if (count == id) {
                System.out.println(currentCourses.get(course));
                return;
            }
            count++;
        }
    }


    public void printCurrentCourses() {
        String out = "";
        for (Course course : currentCourses.keySet()
        ) {
            out += course.toString() + " " + currentCourses.get(course) + "\n";
        }
        System.out.println((out.length() == 0) ? "No registered courses" : out);
    }

    /**
     * Returns all the marks from a vector
     *
     * @return
     */

    /**
     * Returns all the available courses for a registration by checking a status of a course and an year of study
     */
    public void viewCoursesForReg() {
        boolean isFound = false;
        int count = 1;
        for (Course course : Data.courses) {

            isFound = true;
            System.out.println(count++ + ") Course: " + course.getCourseID() + " " + course.getCourseName());

        }
        if (!isFound) System.out.println("No any courses for registration");
    }

    /**
     * Adds a course for a vector of the current courses
     *
     * @param
     */
    public void registerForCourse(int num) {
        int count = 1;
        for (Course course : Data.courses) {
            if (count == num) {
                currentCourses.put(course, new Mark(0));
                return;
            }
            count++;

        }
        System.out.println("No such course for registration");
    }

    /**
     * Returns the files for all the courses added by a teacher
     */
    public void viewCourseFiles() {
        for (Course course : currentCourses.keySet()) {
            System.out.println(course + ":");
            for (CourseFile file : course.getFiles())
                System.out.println(" " + file);
        }
    }

    public HashMap<Course, Mark> getCurrentCourses() {
        return currentCourses;
    }

    /**
     * Returns data about a student
     */
    public void showStudentInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Student: " +
                "name = " + getName() +
                ", surname = " + getSurname() +
                ", studentId = " + studentId +
                ", birthDate = " + birthDate +
                ", semester = " + semester +
                ", yearofStudy = " + yearofStudy +
                ", faculty = " + faculty;
    }
}
