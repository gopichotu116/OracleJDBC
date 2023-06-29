package com.gopi.testconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DiscriptionOfTables {
	public static void main(String[] args) {
		System.out.println("Enter the query:");
		Scanner scn=new Scanner(System.in);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			String query = reader.readLine();
			String query = scn.nextLine();
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String password="tiger";
			try {
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSetMetaData metaData = ps.getMetaData();
				String c1 = metaData.getColumnName(1);
				String c2 = metaData.getColumnName(2);
				String c3 = metaData.getColumnName(3);
				System.out.println(c1);
				System.out.println(c2);
				System.out.println(c3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
