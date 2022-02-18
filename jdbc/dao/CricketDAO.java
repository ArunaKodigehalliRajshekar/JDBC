package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.dto.CricketDetailsDTO;

public class CricketDAO {
	
	public boolean saveCricketDetails(CricketDetailsDTO dto) {
		
		String insertQuery ="insert into cricket_details  values(" +dto.getNoOfPlayers() +", '" +
		       dto.getTeamName() +"'  ,  '" +dto.getCaptainName() +"'  ," +
				dto.getMatchesPlayed() +")" ;
		// step1
		
		Connection con = null;
		Statement stat = null;
		
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "Arun@6134");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stat=con.createStatement();
			
			 stat.execute(insertQuery);
			 //stat.execute("insert into cricket_details values (15 ,'kx1p','rahul',105)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
