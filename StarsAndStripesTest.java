import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * The test class StarsAndStripesTest.
 *
 * @author  Dave Avis
 * @version 9.4.2018
 */
public class StarsAndStripesTest
{
    private OutputStream os;
    private PrintStream origOut;
    private InputStream origIn;
    private String ls;

    /**
     * Default constructor for test class StarsAndStripesTest.
     */
    public StarsAndStripesTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //Prepare to redirect output
        origIn = System.in;
        origOut = System.out;

        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        ls = System.getProperty("line.separator");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        System.setOut(origOut);
        System.setIn(origIn);
    }

    /**
     * Tests printTwentyStars().
     */
    @Test
    public void printTwentyStarsTest()
    {
        StarsAndStripes.printTwentyStars();
        String output = os.toString().trim();
        String expected = "********************";
        assertEquals("Printing 20 stars: ", expected, output);
    }

    /**
     * Tests printTwentyDashes().
     */
    @Test
    public void printTwentyDashesTest()
    {
        StarsAndStripes.printTwentyDashes();
        String output = os.toString().trim();
        String expected = "--------------------";
        assertEquals("Printing 20 dashes: ", expected, output);
    }

    /**
     * Tests printTwoBlankLines().
     */
    @Test
    public void printTwoBlankLinesTest()
    {
        StarsAndStripes.printTwoBlankLines();
        String output = os.toString();
        String expected = ls + ls;
        assertEquals("Printing 2 blank lines: ", expected, output);
    }

    /**
     * Tests printASmallBox().
     */
    @Test
    public void printASmallBoxTest()
    {
        StarsAndStripes.printASmallBox();
        String output = os.toString();
        if( output.length() == 0 )
        {
            fail("No output.");
        }
        boolean startsWithDash = false;
        if( output.charAt(0) == '-' )
        {
            startsWithDash = true;
        }
        boolean secondLineStars = false;
        String eol;
        if( output.indexOf( ls ) == -1 )
        {
            eol = "\n";
        } else {
            eol = ls;
        }
        if( output.charAt( output.indexOf( eol ) + eol.length() ) == '*' )
        {
            secondLineStars = true;
        }
        assertTrue("First line should be dashes: ", startsWithDash);
        assertTrue("Second line should be stars: ", secondLineStars);
        assertEquals("Output should be 20x6: ", (20*6)+(6*eol.length()), output.length() );
    }

    /**
     * Tests printABigBox().
     */
    @Test
    public void printABigBoxTest()
    {
        StarsAndStripes.printABigBox();
        String output = os.toString();
        if( output.length() == 0 )
        {
            fail("No ouput.");
        }
        boolean startsWithDash = false;
        if( output.charAt(0) == '-' )
        {
            startsWithDash = true;
        }
        boolean secondLineStars = false;
        String eol;
        if( output.indexOf( ls ) == -1 )
        {
            eol = "\n";
        } else {
            eol = ls;
        }
        if( output.charAt( output.indexOf( eol ) + eol.length() ) == '*' )
        {
            secondLineStars = true;
        }
        assertTrue("First line should be dashes: ", startsWithDash);
        assertTrue("Second line should be stars: ", secondLineStars);
        assertEquals("Output should be 20x12: ", (20*12)+(12*eol.length()), output.length() );
    }
}
