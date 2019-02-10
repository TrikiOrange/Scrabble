package com.nexeo.scrabble.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nexeo.scrabble.config.ConfigurationConstants;
import com.nexeo.scrabble.exception.ScrabbleException;
import com.nexeo.scrabble.utils.FileParser;
import com.nexeo.scrabble.utils.LogUtils;

@Service
public class PlayScrabble extends AbstractHandler {

	static List<String> dictionary;
	static List<String> playedWords;
	Map<String, Integer> scores = new HashMap<>();
	Map<Integer, Integer> histogram = new HashMap<>();
	List<Integer> scoresList = new ArrayList<>();
	String max;

	public void loadGame(String dict, String word) {
		LogUtils.debug("Uploading the data to play Scrabble");

		try {
			dictionary = FileParser.readDictionnary(dict);
			playedWords = FileParser.readPlayedWords(word);

		} catch (ScrabbleException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public int calculateHello() {

		LogUtils.info("<<<<<<<<<<<<<<< Exercise Number 1 : Hello Word >>>>>>>>>>>>>>>");

		int helloScore = calculateWordScore("Hello");

		LogUtils.info("Hello => has score " + helloScore);

		LogUtils.info("<<<<<<<<<<<<<<<<<<<<<<<< Hello Word >>>>>>>>>>>>>>>>>>>>>>>>");

		return helloScore;

	}

	public int calculateWordScore(String word) {
		int score = 0;

		if (!isWordForbidden(word)) {
			for (int i = 0; i < word.length(); i++) {
				String currentChar = word.substring(i, i + 1).toUpperCase();
				score = score + ConfigurationConstants.distributionPoints.get(currentChar);
			}
		}

		return score;
	}

	public Map<Integer, Integer> buildHistogram() {

		LogUtils.info("<<<<<<<<<<<<<<<<< Exercise Number 3 : Histogram >>>>>>>>>>>>>>>>>");
		
		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			int value = entry.getValue();

			// Filling up the histogram
			if (histogram.isEmpty() || !histogram.containsKey(value)) {
				histogram.put(value, 1);
				scoresList.add(value);
			} else {
				int newScore = histogram.get(value) + 1;
				histogram.replace(value, histogram.get(value), newScore);
			}
		}

		if (!histogram.isEmpty()) {
			for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
				int score = entry.getKey();
				int value = entry.getValue();

				LogUtils.info("For score " + score + " we have " + value + " word" + (value > 1 ? "s" : ""));
			}
			LogUtils.info("Histogram size is " + histogram.size());
		}

		LogUtils.info("<<<<<<<<<<<<<<<<< Histogram >>>>>>>>>>>>>>>>>");
		
		return histogram;

	}

	public boolean isWordForbidden(String word) {

		boolean isForbidden = false;

		if (dictionary.contains(word)) {
			isForbidden = true;
		}

		return isForbidden;

	}

	public void startPlaying() {

		calculateHello();
		calculatePlayingWords();
		getBestScoreWord();
		buildHistogram();
		getPalmares();
	}

	public void calculatePlayingWords() {

		playedWords.stream().forEach(word -> {
			int score = calculateWordScore(word);
			scores.put(word, score);
		});

	}

	public String getBestScoreWord() {

		LogUtils.info("<<<<<<<<<<<<<<<<< Exercise Number 2 : Best score word >>>>>>>>>>>>>>>>>");

		String bestWord = "";
		int bestScore = 0;
		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			String word = entry.getKey();
			int value = entry.getValue();

			// Getting the word with the best Score
			if (value >= bestScore) {
				bestWord = word;
				bestScore = value;
			}
		}
		
		String message = "Best word is '" + bestWord + "' with score " + bestScore;

		LogUtils.info(message);

		LogUtils.info("<<<<<<<<<<<<<<<<<<< Best Word >>>>>>>>>>>>>>>>>>>");

		return bestWord;
	}

	public void getPalmares() {

		LogUtils.info("<<<<<<<<<<<<<<<< Exercise Number 4 : Best 3 scores >>>>>>>>>>>>>>>>");

		List<String> bestScoreWords = new ArrayList<>();
		List<String> secondBestScoreWords = new ArrayList<>();
		List<String> thirdBestScoreWords = new ArrayList<>();

		Collections.sort(scoresList);
		scores.forEach((word, score) -> {
			if (score == scoresList.get(scoresList.size() - 1)) {
				bestScoreWords.add(word);
			} else if (score == scoresList.get(scoresList.size() - 2)) {
				secondBestScoreWords.add(word);
			} else if (score == scoresList.get(scoresList.size() - 3)) {
				thirdBestScoreWords.add(word);
			}
		});

		logPalmares(bestScoreWords);
		logPalmares(secondBestScoreWords);
		logPalmares(thirdBestScoreWords);

		LogUtils.info("<<<<<<<<<<<<<<<<<<<<<<< Palmares >>>>>>>>>>>>>>>>>>>>>>>");
	}

	public void logPalmares(List<String> list) {
		if (!list.isEmpty()) {

			String message = "'" + list.get(0) + "'";
			for (int i = 1; i < list.size(); i++) {
				message = message + ", '" + list.get(i) + "'";
			}
			LogUtils.info(scoresList.get(scoresList.size() - 3) + " : " + message);
		}
	}
}
