package intheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ORM {

  
    public static void main(String[] args) {
       FulltimeEmployee ep1 = new FulltimeEmployee(); 
       ParttimeEmployee ep2 = new ParttimeEmployee(); 
        
        EmployeeTable.insertEmployee(ep1);
        ep1.setName("Supachai");
        ep1.setSalary(50000);
        ep2.setName("Supa");
        ep2.setHoursWork(6);
        
        EmployeeTable.updateFullTimeEmployee(ep1);
        ep1.setName("Supachai");
        ep1.setSalary(50000);
        
        EmployeeTable.updatePartTimeEmployee(ep2);
        ep2.setName("Supachai5");
        ep2.setHoursWork(6);
        
    EmployeeTable.removeFullTimeEmployee(ep1); 
    EmployeeTable.removePartTimeEmployee(ep2); 
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("intheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
