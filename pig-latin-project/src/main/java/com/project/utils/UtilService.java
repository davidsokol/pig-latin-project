package com.project.utils;

import com.project.codebooks.Codebook;
import com.project.exceptions.CharacterException;

public class UtilService {

	public boolean isVowel(char c) throws CharacterException {
		if (Character.isLetter(c)) {
			return Codebook.VOWEL.contains(c);
		}
		throw new CharacterException();
	}

	public boolean isConsonants(char c) throws CharacterException {
		if (Character.isLetter(c)) {
			return Codebook.CONSONANTS.contains(c);
		}
		throw new CharacterException();
	}
}
