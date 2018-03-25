/**
 * 
 */
package com.project.service;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.codebooks.Constants;
import com.project.exceptions.CharacterException;
import com.project.exceptions.EmptyStringException;
import com.project.utils.UtilService;

/**
 * @author Dávid Sokol
 * Test
 * 
 */
public class Generator {

	private static final Logger logger = LogManager.getLogger(Generator.class);

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter text: ");
		String inputWord = reader.nextLine();

		try {
			final String resultWord = getResultWord(inputWord);
			logger.info("Original word: " + inputWord);
			logger.info("Modified word:" + resultWord);
			printReturnMessage(inputWord, resultWord);
		} catch (CharacterException e) {
			logger.error(e.getMessage());

		} catch (EmptyStringException e) {
			logger.error(e.getMessage());
		} finally {
			reader.close();
		}

	}

	public static String getResultWord(String inputWord) throws CharacterException {
		String result = new String();
		String separator = inputWord.contains(Constants.SEPARATOR)?Constants.SEPARATOR:Constants.SEPARATOR_SPACE;

		final String[] inputWords = inputWord.split(separator);
		for (int i = 0; i < inputWords.length; i++) {
			if (i > 0) {
				result += separator;
			}
			result += proccessResultWord(inputWords[i]);
		}
		return result;
	}

	private static String proccessResultWord(String inputWord) throws CharacterException {
		StringBuilder resultString = new StringBuilder();
		UtilService utilService = new UtilService();

		if (!inputWord.isEmpty()) {

			if (inputWord.endsWith(Constants.WAY_PREFIX)) {
				resultString.append(inputWord);
				return resultString.toString();
			}

			if (utilService.isConsonants(inputWord.toLowerCase().charAt(0))) {
				resultString.append(inputWord.substring(1, inputWord.length()).toLowerCase()).append(inputWord.substring(0, 1).toLowerCase())
						.append(Constants.CONSONANT_PREFIX);
			}

			if (utilService.isVowel(inputWord.toLowerCase().charAt(0))) {
				resultString.append(inputWord).append(Constants.VOWEL_PREFIX);
			}

			return capitalizationAndPunctuation(inputWord, resultString);

		}
		throw new EmptyStringException();

	}

	private static String capitalizationAndPunctuation(String inputWord, StringBuilder resultString) {

		for (int i = 0; i < inputWord.toCharArray().length; i++) {
			if (Character.isUpperCase(inputWord.charAt(i))) {
				resultString.setCharAt(i, Character.toUpperCase(resultString.charAt(i)));
			}
			if (!Character.isAlphabetic(inputWord.charAt(i))) {
				final int index = resultString.indexOf(String.valueOf(inputWord.charAt(i)));
				resultString.deleteCharAt(index);
				resultString.insert(i + index, inputWord.charAt(i));
			}
		}
		return resultString.toString();
	};
	
	private static void printReturnMessage(String inputWord, String resultWord) {
		System.out.println("Input word:" + inputWord + " was modified to:" + resultWord);
	}

}
