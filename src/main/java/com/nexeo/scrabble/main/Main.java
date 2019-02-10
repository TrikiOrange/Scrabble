package com.nexeo.scrabble.main;

import com.nexeo.scrabble.config.ConfigurationConstants;
import com.nexeo.scrabble.handler.PlayScrabble;
import com.nexeo.scrabble.utils.LogUtils;

public class Main {

	public static void main(String[] args) {
		
		LogUtils.start();
		
		PlayScrabble playScrabble 	= new PlayScrabble();
		
		if (args.length < 2) {
			String dictionaryPath 	= "/var/work/dictionary.txt";
			String wordsPalyedPath 	= "/var/work/playedwords.txt";
			
			playScrabble.loadGame(dictionaryPath, wordsPalyedPath);
		} else 
			playScrabble.loadGame(args[0], args[1]);

		ConfigurationConstants.distributePoints();
		playScrabble.startPlaying();
		
		LogUtils.end();

	}

}