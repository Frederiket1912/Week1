package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CustomerDTO getCustomerById(long id){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            BankCustomer bc = em.find(BankCustomer.class, id);
            return new CustomerDTO(bc);
        }finally{
            em.close();
        }
    }
    
    public List<CustomerDTO> getCustomersByName(String name){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery q = em.createQuery("select c from BankCustomer c where c.firstName = :name ", BankCustomer.class).setParameter("name", name);
            List<BankCustomer> bcs = q.getResultList();
            List<CustomerDTO> customers = new ArrayList<>();
            for (BankCustomer bc : bcs) {
                customers.add(new CustomerDTO(bc));
            }
            return customers;
        }finally{
            em.close();
        }
    }
    
    public BankCustomer addCustomer(BankCustomer cust){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        }finally{
            em.close();
        }
    }
    
    public List<BankCustomer> getAllBankCustomers(){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery q = em.createQuery("select c from BankCustomer c", BankCustomer.class);
            return q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public int deleteCustomer(String name){
        EntityManager em = emf.createEntityManager();
        try{
            Query q1 = em.createQuery("delete from BankCustomer c where c.firstName = :name").setParameter("name", name);
            em.getTransaction().begin();
            int deletedCount = q1.executeUpdate();
            em.getTransaction().commit();
            return deletedCount;
        }finally{
            em.close();
        }
    }
}
