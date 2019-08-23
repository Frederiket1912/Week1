package facades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Employee;
import java.util.Collections;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Employee getEmployeeById(long id){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            return em.find(Employee.class, id);
        }finally{
            em.close();
        }
    }
    
    public List<Employee> getEmployeesByName(String name){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery q = em.createQuery("select e from Employee e where e.name = :name ", Employee.class).setParameter("name", name);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<Employee> getAllEmployees(){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery q = em.createQuery("select e from Employee e", Employee.class);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public Employee getEmployeeWithHighestSalary(){
        List<Employee> employees = getAllEmployees();
        Collections.sort(employees);
        Employee e = employees.get(0);
        return e;
    }
    
    public Employee createEmployee(String name, String address, int salary){
        Employee e = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return e;
        }finally{
            em.close();
        }
    }
    
    public int deleteEmployee(String name){
        EntityManager em = emf.createEntityManager();
        try{
            Query q1 = em.createQuery("delete from Employee e where e.name = :name").setParameter("name", name);
            em.getTransaction().begin();
            int deletedCount = q1.executeUpdate();
            em.getTransaction().commit();
            return deletedCount;
        }finally{
            em.close();
        }
    }
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        //Employee e = ef.getEmployeeById(1);
        List<Employee> employees = ef.getAllEmployees();
        System.out.println(employees.size());
    }

}
