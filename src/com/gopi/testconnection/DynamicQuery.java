package com.gopi.testconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicQuery {
	public static void main(String[] args) {
		System.out.println("Enter the query:");
		Scanner scn=new Scanner(System.in);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
//			String query = reader.readLine();
			String query = scn.nextLine();
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String password="tiger";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			boolean execute = stmt.execute(query);
			System.out.println(execute);
			String[] split = query.split(" ");
			for(String s:split) {
				
				if(s.equalsIgnoreCase("emp")) {
					if(execute) {
						ResultSet res = stmt.executeQuery(query);
						while(res.next()) {
							int id = res.getInt(1);
							String name = res.getString(2);
							String job = res.getString(3);					
							int mgr = res.getInt(4);
							Date joindate = res.getDate(5);
							int sal = res.getInt(6);
							int comm = res.getInt(7);
							int deptNo = res.getInt(8);
							System.out.println(id+" -> "+name+" -> "+job+" -> "+mgr+" -> "+joindate+" -> "+sal+" -> "+comm+" -> "+deptNo);
						}
					
				    }
			    }
				if(s.equalsIgnoreCase("dept")) {
					if(execute) {
						ResultSet res1 = stmt.executeQuery(query);
						while(res1.next()) {
							int id = res1.getInt(1);
							String name = res1.getString(2);
							String loc = res1.getString(3);
							System.out.println(id+" -> "+name+" -> "+loc);
						}
					}
				}
				if(s.equalsIgnoreCase("bonus")) {
					if(execute) {
						ResultSet res1 = stmt.executeQuery(query);
						while(res1.next()) {
							String name = res1.getString(1);
							String job = res1.getString(2);
							int sal = res1.getInt(3);
							int comm = res1.getInt(3);
							System.out.println(name+" -> "+job+" -> "+sal+" -> "+comm);
						}
					}
				}
				if(s.equalsIgnoreCase("salgrade")) {
					if(execute) {
						ResultSet res1 = stmt.executeQuery(query);
						while(res1.next()) {
							int grade = res1.getInt(1);
							int lowsal = res1.getInt(2);
							int highsal = res1.getInt(3);
							System.out.println(grade+" -> "+lowsal+" -> "+highsal);
						}
					}
				}
			}
			conn.close();
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
