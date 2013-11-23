package log121.lab4.app.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * User: maximebedard
 * Date: 11/19/2013
 * Time: 11:02 AM
 */
public class CommandeTranslationTest {

    private CommandeSauvegarderTest sauvegarderTest;

    @Before
    public void setUp() throws Exception {
        sauvegarderTest = new CommandeSauvegarderTest();
        sauvegarderTest.setUp();


    }

    @Test
    public void testExecuter() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testAnnuler() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testAnnulable() throws Exception {
        fail("Not yet implemented");
    }

    @After
    public void after()
    {
        sauvegarderTest.after();
    }
}
