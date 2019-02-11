package com.nexeo.scrabble.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.nexeo.scrabble.config.ConfigurationConstants;

public class PlayScrabbleTest {

	List<String> dictionary = new ArrayList<>();
	List<String> playedWords = new ArrayList<>();
	PlayScrabble playScrabble;
	File file;

	@Before
	public void createMockito() throws Exception {
		// Initialize playedWords
		File playedWordsFile = createFile("playedWords");

		// Initialize Dictionary
		File dictionary = createFile("dictionary");

		// Initialize PlayScrabble
		playScrabble = new PlayScrabble();
		playScrabble.loadGame(dictionary.getAbsolutePath(), playedWordsFile.getAbsolutePath());
		ConfigurationConstants.distributePoints();
		playScrabble.calculatePlayingWords();
	}

	@Test
	public void calculateHelloTest() {

		assertTrue(playScrabble.calculateHello() == 8);

	}

	@Test
	public void calculateWordScoreTestOk() {

		String word = "splinter";
		assertTrue(playScrabble.calculateWordScore(word) == 0);

	}

	@Test
	public void calculateWordScoreTestKo() {

		String word = "wheezing";
		assertFalse(playScrabble.calculateWordScore(word) == 0);

	}

	@Test
	public void isWordForbiddenTest() {

		String forbiddenWord = "splinter";
		assertTrue(playScrabble.isWordForbidden(forbiddenWord));

	}

	@Test
	public void getBestScoreWord() {

		String word = "wheezing";
		String best = playScrabble.getBestScoreWord();
		assertTrue(best.equals(word));

	}

	@Test
	public void buildHistogramTest() {

		Map<Integer, Integer> histogram = playScrabble.buildHistogram();

		assertTrue(!histogram.isEmpty());

		assertFalse(histogram.get(8) == 0);

		assertTrue(histogram.get(0) == 2);

	}

	private File createFile(String fileName) {

		File temp = null;
		try {

			// create a temp file
			temp = File.createTempFile(fileName, ".txt");

			// write it
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			if (!fileName.equals("dictionary")) {
				bw.write("wheezing\n"); // score 24
				bw.write("whitsters\n"); // score 15
				bw.write("splinter\n"); // score 0
				bw.write("hello\n"); // score 8
				bw.write("accounts"); // score 0
			} else {
				bw.write("accounts\n");
				bw.write("splinter");
			}

			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return temp;
	}

}
