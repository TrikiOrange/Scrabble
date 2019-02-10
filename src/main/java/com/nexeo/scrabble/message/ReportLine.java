package com.nexeo.scrabble.message;

public class ReportLine {
	
	public static final String ERROR_LEVEL 	 = "ERROR";
	public static final String WARNING_LEVEL = "WARNING";
	public static final String INFO_LEVEL 	 = "INFO";
	
	
	private String level; 
	
	private String code; 
	
	private String message;
	
	public ReportLine(){}
	
	public ReportLine(String level, String code ,String message){
		this.level = level ;
		this.code = code ;
		this.message = message ;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
}
