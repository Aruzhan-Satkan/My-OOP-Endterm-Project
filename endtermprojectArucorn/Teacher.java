package endtermprojectArucorn;

import java.util.*;

public class Teacher extends Employee implements CanSendMessage {

    private Vector<Course> courses = new Vector<>();//carries all the courses in a vector
    private Vector<Mail> mails = new Vector<>();


    public Teacher() {//constructor
        super();//extends empty Employee constructor
    }

    public Teacher(String name, String surname) {//constructor
        super(name, surname);//extends Employee constructor with a name and a surname
    }


    /**
     * This is how we get the courses from a vector
     *
     * @return
     */
    public Vector<Course> getCourses() {
        return courses;
    }


    /**
     * This is how we set the courses
     *
     * @param courses
     */
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    /**
     * This is how we add the courses to the teachers
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * This is how we remove the courses
     *
     * @param c
     */
    public void removeCourse(Course c) {
        courses.remove(c);
    }

    /**
     * This is how we view the courses by going through a loop and printing them
     */
    public void viewCourse() {
        for (Course c : courses) {
            System.out.println("Name: " + c.getCourseName());
        }
    }

    /**
     * This is how we view the courses by going through a loop and printing them
     *
     * @param m
     * @param s
     */
    public void putMarks(Mark m, Student s, Course course) {
        for (User user : Data.users
        ) {
            if (user instanceof Student) {
                if (((Student) user).equals(s)) {
                    ((Student) user).addMark(course, m);
                }
            }
        }
    }

    /**
     * This is how we add the orders for it support guy
     *
     * @param name
     * @param number
     */
    public void sendOrderToIT(String name, int number) {
        Order o = new Order(getId(), name, number);
        Data.newOrders.add(o);
    }

    /**
     * This is how we add the files for coursefiles
     *
     * @param file
     * @param c
     */
    public void addFile(CourseFile file, Course c) {
        courses.get(courses.indexOf(c)).addFile(file);
    }

    /**
     * This is how we delete the files from coursefiles
     *
     * @param file
     * @param c
     */
    public void removeFile(CourseFile file, Course c) {
        courses.get(courses.indexOf(c)).deleteFile(file);
    }

    /**
     * This is how we send a mail to vector that sends the mails
     *
     * @param
     */
    public boolean sendMail(String heading, String message, String receiver) {
        for (User user : Data.users
        ) {
            if (user instanceof CanSendMessage && user.getLogin().equals(receiver)) {
                Mail mail = new Mail(heading, message, this, user);
                mails.add(mail);
                ((CanSendMessage) user).receiveMail(mail);
                return true;
            }
        }
        return false;

    }

    /**
     * This is how we send a mail to vector that stores received mails
     *
     * @param
     */
    public void receiveMail(Mail mail) {
        mails.add(mail);
    }

    public void viewMails() {
        boolean found = false;
        for (Mail mail : mails
        ) {
            if (mail.getReceiver().equals(this)) {
                System.out.println(mail);
                found = true;
            }
        }
        if (!found) System.out.println("Mails are not found");
    }

    /**
     *Transforms string to integer to contribute the function "equals" run faster
     */
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((courses == null) ? 0 : courses.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return getLogin().equals(teacher.getLogin());
    }

    /**
     * Overriden equals
     */

    public void viewStudents() {
        boolean found = false;
        for (Course course : courses
        ) {
            for (User user : Data.users
            ) {
                if (user instanceof Student) {
                    Student student = (Student) user;
                    if (student.getCurrentCourses().keySet().contains(course)) {
                        System.out.println(student);
                        found = true;
                    }
                }
            }
        }
        if (!found) System.out.println("There are no students in your courses");
    }

    public String coursesToString() {
        String out = "";
        for (int i = 0; i < courses.size(); i++) {
            out += (i + 1) + ") " + courses.get(i).toString() + "\n";
        }
        return (out.length() == 0) ? "No Courses are found" : out;

    }

    @Override
    public String toString() {
        return "Teacher: " +
                " name = " + getName() +
                ", surname = " + getSurname() +
                ", teacherId = " + getId();
    }
}