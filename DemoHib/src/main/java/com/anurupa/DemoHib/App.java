package com.anurupa.DemoHib;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	AlienName an = new AlienName();
//    	an.setFname("Anurupa");
//    	an.setLname("Paul");
//    	
    	
       Alien anu = null;
       
       
//         anu.setAid(101);
//         anu.setColor("Green");
//         anu.setAname("Anurupa");        
       
     
       Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf = con.buildSessionFactory(reg);
       Session session1 = sf.openSession();
       
       session1.beginTransaction();
       
       Query q1= session1.createQuery("from Alien where aid=101");
       q1.setCacheable(true);
       
      anu = (Alien)q1.uniqueResult();
      System.out.println(anu);
      session1.getTransaction().commit();
      session1.close();
      
      Session session2 = sf.openSession();
      session2.beginTransaction();
      
      
      Query q2= session2.createQuery("from Alien where aid=101");
      q2.setCacheable(true);
      anu = (Alien)q2.uniqueResult();
      System.out.println(anu);
      session2.close();
      
      //session.save(anu);
      //tx.commit();
      
      
      //System.out.println(anu);
    }
}
