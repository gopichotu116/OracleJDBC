package com.gopi.testconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

		public static void main(String[] args)throws Exception{

			//load the JDBC Driver

			//11 

			//Connection Obj
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String password="tiger";
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			Connection con = DriverManager.getConnection(url, user, password);
			//JDBC Obj from Statement

			Statement st = con.createStatement();

			//write the query

			String query = "select * from emp";
			
			//create JDBC ResultSet obj

			ResultSet rs = st.executeQuery(query);

			while(rs.next()){

				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8));

			}

			rs.close();

			st.close();

			con.close();

		}

	
	}

