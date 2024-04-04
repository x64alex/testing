import junit.framework.Test;
        import junit.framework.TestCase;
        import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TEST3
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TEST3( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TEST3.class );
    }
    

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testAp2()
    {
        assertTrue( true );
    }

}
