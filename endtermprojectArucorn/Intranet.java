package endtermprojectArucorn;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class Intranet {
    static BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader reader;
    BufferedWriter writer;

    public static int cmd;


    public static boolean showUsers() {
        if (Data.users.size() == 0) {
            System.out.println("No users yet");
            return false;
        }
        for (int i = 0; i < Data.users.size(); i++) {
            System.out.println(i + 1 + "." + Data.users.get(i));
        }
        return true;
    }

    public static boolean showCourses() {
        if (Data.courses.size() == 0) {
            System.out.println("No courses yet");
            return false;
        }
        for (int i = 0; i < Data.courses.size(); i++) {
            System.out.println(i + 1 + "." + Data.courses.get(i));
        }
        return true;
    }


    public static User authenticate() throws IOException, ClassNotFoundException {
        int cnt = 0;
        while (cnt < 3) {
            System.out.println("Please enter your login: ");
            String login = buff.readLine();
            if (login.equals("exit")) {
                System.out.println("Have a nice day!");
                break;
            }
            System.out.println("Enter your password: ");
            String password = buff.readLine();
            for (User u : Data.users) {
                if (u.login(login, password)) {
                    return u;
                }
            }
            cnt++;
        }
        Data.save();
        System.out.println("Sorry, incorrect user or password, please try later");
        System.exit(0);
        return null;
    }

    public static boolean studentMode(Student student) throws IOException {

        System.out.println("1 -> Exit");
        System.out.println("2 -> Get information");
        System.out.println("3 -> Register for a course");
        System.out.println("4 -> View the courses for Registration");
        System.out.println("5 -> View files of course");
        System.out.println("6 -> View marks for specific course");
        String cmd = buff.readLine();
        switch (cmd) {
            case "1":
                return false;
            case "2":
                student.showStudentInfo();
                break;
            case "3":
                student.viewCoursesForReg();
                System.out.println("Please enter a number of course you want to register for");
                int index = Integer.parseInt(buff.readLine());
                student.registerForCourse(index);
                break;
            case "4":
                student.viewCoursesForReg();
                break;
            case "5":
                student.viewCourseFiles();
                break;
            case "6":
                student.printCurrentCourses();
                System.out.println("Enter a number of your course");
                int courseId = Integer.parseInt(buff.readLine());
                student.getCourseMark(courseId);
                break;
            default:
                System.out.println("There is no such case, try again");
        }
        return true;

    }

    public static boolean teacherMode(Teacher teacher) throws IOException {

        System.out.println("1 -> Exit");
        System.out.println("2 -> Get information");
        System.out.println("3 -> Put marks");
        System.out.println("4 -> Add Course File");
        System.out.println("5 -> Delete Course File");
        System.out.println("6 -> Send Order to IT");
        System.out.println("7 -> Send mail");
        System.out.println("8 -> View courses");
        System.out.println("9 -> View mails");
        System.out.println("10 -> View my courses");
        System.out.println("11 -> Add course");
        String cmd = buff.readLine();
        switch (cmd) {
            case "1":
                return false;
            case "2":
                System.out.println(teacher.toString());
                break;
            case "3":
                teacher.viewStudents();
                System.out.println("Enter a student name and surname ");
                String name = buff.readLine();
                String surname = buff.readLine();
                Student s = new Student(name, surname);
                System.out.println("Enter score: ");
                int score = Integer.parseInt(buff.readLine());
                System.out.println(teacher.coursesToString());
                System.out.println("Please enter course number ");
                int courseId = Integer.parseInt(buff.readLine());
                Mark m = new Mark(score);
                teacher.putMarks(m, s, teacher.getCourses().get(courseId - 1));
                break;
            case "4":
                System.out.println("Enter file name");
                String courseName = buff.readLine();
                CourseFile file = new CourseFile(courseName);
                System.out.println("Enter course number ");
                int number = Integer.parseInt(buff.readLine());
                Course c = Data.courses.get(number);
                teacher.addFile(file, c);
                break;
            case "5":
                System.out.println("Enter file name");
                String coursename = buff.readLine();
                CourseFile coursefile = new CourseFile(coursename);
                System.out.println("Enter course number ");
                int coursenumber = Integer.parseInt(buff.readLine());
                Course course = Data.courses.get(coursenumber);
                teacher.removeFile(coursefile, course);
                break;
            case "6":
                System.out.println("Enter order name: ");
                String orderName = buff.readLine();
                System.out.println("Enter order Number: ");
                int orderNo = Integer.parseInt(buff.readLine());
                teacher.sendOrderToIT(orderName, orderNo);
                break;
            case "7":
                System.out.println("Enter heading: ");
                String heading = buff.readLine();
                System.out.println("Enter your message: ");
                String msg = buff.readLine();
                System.out.println("Enter receiver login: ");
                String receiver = buff.readLine();
                teacher.sendMail(heading, msg, receiver);
            case "8":
                teacher.viewCourse();
                break;
            case "9":
                teacher.viewMails();
                break;
            case "10":
                System.out.println(teacher.coursesToString());
                break;
            case "11":
                Data.printCourses();
                System.out.println("Choose one from courses: ");
                int choice = Integer.parseInt(buff.readLine());
                teacher.addCourse(Data.courses.get(choice - 1));
                break;
            default:
                System.out.println("No such case");
        }
        return true;

    }

    public static boolean adminMode(Admin admin) throws IOException {
        System.out.println("1 -> Exit");
        System.out.println("2 -> Get information");
        System.out.println("3 -> Create user");
        System.out.println("4 -> Update info");
        String cmd = buff.readLine();
        switch (cmd) {
            case "1":
                return false;
            case "2":
                admin.getInfo();
                break;
            case "3":
                createUser();
                break;
            case "4":
                System.out.println("1) Update name \n 2) Update surname \n 3) Update password");
                int choice = Integer.parseInt(buff.readLine());
                System.out.println("Enter ID of user");
                int ID = Integer.parseInt(buff.readLine());
                System.out.println("Enter info");
                String info = buff.readLine();
                admin.updateUser(choice, info, ID);
                break;
            default:
                System.out.println("No such case, try again");
        }
        return true;
    }

    public static boolean managerMode(Manager manager) throws IOException {
        System.out.println("1 -> Exit");
        System.out.println("2 -> Get information");
        System.out.println("3 -> Add course for Registration");
        System.out.println("4 -> View student information");
        System.out.println("5 -> View teacher information");
        System.out.println("6 -> Send mail");
        System.out.println("7 -> View mails");
        String cmd = buff.readLine();
        switch (cmd) {
            case "1":
                return false;
            case "2":
                manager.getInfo();
                break;
            case "3":
                System.out.println("Enter a name of course");
                String name = buff.readLine();
                System.out.println("Enter a specialty");
                String specialty = buff.readLine();
                System.out.println("Enter a teacher's name and surname");
                String teacherInfo = buff.readLine();
                System.out.println("Enter a year");
                int year = Integer.parseInt(buff.readLine());
                Course c = new Course(name, year, specialty);
                boolean found = false;
                for (User user : Data.users
                ) {
                    if (user instanceof Teacher) {
                        ((Teacher) user).addCourse(c);
                        found = true;
                        System.out.println("Course added!");
                        break;
                    }
                }
                if (!found) System.out.println("Teacher is not found!");
                manager.addCourseRegister(c);
                break;
            case "4":
                System.out.println("Enter an option to sort students");
                String option = buff.readLine();
                manager.viewStudentsInfo(option);
                break;
            case "5":
                System.out.println("Enter an option to sort teachers");
                String choice = buff.readLine();
                manager.viewTeachersInfo(choice);
                break;
            case "6":
                System.out.println("Enter a heading: ");
                String heading = buff.readLine();
                System.out.println("Enter your message: ");
                String msg = buff.readLine();
                System.out.println("Enter receiver login: ");
                String receiver = buff.readLine();
                manager.sendMail(heading, msg, receiver);
                break;
            case "7":
                manager.viewMails();
                break;
            default:
                System.out.println("There is no such case, try again");
        }
        return true;

    }

    public static boolean techSupportMode(TechSupportGuy tech) throws IOException {
        System.out.println("1 -> Exit");
        System.out.println("2 -> Get information");
        System.out.println("3 -> View new orders");
        System.out.println("4 -> View all orders");
        System.out.println("5 -> Make an order");
        String cmd = buff.readLine();
        switch (cmd) {
            case "1":
                return false;
            case "2":
                tech.getInfo();
            case "3":
                System.out.println(tech.viewNewOrders());
                break;
            case "4":
                tech.showAllOrders();
                break;
            case "5":
                if (Data.newOrders.isEmpty()) {
                    System.out.println("There are no orders!");
                }  else {
                    System.out.println(Data.newOrders.get(0));
                    System.out.println("Do you accept or decline?");
                    String choice = buff.readLine();
                    if (choice.equalsIgnoreCase("accept")) {
                        tech.accept(Data.newOrders.get(0));
                    } else {
                        tech.reject(Data.newOrders.get(0));
                    }
                }
                break;
            default:
                System.out.println("There is no such case, try again");
        }
        return true;

    }

    public static void createUser() throws IOException {
        NewUser newUser = new NewUser();
        System.out.println("User type : ");
        String userType = buff.readLine();
        System.out.println("FistName : ");
        String firstName = buff.readLine();
        System.out.println("LastName : ");
        String lastName = buff.readLine();
        User user = newUser.getUser(userType, firstName, lastName);
        if (user instanceof Student) {
            System.out.println("Faculty : ");
            String faculty = buff.readLine();
            ((Student) user).setFaculty(Faculty.valueOf(faculty));
        }

        if (!Data.users.contains(user)) {
            Data.users.add(user);
            System.out.println("Successful added new user with ID : \t" + user.getId());
        } else {
            System.out.println("User already exists");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        if (new File("courses.ser").exists()) {
            Data.desCourses();
        }
        if (new File("users.ser").exists()) {
            Data.desUsers();
        }
        //Data.users.clear();
        try {
            System.out.println("Welcome!");
            Data.load();
            showUsers();
            authentication:
            while (true) {

                User curUser = authenticate();

                System.out.println("You signed in! Your account:" + curUser.toString() + "!");
                menu:
                while (true) {
                    if (curUser instanceof Student) {
                        if (!studentMode((Student) curUser))
                            break;
                    } else if (curUser instanceof Teacher) {
                        if (!teacherMode((Teacher) curUser))
                            break;
                    } else if (curUser instanceof Admin) {
                        if (!adminMode((Admin) curUser))
                            break;
                    } else if (curUser instanceof Manager) {
                        if (!managerMode((Manager) curUser))
                            break;
                    } else if (curUser instanceof TechSupportGuy) {
                        if (!techSupportMode((TechSupportGuy) curUser))
                            break;
                    }

                }
                Data.save();

            }

        } catch (Exception e) {
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            Data.save();
        }
    }
}
