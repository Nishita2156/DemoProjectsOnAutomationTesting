package com.osa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManger {
	public static void main(String[] args) {
		List<Address> addre=getAddressT("SELECT * FROM Address WHERE address_id=5;");
		for(Address ad:addre) {
			System.out.println(ad.getStreet().equals("9906 57th Ave."));
		}
	}
	
	public static List<Address> getAddressT(String sqlQuery) {
		List<Address> address=new ArrayList<Address>();
		try {
			String url="jdbc:mysql://127.0.0.1:3306/nishitaalam"; //connection string
			String username="root";
			String password="";
			Connection con=DriverManager.getConnection(url, username, password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sqlQuery);
			while(rs.next()) {
				String addId=rs.getString("address_id");
				String str=rs.getString("street");
				String city=rs.getString("city");
				String zip=rs.getString("zip");
				address.add(new Address(addId,str,city,zip));		
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return address;
	}
}
