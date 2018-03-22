/**
 * 
 */
package com.project;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.codebooks.Constants;
import com.project.exceptions.CharacterException;
import com.project.utils.UtilService;

/**
 * @author Dávid Sokol
 
 */
public class Generator {

	private static final Logger logger = LogManager.getLogger(Generator.class);

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter text: ");
		String inputWord = reader.nextLine();

		try {
			final String resultWord = getResultWord(inputWord);
			logger.info(resultWord);
		} catch (CharacterException e) {
			logger.error(e.getMessage());

		} catch (StringIndexOutOfBoundsException e) {
			logger.error(e.getMessage());

		} finally {
			reader.close();
		}

	}

	private static String getResultWord(String inputWord) throws CharacterException {
		String result = new String();
		final String[] array = inputWord.split(Constants.SEPARATOR);

		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				result += Constants.SEPARATOR;
			}
			result += proccessResultWord(array[i]);
		}
		return result;
	}

	private static String proccessResultWord(String inputWord) throws CharacterException {
		StringBuilder resultString = new StringBuilder();
		UtilService utilService = new UtilService();

		if (inputWord.endsWith(Constants.WAY_PERFIX)) {
			resultString.append(inputWord);
			return resultString.toString();
		}

		if (utilService.isConsonants(inputWord.toLowerCase().charAt(0))) {
			resultString.append(inputWord.substring(1, inputWord.length()).toLowerCase()).append(inputWord.substring(0, 1).toLowerCase())
					.append(Constants.CONSONANT_PERFIX);
		}

		if (utilService.isVowel(inputWord.toLowerCase().charAt(0))) {
			resultString.append(inputWord).append(Constants.VOWEL_PERFIX);
		}

		return capitalizationMustRemain(inputWord, resultString);

	}

	private static String capitalizationMustRemain(String inputWord, StringBuilder resultString) {

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

}
