package endtermprojectArucorn;

import java.io.*;
import java.util.*;

public class Data {
    static Vector<User> users = new Vector<User>();
    static Vector<Order> newOrders = new Vector<Order>();
    static Vector<Order> oldOrders = new Vector<Order>();
    static Vector<Course> courses = new Vector<Course>();

    static FileInputStream fis;
    static FileOutputStream fos;
    static ObjectOutputStream oos;
    static ObjectInputStream oin;

    public static void desCourses() throws IOException, ClassNotFoundException {
        File file = new File("courses.dat");
        if (file.exists()) {
            fis = new FileInputStream(file);
            oin = new ObjectInputStream(fis);
            courses = (Vector<Course>) oin.readObject();
        } else {
            file.createNewFile();
        }
    }

    public static void serCourses() throws IOException {
        fos = new FileOutputStream("courses.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
    }

    public static void desUsers() throws IOException, ClassNotFoundException {
        File file = new File("users.dat");
        if (file.exists()) {
            fis = new FileInputStream(file);
            oin = new ObjectInputStream(fis);
            users = (Vector<User>) oin.readObject();
        } else {
            file.createNewFile();
        }

    }

    public static void serUsers() throws IOException {
        fos = new FileOutputStream("users.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
    }

    public static void desNewOrders() throws IOException, ClassNotFoundException {
        File file = new File("newOrders.dat");
        if (file.exists()) {
            fis = new FileInputStream(file);
            oin = new ObjectInputStream(fis);
            newOrders = (Vector<Order>) oin.readObject();
            oin.close();
        } else {
            file.createNewFile();
        }
    }

    public static void serNewOrders() throws IOException {
        fos = new FileOutputStream("newOrders.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(newOrders);
        oos.close();
    }

    public static void desOldOrders() throws IOException, ClassNotFoundException {
        File file = new File("oldOrders.dat");
        if (file.exists()) {
            fis = new FileInputStream(file);
            oin = new ObjectInputStream(fis);
            oldOrders = (Vector<Order>) oin.readObject();
            oin.close();
        } else {
            file.createNewFile();
        }
    }

    public static void serOldOrders() throws IOException {
        fos = new FileOutputStream("oldOrders.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(oldOrders);
        oos.close();
    }

    public static void initCourses() {
        if (courses.isEmpty()) {
            System.out.println("Courses");
            courses.add(new Course("Calculus I", 1, "FIT"));
            courses.add(new Course("Calculus II", 1, "FIT"));
            courses.add(new Course("Calculus III", 2, "FIT"));
            courses.add(new Course("PP I", 1, "FIT"));
            courses.add(new Course("PP II", 1, "FIT"));
            courses.add(new Course("Algo", 2, "FIT"));
            courses.add(new Course("Object - Oriented Programming", 2, "FIT"));
        }
    }

    public static void initUsers() {
        if (users.isEmpty()) {
            System.out.println("Users");
            Student s1 = new Student("Mad", "Pirim");
            Admin a1 = new Admin("A", "A");
            Manager m1 = new Manager ("A", "Z");
            Teacher t1 = new Teacher("P", "S");
            TechSupportGuy techSupportGuy = new TechSupportGuy("Tech", "S");
            users.add(s1);
            users.add(a1);
            users.add(m1);
            users.add(t1); //example
            users.add(techSupportGuy);
        }
    }

    public static void load() throws IOException, ClassNotFoundException {
        desCourses();
        desNewOrders();
        desOldOrders();
        desUsers();
        initCourses();
        initUsers();
    }

    public static void save() throws IOException, ClassNotFoundException {
        serCourses();
        serNewOrders();
        serOldOrders();
        serUsers();
    }

    public static void printCourses() {
        int count = 1;
        for (Course course: courses
             ) {
            System.out.println(count++ + ") " + course);
        }
    }
}