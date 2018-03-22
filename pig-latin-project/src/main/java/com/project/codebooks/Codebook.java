/**
 * 
 */
package com.project.codebooks;

/**
 * @author JT8100897
 *
 */
public enum Codebook {

	CONSONANTS("bcdfghjklmnpqrstvwxyz"), VOWEL("aeiou");

	private final String content;

	private Codebook(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public boolean contains(char c) {
		return getContent().indexOf(c) >= 0 ? true : false;
	}

}
