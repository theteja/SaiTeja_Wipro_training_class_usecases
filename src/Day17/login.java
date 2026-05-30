package Day17;

import java.sql.*;
import java.util.Scanner;

public class login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "pass@word1");


            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query =  "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                System.out.println("Login Successful");
            } 
            else {
                System.out.println("Invalid Login");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}