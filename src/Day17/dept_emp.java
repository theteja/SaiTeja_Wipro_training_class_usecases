package Day17;

import java.sql.*;
import java.util.Scanner;

public class dept_emp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "pass@word1");

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            String query = "SELECT * FROM employee WHERE department=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, dept);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                System.out.println(  rs.getInt("empid") + " " + rs.getString("name") + " " + rs.getDouble("salary"));
            }

            con.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}