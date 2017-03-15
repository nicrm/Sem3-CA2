package facade;

import entities.Person;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LoD
 */
public class PersonFacadeTest
{
    
    public PersonFacadeTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetPerson()
    {
        System.out.println("getPerson");
        int ID = 0;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.getPerson(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    @Test
//    public void testAddPerson()
//    {
//        System.out.println("addPerson");
//        Person person = null;
//        PersonFacade instance = null;
//        Person expResult = null;
//        Person result = instance.addPerson(person);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetPersons()
//    {
//        System.out.println("getPersons");
//        PersonFacade instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetPersonFromZipcode()
//    {
//        System.out.println("getPersonFromZipcode");
//        int zipcode = 0;
//        PersonFacade instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersonFromZipcode(zipcode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testDeletePerson()
//    {
//        System.out.println("deletePerson");
//        long id = 0L;
//        PersonFacade instance = null;
//        boolean expResult = false;
//        boolean result = instance.deletePerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testEditPerson()
//    {
//        System.out.println("editPerson");
//        Person person = null;
//        long id = 0L;
//        PersonFacade instance = null;
//        Person expResult = null;
//        Person result = instance.editPerson(person, id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
