package Day17;

import java.sql.*;

public class count_emp {

    public static void main(String[] args) {

        try {

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "pass@word1");


            String query = "SELECT COUNT(*) AS total FROM employee";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            if(rs.next()) {
                System.out.println("Total Employees: " + rs.getInt("total"));
            }

            con.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
