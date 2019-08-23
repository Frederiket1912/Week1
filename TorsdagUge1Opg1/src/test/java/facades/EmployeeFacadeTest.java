/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
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
public class EmployeeFacadeTest {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EmployeeFacadeTest() {
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
     * Test of getEmployeeById method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeById() {
        System.out.println("getEmployeeById");
        long id = 1;
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        String expResult = "Jan";
        String result = ef.getEmployeeById(id).getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeesByName method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesByName() {
        System.out.println("getEmployeesByName");
        String name = "Jan";
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        int expResult = 1;
        int result = ef.getEmployeesByName(name).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        int expResult = 4;
        int result = ef.getAllEmployees().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeWithHighestSalary() {
        System.out.println("getEmployeeWithHighestSalary");
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        String expResult = "Kurt";
        String result = ef.getEmployeeWithHighestSalary().getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("createEmployee");
        String name = "Test";
        String address = "Test";
        int salary = 10;
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        String expResult = "Test";
        try{
        String result = ef.createEmployee(name, address, salary).getName();
        assertEquals(expResult, result);
        }finally{
            ef.deleteEmployee("Test");
        }
    }

    
}
