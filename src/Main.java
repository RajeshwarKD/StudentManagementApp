import com.student.manage.Student;
import com.student.manage.StudentData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intVal =new Scanner(System.in); // for integer value
        Scanner strVal = new Scanner(System.in); // for string value
        int choice;
        System.out.println("Welcome to the Student Management App");
        do {
            System.out.println("PRESS 1 to create Students");
            System.out.println("PRESS 2 to delete Students");
            System.out.println("PRESS 3 to display Students");
            System.out.println("PRESS 4 to update Students");
            System.out.println("PRESS 0 to exit App");
            choice =intVal.nextInt();

            switch (choice) {
                case 1: // add/create students
                    System.out.println("Enter student name :");
                    String name = strVal.nextLine();

                    System.out.println("Enter student phone no :");
                    String phone = strVal.nextLine();

                    System.out.println("Enter student city name :");
                    String city = strVal.nextLine();

                    // create student object to store student
                    Student st = new Student(name, phone, city);
                    boolean create = StudentData.insertStudentDataToDB(st);
                    if (create){
                        System.out.println("Student data is successfully created...");
                    }else {
                        System.out.println("Something went wrong try again....");
                    }
                    System.out.println(st);

                    break;

                case 2: // delete students
                    System.out.println("Enter student id to delete :");
                    int studentId = intVal.nextInt();
                    boolean delete = StudentData.deleteStudentDataInBD(studentId);
                    if (delete){
                        System.out.println("Student record is successfully deleted...");
                    }else {
                        System.out.println("Something went wrong try again....");
                    }
                    break;

                case 3: // read/ display students
                    StudentData.showAllStudentDataOfDB();
                    break;

                case 4: // update students
                    System.out.println("Enter student id to update :");
                    int oldStudentId = intVal.nextInt();

                    System.out.println("Enter student new name for update :");
                    String newName = strVal.nextLine();

                    System.out.println("Enter student new phone no for update :");
                    String newPhone = strVal.nextLine();

                    System.out.println("Enter student new city name for update :");
                    String newCity = strVal.nextLine();

                    // create student object to store student
                    Student updateStudent = new Student(oldStudentId, newName, newPhone, newCity);
                    boolean update =StudentData.updateStudentDataInBD(updateStudent);
                    if (update){
                        System.out.println("Student record is successfully updated...");
                    }else {
                        System.out.println("Something went wrong try again....");
                    }
                    break;

                default:
                    System.out.println("please enter valid number");
            }
        } while (choice!=0);
        System.out.println("Thanking you for using my application & See you soon again .... ");
    }
}

