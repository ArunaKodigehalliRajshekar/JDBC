package com.xworkz.jdbc;

import com.xworkz.jdbc.dao.CricketDAO;
import com.xworkz.jdbc.dto.CricketDetailsDTO;

public class TesterCricketDetails {
	
	public static void main(String[] args) {
		
		CricketDetailsDTO cricketDetailsDTO = new CricketDetailsDTO();
		cricketDetailsDTO.setNoOfPlayers((byte)15);
		cricketDetailsDTO.setTeamName("DCD");
		cricketDetailsDTO.setCaptainName("shreyas");
		cricketDetailsDTO.setMatchesPlayed(205);
		
		CricketDetailsDTO cricketDetailsDTO2 =  new CricketDetailsDTO();
		cricketDetailsDTO2.setNoOfPlayers((byte)15);
		cricketDetailsDTO2.setCaptainName("warner");
		cricketDetailsDTO2.setTeamName("DDR");
		cricketDetailsDTO2.setMatchesPlayed(210);
		
		CricketDAO cricketDAO = new  CricketDAO();
		cricketDAO.saveCricketDetails(cricketDetailsDTO);
		cricketDAO.saveCricketDetails(cricketDetailsDTO2);
	}

}
