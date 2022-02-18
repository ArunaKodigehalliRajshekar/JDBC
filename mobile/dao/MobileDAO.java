package com.xworkz.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.xworkz.mobile.dto.MobileDetailsDTO;

public class MobileDAO {
	
	public boolean save(MobileDetailsDTO dto) {
		String insert = "insert into mobile_details  value ( '" +dto.getName() +" ' ," +dto.getPrice() +", '"+
		dto.getColor() +"'  ,"+ dto.getNoOfCamera()+","+dto.getStorage() +")";
		
		Connection connect =null;
		Statement  state =null;
		
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details", "root", "Arun@6134");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			state=connect.createStatement(); 
			
			state.execute(insert);
			System.out.println("data inswrted succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// internationalisation    check the meaning 
		return false;
	}
	
	public void updatePriceByName() {
		Connection connection =null;
		Statement statement =null;
		
		try {
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details", "root", "Arun@6134");
		           connection.setAutoCommit(false);
			 
			statement=connection.createStatement();
			statement.executeUpdate("update mobile_details set storage=64 where  name ='realme8 '");
			statement.executeUpdate("update mobile_details set storage=648956312345 where  name ='vivoz1  '");
			System.out.println("data updated succesfully");
			
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				  if(connection!=null)
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				if(statement!=null)
				statement.close();
				
				 if(connection!=null)
					  connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByName() {
		Connection connection =null;
		Statement statement =null;
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details", "root", "Arun@6134");
		  
			connection.setAutoCommit(false);
			
			statement=connection.createStatement();
			statement.execute("delete from mobile_details where name = 'redmi6 ' ");
			System.out.println("deleted succesfully");
			
			connection.commit();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				statement.close();
				
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
//	public void getMobileBrandAndPriceByTD() {
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details","root", "Arun@6134");
//			Statement statement =connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select price , color from mobile_details  where name ='poco '");
//		
//		  while(resultSet.next()) {
//			  System.out.println( resultSet.getInt("price"));
//			  System.out.println( resultSet.getString("color"));
//			  
//		  }
//			  //System.out.println("no data found");
//		  
//		
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	public void getMobileBrandAndPriceByTD(String name) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details","root", "Arun@6134");
			PreparedStatement statement =connection.prepareStatement("select price , color from mobile_details  where name =?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			
		
		  while(resultSet.next()) {
			  System.out.println( resultSet.getInt("price"));
			  System.out.println( resultSet.getString("color"));
			  
		  }
			  //System.out.println("no data found");
		  
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getCameraAndStorageByName(String name) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details","root", "Arun@6134");
			PreparedStatement statement =connection.prepareStatement("select noOfCamera ,storage from mobile_details where name =?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("storage"));
				System.out.println(resultSet.getInt("noOfCamera	"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertMobiles(List<MobileDetailsDTO> mobileList) {
		String query = "insert into mobile_details values(? ,?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_details","root", "Arun@6134");
		    statement =connection.prepareStatement(query);
		    for (int i = 0; i < mobileList.size(); i++) {
		    MobileDetailsDTO mobiledto = mobileList.get(i);
		    statement.setString(1, mobiledto.getName());
		    statement.setInt(2, mobiledto.getPrice());
		    statement.setString(3, mobiledto.getColor());
		    statement.setInt(4, mobiledto.getNoOfCamera());
		    statement.setInt(5,mobiledto.getStorage());
				statement.execute();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
				statement.close();
				
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

// store user name and password in properties file  
// execute executequery  executeupd
// apache-poi reading data from excel sheet and printiing on console