package Day16;

import java.sql.*;

public class InsertData_Ex {

public static void main(String[] args)

{
	try{

		String url="jdbc:mysql://localhost:3306/ecommerce";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "pass@word1");
		Statement st=con.createStatement();
		String query="insert into Customers values(5,'Rohit', 'rohit@gmail.com', 55555555,'Vij')";
		int rows=st.executeUpdate(query);
		System.out.println(rows + " row inserted");
		con.close();

	}
	catch(Exception e){
		System.out.println(e);
	}

	

}

 

}
