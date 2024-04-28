package Jdbc;

import java.sql.*;


public class Connectivity {
	public static void main (String[]args){
		method();
		insert();
		insertVarible();
		prparedStatement();
		delete();
		update();
		update1()
	}	
  
	                                                 //retrive
	
	private static void method() {
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select* from connectivity");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}      

	
	                                                  //insert
	
	
	private static void insert() {
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			Statement st=con.createStatement();
			int result = st.executeUpdate("insert into connectivity values ('aji',2)");
			System.out.println("number of rows affected ="+result);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	            
	
	                                                //insert with  varible
	
private static void insertVarible() {
		
	String name="kasi";
	int no=5;	
	String query="insert into connectivity values ("+name+","+no+")";
	
		try {
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			Statement st=con.createStatement();
			int result = st.executeUpdate(query);
			System.out.println("number of rows affected ="+result);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	
	                                                   // prepared statement
	
	
	private static void prparedStatement() {
		
		String name="kasi";
		int no=5;	
		String query="insert into connectivity values (?,?)";
		
                          try{
				
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, name);
				pst.setInt(2, no);
				int result = pst.executeUpdate();
				System.out.println("number of rows affected ="+result);
				con.close();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			
		}
	
	
	                                                     //delete
	
private static void delete() {
	
	
	int id_no=4;	  //deleted id
	String query="delete from connectivity where id="+id_no;
	
		try {
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			Statement st=con.createStatement();
			int result = st.executeUpdate(query);
			System.out.println("number of rows affected ="+result);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	
	
	                                                 //update
	
	private static void update() {
		
		
			 //deleted id
		String query="update connectivity set id=1 where Student name='aji'";
		
			try {
				
				
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
				Statement st=con.createStatement();
				int result = st.executeUpdate(query);
				System.out.println("number of rows affected ="+result);
				con.close();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			
		}

	
	                                                  // calling simple stored procedure
	private static void update1() {
		
	
		try {
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			CallableStatement cst=con.prepareCall("{call Getjdbc()}");
			ResultSet rs=cst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	}
	
