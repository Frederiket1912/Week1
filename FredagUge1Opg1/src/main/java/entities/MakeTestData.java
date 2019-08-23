/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author frede
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BankCustomer c1 = new BankCustomer("Anders", "Andersen", "1", 1, 1, "Ikke så god");
        BankCustomer c2 = new BankCustomer("Bjarne", "Bjarnesen", "2", 2, 2, "kunne være bedre");
        BankCustomer c3 = new BankCustomer("Anton", "Antonsen", "3", 3, 3, "nogenlunde");
        BankCustomer c4 = new BankCustomer("Mikkel", "Mikkelsen", "4", 4, 4, "fin fyr");
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.getTransaction().commit();          
        } finally {
            em.close();
        }
    }
}
