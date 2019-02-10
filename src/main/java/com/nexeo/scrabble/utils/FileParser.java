package com.nexeo.scrabble.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nexeo.scrabble.exception.ScrabbleException;
import com.nexeo.scrabble.message.ReportLine;

public class FileParser {

	public static List<String> readPlayedWords(String filePath) throws ScrabbleException {

		ScrabbleException exception = new ScrabbleException();
		ReportLine reportLine = new ReportLine();
		List<String> playedWords = new ArrayList<String>();

		try {
			File file = new File(filePath);

			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {
				playedWords.add(st);
			}
			
			LogUtils.debug("Played Words file successfully parsed, (" + playedWords.size() + ") words found");
			br.close();

		} catch (FileNotFoundException fe) {
			LogUtils.error("The Played Words file was not found ", fe);
			reportLine.setMessage(fe.getMessage());
			exception.addReportLine(reportLine);
		} catch (IOException ie) {
			LogUtils.error("Problems when opening the file ", ie);
			reportLine.setMessage(ie.getMessage());
			exception.addReportLine(reportLine);
		}
		return playedWords;
	}
	
	public static List<String> readDictionnary(String filePath) throws ScrabbleException {

		ScrabbleException exception = new ScrabbleException();
		ReportLine reportLine = new ReportLine();
		List<String> dictionaryWords = new ArrayList<String>();

		try {
			File file = new File(filePath);

			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {
				dictionaryWords.add(st);
			}
			
			LogUtils.debug("Dictionary file successfully parsed, (" + dictionaryWords.size() + ") words found");
			br.close();

		} catch (FileNotFoundException fe) {
			LogUtils.error("The Dictionary file was not found ", fe);
			reportLine.setMessage(fe.getMessage());
			exception.addReportLine(reportLine);
		} catch (IOException ie) {
			LogUtils.error("Problems when opening the file ", ie);
			reportLine.setMessage(ie.getMessage());
			exception.addReportLine(reportLine);
		}
		return dictionaryWords;
	}

}
