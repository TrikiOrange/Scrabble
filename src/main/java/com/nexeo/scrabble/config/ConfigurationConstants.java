package com.nexeo.scrabble.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationConstants {
	
	public static String DICTIONARY_DIR 					= "com.nexeo.dictionary.dir";
	public static String PLAYED_WORDS_DIR 					= "com.nexeo.played.words.dir";
	
	public static final String EFF_URL 						= "com.epac.pre.om.effUrl";
	
	public static Map<String, Integer> distributionPoints	= new HashMap<>();
	
	public static void distributePoints() {
		
		distributionPoints.put("A", 1);
		distributionPoints.put("E", 1);
		distributionPoints.put("I", 1);
		distributionPoints.put("L", 1);
		distributionPoints.put("N", 1);
		distributionPoints.put("O", 1);
		distributionPoints.put("R", 1);
		distributionPoints.put("S", 1);
		distributionPoints.put("T", 1);
		distributionPoints.put("U", 1);
		distributionPoints.put("L", 1);
		
		distributionPoints.put("D", 2);
		distributionPoints.put("G", 2);
		
		distributionPoints.put("B", 3);
		distributionPoints.put("C", 3);
		distributionPoints.put("M", 3);
		distributionPoints.put("P", 3);
		
		distributionPoints.put("F", 4);
		distributionPoints.put("H", 4);
		distributionPoints.put("V", 4);
		distributionPoints.put("W", 4);
		distributionPoints.put("Y", 4);

		distributionPoints.put("K", 5);
		
		distributionPoints.put("J", 8);
		distributionPoints.put("X", 8);
		
		distributionPoints.put("Q", 10);
		distributionPoints.put("Z", 10);
		
	}
}