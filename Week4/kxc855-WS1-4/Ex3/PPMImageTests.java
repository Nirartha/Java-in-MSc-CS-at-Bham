import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PPMImageTests {
    private PPMImage test1, test2, test3;

    @Before
    public void setUp() {
        test1 = new PPMImage("kxc855Test.ppm");
        test2 = new PPMImage("kxc855Test1.ppm");
        test3 = new PPMImage("kxc855Test2.ppm");
    }

	/*
	 * Testing the basic function - make grey
	 * The image 4*4 MaxShade=255
	 */
    @Test
    public void BasicFunction() {

        short[][] expected = { { 40, 70, 30, 170 },
                               { 63, 143, 0, 20 },
                               { 0, 33, 63, 0 },
                               { 170, 0, 143, 255 } };


        short[][] actual = test1.makeGrey("kxc855Test.pgm");
        assertArrayEquals(expected, actual);
    }

    /*
	 * Testing the basic function - make grey, comparing the expected file
	 * The image 4*4 MaxShade=255
	 */
    @Test
    public void BasicFunctionA() {
        test1.makeGrey("kxc855Test.pgm");
        PGMImage expected = new PGMImage("kxc855Test-expected.pgm") ;
        PGMImage actual =   new PGMImage("kxc855Test.pgm");
        assertTrue(actual.equals(expected));
    }

    /*
	 * Testing the basic function - make grey
	 * The image 4*4 MaxShade=170
	 */
    @Test
    public void MaxShade() {

    	short[][] expected = { { 10, 70, 30, 170 },
                			   { 63, 143, 0, 20 },
                			   { 0, 33, 63, 0 },
                			   { 170, 0, 143, 0 } };

        short[][] actual = test2.makeGrey("kxc855Test1.pgm");
        assertArrayEquals(expected, actual);
    }
    
    /*
	 * Testing the basic function - make grey, comparing the expected file
	 * The image 4*4 MaxShade=170
	 */
    @Test
    public void MaxShadeA() {
        test2.makeGrey("kxc855Test1.pgm");
        PGMImage expected = new PGMImage("kxc855Test-expected1.pgm") ;
        PGMImage actual =   new PGMImage("kxc855Test1.pgm");
        assertTrue(actual.equals(expected));
    }
    
    /*
	 * Testing the basic function - make grey
	 * The rectangle image 7*6 MaxShade=255
	 */
    @Test
    public void RectangleShade() {

        short[][] expected = { { 79, 33, 0, 140, 0, 7, 7 },
                               { 80, 143, 66, 44, 14, 13, 7 },
                               { 48, 5, 98, 51, 74, 17, 13 },
                               { 170, 7, 8, 188, 178, 170, 140 },
                               { 107, 75, 14, 140, 192, 133, 170 },
                               { 187, 106, 124, 111, 151, 216, 151 } };

        short[][] actual = test3.makeGrey("kxc855Test2.pgm");
        assertArrayEquals(expected, actual);
    }
    
    /*
	 * Testing the basic function - make grey
	 * The rectangle image 7*6 MaxShade=216
	 */
    @Test
    public void RectangleShadeA() {
    	test3.makeGrey("kxc855Test2.pgm");
        PGMImage expected = new PGMImage("kxc855Test-expected2.pgm") ;
        PGMImage actual =   new PGMImage("kxc855Test2.pgm");
        assertTrue(actual.equals(expected));
    }
}
