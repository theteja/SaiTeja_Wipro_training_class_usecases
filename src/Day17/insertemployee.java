package Day17;

import java.sql.*;

public class insertemployee {

    public static void main(String[] args) {

    	String url="jdbc:mysql://localhost:3306/company";
    	String user="root";
    	String pass="pass@word1";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            
            pst.setInt(1, 101);
            pst.setString(2, "Rahul");
            pst.setString(3, "IT");
            pst.setDouble(4, 55000);
            pst.executeUpdate();

         
            pst.setInt(1, 102);
            pst.setString(2, "Amit");
            pst.setString(3, "HR");
            pst.setDouble(4, 45000);
            pst.executeUpdate();

           
            pst.setInt(1, 103);
            pst.setString(2, "Neha");
            pst.setString(3, "Finance");
            pst.setDouble(4, 70000);
            pst.executeUpdate();

        
            pst.setInt(1, 104);
            pst.setString(2, "Priya");
            pst.setString(3, "IT");
            pst.setDouble(4, 60000);
            pst.executeUpdate();

            pst.setInt(1, 105);
            pst.setString(2, "Karan");
            pst.setString(3, "Sales");
            pst.setDouble(4, 50000);
            pst.executeUpdate();

            System.out.println("5 Records Inserted Successfully");

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}