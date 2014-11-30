
package moh.mohart;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Test;

public class AppFormatNumberTest {

	@Test
	public void testFormatNumer() {
		//fail("Not yet implemented");
		//System.out.println("here here");
		App ap = new App();
		
		String ss = ap.formatNumer(13456);
		
		String s = ap.formatNumer(134);
		assertEquals(new String("1 100s 3 10s 4 1s"),  s);
	
		assertEquals("1 10000s 3 1000s 4 100s 5 10s 6 1s",  ap.formatNumer(13456));
		
		//assertEquals("134",  ap.formatNumer(134));
		//assertEquals("134",  ap.formatNumer(134));
		
		
		
		//assertEquals(135, "1 100s 3 10s 5 1s");
		//assertEquals(135, "1 100s 3 10s 4 1s");
		
		
		//134 --> 1 100s 3 10s 4 1s 
		
	}
	
	/*
	public static Matcher matches(final Object expected) {

	    return new BaseMatcher() {

	        protected String theExpected = expected;

	        public boolean matches(String o) {
	            return theExpected.equals(o);
	        }

	        public void describeTo(Description description) {
	            description.appendText(theExpected.toString());
	        }
	    };
	}
	*/
	

}
