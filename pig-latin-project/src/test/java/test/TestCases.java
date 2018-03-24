/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.project.exceptions.CharacterException;
import com.project.service.Generator;

/**
 * @author JT8100897
 *
 */
public class TestCases {
	private static final Logger logger = LogManager.getLogger(TestCases.class);

	@Test
	public void textNotModified() {
		try {
			assertEquals("stairway", Generator.getResultWord("stairway"));
		} catch (CharacterException e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void textIsModified() {
		try {
			assertEquals("Ellohay", Generator.getResultWord("Hello"));
		} catch (CharacterException e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void punctuationMustRemain() {
		try {
			assertEquals("antca’y", Generator.getResultWord("can’t"));
			assertEquals("endway.", Generator.getResultWord("end."));
		} catch (CharacterException e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void capitalizationMustRemain() {
		try {
			assertEquals("Eachbay", Generator.getResultWord("Beach"));
			assertEquals("CcLoudmay", Generator.getResultWord("McCloud"));
		} catch (CharacterException e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void hyphens() {
		try {
			assertEquals("histay-hingtay", Generator.getResultWord("this-thing"));
		} catch (CharacterException e) {
			logger.error(e.getMessage());
		}
	}

}
