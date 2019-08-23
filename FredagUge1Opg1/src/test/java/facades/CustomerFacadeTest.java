/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class CustomerFacadeTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    public CustomerFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of getCustomerById method, of class CustomerFacade.
     */
    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        long id = 1;
        CustomerFacade instance = CustomerFacade.getCustomerFacade(emf);
        String expResult = "Bjarne Bjarnesen";
        String result = instance.getCustomerById(id).getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomersByName method, of class CustomerFacade.
     */
    @Test
    public void testGetCustomersByName() {
        System.out.println("getCustomersByName");
        String name = "Anders";
        CustomerFacade instance = CustomerFacade.getCustomerFacade(emf);
        int expResult = 1;
        int result = instance.getCustomersByName(name).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        BankCustomer cust = new BankCustomer("Test", "Test", "Test", 0, 0, "Test");
        CustomerFacade instance = CustomerFacade.getCustomerFacade(emf);
        String expResult = "Test";
        String result = instance.addCustomer(cust).getFirstName();
        instance.deleteCustomer("Test");
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllBankCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetAllBankCustomers() {
        System.out.println("getAllBankCustomers");
        CustomerFacade instance = CustomerFacade.getCustomerFacade(emf);
        int expResult = 4;
        int result = instance.getAllBankCustomers().size();
        assertEquals(expResult, result);
    }
    
}
