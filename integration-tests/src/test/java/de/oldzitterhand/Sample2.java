package de.oldzitterhand;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * This an integration test class.
 * Please note the 'Category' annotation with the group interface.
 *
 * @author Patrick Metz
 */
@Category(IntegrationTest.class)
public class Sample2 {

	@Test	
	public void testSample1() {
		System.err.println("##### testSample2");
	}
}