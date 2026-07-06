package com.osa.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_connection {
	public static void main(String[] args) throws SQLException {
		String dburl="jdbc:mysql://localhost:3306/osa";
		String username="root";
		String password="";
		String query="Select * from address;";
		Connection con=DriverManager.getConnection(dburl,username,password);
		Statement sta=con.createStatement();
		ResultSet rs=sta.executeQuery(query);
		while(rs.next()) {
			String address_id=rs.getString(1);
			String street =rs.getString(2);
			String city= rs.getString(3);
			int zip =rs.getInt(4);
			System.out.println(address_id+" "+street+" "+city+" "+zip);
			
		}
		 con.close();
	}

}
