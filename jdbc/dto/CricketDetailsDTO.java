package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class CricketDetailsDTO implements Serializable {
	
	private byte noOfPlayers;
	private String teamName;
	private String captainName;
	private int matchesPlayed;
	
	
	public byte getNoOfPlayers() {
		return noOfPlayers;
	}
	public void setNoOfPlayers(byte noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	
	

}
