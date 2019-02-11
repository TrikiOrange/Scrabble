package com.nexeo.scrabble.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

	public static List<String> readPlayedWords(String filePath) {

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
		} catch (IOException ie) {
			LogUtils.error("Problems when opening the file ", ie);
		}
		return playedWords;
	}
	
	public static List<String> readDictionnary(String filePath) {

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

		} catch (IOException ie) {
			LogUtils.error("Problems when opening the file ", ie);
		}
		return dictionaryWords;
	}

}
