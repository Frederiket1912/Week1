/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author frede
 */
public class CustomerFacadeTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    private static CustomerFacade instance;

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public CustomerFacadeTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindByID() {
        System.out.println("findByID");
        int id = 1;
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        String expResult = "Hans";
        String result = cf.findByID(id).getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String lastName = "Mogensen";
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        int expResult = 4;
        int result = cf.findByLastName(lastName).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        int expResult = 7;
        int result = cf.getNumberOfCustomers();
        assertEquals(expResult, result);
    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        int expResult = 7;
        int result = cf.allCustomers().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String firstName = "Palle";
        String lastName = "Pallesen";
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        int numberOfCustomersBeforeCreation = cf.getNumberOfCustomers();
        cf.addCustomer(firstName, lastName);
        int numberOfCustomersAfterCreation = cf.getNumberOfCustomers();
        assertNotEquals(numberOfCustomersBeforeCreation, numberOfCustomersAfterCreation);
        cf.deleteCustomer(firstName, lastName);
    }

}
