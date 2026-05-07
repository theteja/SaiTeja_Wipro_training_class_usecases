package Day12;
import java.io.*;



class EmployeeManagement implements Serializable {
 int id;
 String name;
 double salary;
 EmployeeManagement(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
 void display() {
     System.out.println("Employee ID: " + id);
     System.out.println("Employee Name: " + name);
     System.out.println("Salary: " + salary);
 }
}
public class Employee {

	public static void main(String[] args) {

		EmployeeManagement emp = new EmployeeManagement(101, "Teja", 55000);

       

        try {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("employee.dat"));
            oos.writeObject(emp);
            oos.close();
            System.out.println("Employee object saved.");
       
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
            EmployeeManagement e = (EmployeeManagement) in.readObject();
            System.out.println("\nEmployee Details Retrieved:");
            e.display();
            in.close();
        } 
        catch (IOException | ClassNotFoundException e) {

            System.out.println(e);

        }

    }

	

}
