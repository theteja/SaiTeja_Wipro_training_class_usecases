package Day17;

import java.sql.*;
import java.util.Scanner;

public class crud {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        
        String url="jdbc:mysql://localhost:3306/company";
    	String username="root";
    	String password="pass@word1";

        try {

           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            while(true) {

                System.out.println("\n----- CRUD MENU -----");
                System.out.println("1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                switch(choice) {

            
                    case 1:

                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery = "INSERT INTO employee VALUES (?, ?, ?, ?)";

                        PreparedStatement pst1 = con.prepareStatement(insertQuery);

                        pst1.setInt(1, id);
                        pst1.setString(2, name);
                        pst1.setString(3, dept);
                        pst1.setDouble(4, salary);

                        int rows1 = pst1.executeUpdate();

                        if(rows1 > 0) {
                            System.out.println("Employee Inserted Successfully");
                        }

                        break;

                  
                    case 2:

                        String selectQuery = "SELECT * FROM employee";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(selectQuery);

                        System.out.println("\nEmployee Records");
                        System.out.println("-------------------------");

                        while(rs.next()) {

                            System.out.println( rs.getInt("empid") + " " + rs.getString("name") + " " + rs.getString("department") + " " +
                                    rs.getDouble("salary"));
                        }

                        break;

                 
                    case 3:

                        System.out.print("Enter Employee ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery =  "UPDATE employee SET salary=? WHERE empid=?";

                        PreparedStatement pst2 = con.prepareStatement(updateQuery);

                        pst2.setDouble(1, newSalary);
                        pst2.setInt(2, updateId);

                        int rows2 = pst2.executeUpdate();

                        if(rows2 > 0) {
                            System.out.println("Salary Updated Successfully");
                        } 
                        else {
                            System.out.println("Employee Not Found");
                        }

                        break;

                
                    case 4:

                        System.out.print("Enter Employee ID to Delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM employee WHERE empid=?";

                        PreparedStatement pst3 = con.prepareStatement(deleteQuery);

                        pst3.setInt(1, deleteId);

                        int rows3 = pst3.executeUpdate();

                        if(rows3 > 0) {
                            System.out.println("Employee Deleted Successfully");
                        } else {
                            System.out.println("Employee Not Found");
                        }

                        break;

                    case 5:

                        System.out.println("Program Exited");
                        con.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
