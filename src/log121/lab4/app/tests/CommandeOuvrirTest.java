package log121.lab4.app.tests;

import log121.lab4.api.ICommande;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.fail;

/**
 * User: maximebedard
 * Date: 11/19/2013
 * Time: 11:02 AM
 */
public class CommandeOuvrirTest {

    ICommande commande;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testExecuter() throws Exception {

        fail("Not yet implemented");
    }

    @Test(expected = NotImplementedException.class)
    public void testAnnuler() throws Exception {

    }

    @Test(expected = NotImplementedException.class)
    public void testAnnulable() throws Exception {

    }

    @After
    public void after()
    {
    }
}
