/**
 * 
 */
package test;

import org.junit.Assert;
import org.junit.Test;

import com.project.codebooks.Codebook;

/**
 * @author JT8100897
 *
 */
public class TestHelloWorld {

	
	
	
	@Test
	public void testPrintHelloWorld1() {

		Assert.assertEquals(Codebook.VOWEL.contains('a'),true);

	}

}
