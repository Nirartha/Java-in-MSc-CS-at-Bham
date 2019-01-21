import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  This file contains 15 JUnit tests for testing the estimateInBounds
 *  static method as defined in the Estimate.java class.
 *  The tests are written before the Estimate.java class is written, which 
 *  initially is only a stub and always returns false, that is, initially
 *  all the tests which start with assertTrue will fail.
 *
 *  Note that the class does not contain a main method, that is, after
 *  compilation (by javac) you CANNOT run it by invoking "java EstimateTest",
 *  but you have to run it by 
 *  "java org.junit.runner.JUnitCore EstimateTest".
 *
 *  @author Manfred Kerber
 *  @version 2015-10-15
 */

public class EstimateTest {
    @Test public void estimateTest1() {
       	assertTrue(Estimate.estimateInBounds(10.3, 11.0));     // yes
    }
    @Test public void estimateTest2() {
	assertFalse(Estimate.estimateInBounds(10.0,11.0));        // no
    }
    @Test public void estimateTest3() {
        assertTrue(Estimate.estimateInBounds(55.5, 60.0));     // yes
    }
    @Test public void estimateTest4() {
        assertFalse(Estimate.estimateInBounds(55.0, 60.0));     // no
    }
    @Test public void estimateTest5() {
        assertTrue(Estimate.estimateInBounds(109.0, 110.0));     // yes
    }
    @Test public void estimateTest6() {
        assertFalse(Estimate.estimateInBounds(100.0, 110.0));   // no
    }
    @Test public void estimateTest7() {
        assertTrue(Estimate.estimateInBounds(210.0, 219.0));   // yes
    }
    @Test public void estimateTest8() {
        assertFalse(Estimate.estimateInBounds(210.0, 220.0));   // no
    }
    @Test public void estimateTest9() {
        assertTrue(Estimate.estimateInBounds(310.0, 319.0));   // yes
    }
    @Test public void estimateTest10(){
        assertFalse(Estimate.estimateInBounds(310.0, 320.0));   // no
    }
    @Test public void estimateTest11(){
        assertTrue(Estimate.estimateInBounds(510.0, 325.0));   // yes
    }
    @Test public void estimateTest12(){
        assertFalse(Estimate.estimateInBounds(510.0, 530.0));   // no
    }
    @Test public void estimateTest13() {
        assertTrue(Estimate.estimateInBounds(1000.0, 1001.0)); // yes
    }
    @Test public void estimateTest14() {
        assertFalse(Estimate.estimateInBounds(1000.0, 1016.0)); // no
    }
    @Test public void estimateTest15() {
        assertTrue(Estimate.estimateInBounds(100000.0, 100000.0)); // not in range
    }
}
