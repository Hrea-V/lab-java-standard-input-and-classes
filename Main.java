import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String Employee = "Employee.txt";  //define the name to be used in the future.
        File file = new File(Employee); //transform the string to be a File.
        if (!file.exists()) { //if the file with the name does not exist, then do this.
            FileWriter writer = new FileWriter(file); //create the file, it's not necessary to change to True, as it will not run this line unless the file does not exist.
            writer.write("Employee List \n"); //add an initial text to the file.
            writer.close();
        }

        Scanner scanner = new Scanner(System.in); //create a scanner.
        System.out.println("Do you wish to create a new employee? Y or N"); //prompt the user to input.
        String answer = scanner.nextLine(); //open the input for the user.

        if (answer.equalsIgnoreCase("y")) { //if the user input is = to this.

            while (true) {       //loop to create a new employee.
                var intern1 = new Intern();

                // ================= NAME ================ //
                System.out.println("Please input the Name"); //prompt the user to input.
                String name = scanner.nextLine(); //open the input for the user.
                while (name.isBlank()) {
                    System.out.println("The name should have at least 1 character");
                    name = scanner.nextLine();
                }
                intern1.Name = name;

                // ================= Email ================ //
                System.out.println("Please input the Email."); //prompt the user to input.
                String email = scanner.nextLine(); //open the input for the user.
                while (!email.contains("@")) {  // i found ".contain()" while looking for resources.
                    System.out.println("the Email should have an '@'.");
                    email = scanner.nextLine();
                }
                intern1.Email = email;

                // ================= Age ================ //
                System.out.println("Please input the Age."); //prompt the user to input.
                int age = Integer.parseInt(scanner.nextLine()); //open the input for the user.
                while (age < 18) { //check age
                    System.out.println("Age should not be less than 18.");
                    age = Integer.parseInt(scanner.nextLine());
                }
                intern1.Age = age;

                // ================= Salary ================ //
                System.out.println("Please input the Salary"); //prompt the user to input.
                int salary = Integer.parseInt(scanner.nextLine()); //open the input for the user.
                while (salary > intern1.salaryLimit) { //check for the salary limit.
                    System.out.println("A intern can not have a salary surpassing 20k");
                    salary = (scanner.nextInt());
                }
                while (salary < 0) { //salary should not be less than 0
                    System.out.println("The salary can not be less than 0");
                    salary = (scanner.nextInt());
                }
                intern1.Salary = salary;

                // ================== Print in File ============== //
                FileWriter writer = new FileWriter(file, true);
                writer.write("Name: " + intern1.Name + " , Email: " + intern1.Email + " , Age: " + intern1.Age + " , Salary: " + intern1.Salary);
                writer.close();

                // ================= Repeat ================ //
                System.out.println("Do you wish to create one more employee? y or n"); //question if you want to create another new employee.
                String c = scanner.nextLine();
                if (c.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }
}

