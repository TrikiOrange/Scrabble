package com.nexeo.scrabble.exception;

import java.util.ArrayList;
import java.util.List;

import com.nexeo.scrabble.message.ReportLine;

public class ScrabbleException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ReportLine> reportLines = new ArrayList<ReportLine>();
	private boolean hasErrors = false;
	
	
	public ScrabbleException() {}
	
	public void addReportLine(ReportLine reportLine) {
		if(reportLine.getLevel().equals(ReportLine.ERROR_LEVEL) )
			hasErrors = true;
		reportLines.add(reportLine);
	}
	
	public List<ReportLine> getReportLines() {
		return reportLines;
	}

	public boolean hasReportLines() {
		return reportLines.size() != 0;
	}
	
	public boolean hasErrors() {
		return hasErrors;

	}
}