package endtermprojectArucorn;
import java.util.*;

public class Manager extends Employee implements CanSendMessage {
    private Vector<Mail> mails = new Vector<>();

    public Manager() {
    	super();
    }
    
    public Manager(String name, String surname) {
    	super(name, surname);
    	
    }
    
    public void addCourseRegister(Course course) {
         Data.courses.add(course);
    }
    
    public void viewStudentsInfo(String howCompare) {
        Vector<Student> students = new Vector<>();
        for (User user: Data.users
             ) {
            if (user instanceof Student)
                students.add((Student) user);
        }
        Collections.sort(students, new Comparator<Student>() {
            
            public int compare(Student o1, Student o2) {
                if (howCompare.equals("name")) {
                    return o1.getName().compareTo(o2.getName());
                } else if (howCompare.equals("id")) {
                    return Integer.compare(o1.getId(), o2.getId());
                }
                return 0;
            }
        });
        for (Student student: students
             ) {
            System.out.println(student);
        }
    }
   
    public void viewTeachersInfo(String howCompare) {
        Vector<Teacher> teachers = new Vector<>();
        for (User user: Data.users
        ) {
            if (user instanceof Teacher)
                teachers.add((Teacher) user);
        }
        Collections.sort(teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (howCompare.equals("name")) {
                    return o1.getName().compareTo(o2.getName());
                } else if (howCompare.equals("id")) {
                    return Integer.compare(o1.getId(), o2.getId());
                }
                return 0;
            }
        });
        for (Teacher teacher: teachers
        ) {
            System.out.println(teacher);
        }
    }

    /**
     * This is how we send mails to vector that stores sending mails
     *
     * @param
     */
    public boolean sendMail(String heading, String message, String receiver) {
        for (User user: Data.users
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
     * This is how we send mails to vector that stores received mails
     *
     * @param
     */
    public void receiveMail(Mail mail) {
        mails.add(mail);
    }

    public void viewMails() {
        boolean found = false;
        for (Mail mail: mails
        ) {
            if (mail.getReceiver().equals(this)) {
                System.out.println(mail);
                found = true;
            }
        }
        if (!found) System.out.println("Mails not found");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(getId(), manager.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        return result;
    }

    @Override
    public String toString() {
        return "Manager: " +
                "name = " + getName() +
                ", surname = " + getSurname();
    }
}
