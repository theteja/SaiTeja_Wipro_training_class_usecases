package Day17;

import java.sql.*;
import java.util.Scanner;

public class delete_emp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "pass@word1");

            System.out.print("Enter Employee ID to Delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM employee WHERE empid=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                System.out.println("Employee Deleted");
            } else {
                System.out.println("Employee Not Found");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

