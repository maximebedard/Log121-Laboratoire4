package log121.lab4.app.tests;

import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import log121.lab4.app.CommandeSauvegarder;
import log121.lab4.app.ModeleImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

import static org.junit.Assert.*;

/**
 * User: maximebedard
 * Date: 11/19/2013
 * Time: 11:02 AM
 */
public class CommandeSauvegarderTest {

    private ICommande commande;

    public final static String TEST_FILE_NAME = "test.lab4";

    @Before
    public void setUp() throws Exception {
        commande = new CommandeSauvegarder(new ModeleImage(), TEST_FILE_NAME);
    }

    @Test
    public void testExecuter(){
        commande.executer();
        File testFile = new File(TEST_FILE_NAME);
        assertTrue(testFile.exists());

        try
        {
            Modele m = Modele.deserialiser(TEST_FILE_NAME);
            assertTrue(m instanceof ModeleImage);
        }
        catch (Exception ex)
        {
            fail(ex.getMessage());
        }

    }

    @Test(expected = NotImplementedException.class)
    public void testAnnuler() throws Exception {
        commande.annuler();
    }

    @Test
    public void testAnnulable() throws Exception {
        assertFalse(commande.annulable());
    }

    @After
    public void after() {
        File fileTest = new File(TEST_FILE_NAME);
        if(fileTest.exists())
            assertTrue(fileTest.delete());
    }
}
