import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  This file contains 5 JUnit tests for demonstrating assertEquals,
 *  assertFalse, and asserTrue.
 *
 *  Note that the class does not contain a main method, that is, after
 *  compilation (by javac) you CANNOT run it by invoking "java JUnitExample",
 *  but you have to run it by 
 *  "java org.junit.runner.JUnitCore JUnitExample".
 *
 *  @author Manfred Kerber
 *  @version 2015-10-06
 */

public class JUnitExample {

    @Test
        public void assertEqualsTest1() {
        assertEquals("failure in assertEqualsTest1: " +
                     " expected string not equal given string", "text",
                     "te"+ "xt");
    }

    @Test
        public void assertEqualsTestInt() {
        assertEquals("failure in assertEqualsTestInt: " +
                     " expected 4 == 2 * 2", 4, 2 * 2);
    }

    @Test
        public void assertEqualsTestSqrt() {
        assertEquals("failure in assertEqualsSqrt: " +
                     " expected sqrt(5) * sqrt(5) ~= 5", 5, 
                     Math.sqrt(5) * Math.sqrt(5), 0.00001);
    }

    @Test
        public void assertEqualsTest2() {
        assertEquals("failure in assertEqualsTest2: " +
                     " expected string not equal given string", 2.0, 2.1, 0.11);
    }

    @Test
        public void assertFalseTest() {
        assertFalse("failure in assertFalseTest: " +
                    " expected false but got true", 3 == 4);
    }

    @Test
      public void assertTrueTest() {
        assertTrue("failure in assertTrueTest: " +
                   "expected true but got false", 2 < 5);
    }
}

