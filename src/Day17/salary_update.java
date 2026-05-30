package Day17;

import java.sql.*;
import java.util.Scanner;

public class salary_update{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "pass@word1");
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            String query ="UPDATE employee SET salary=? WHERE empid=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setDouble(1, salary);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                System.out.println("Salary Updated");
            }
            else {
                System.out.println("Employee Not Found");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
