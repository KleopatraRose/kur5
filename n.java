/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Kleopatra
 */
public class n {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("r_mavenproject2_war_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    public static void main(String args [])
    {
//        Films f= new Films(6, "brfb", "tbhber", 0, "rv", 0, "fdbv", 0, 0);
//        FilmsFacade a= new FilmsFacade();
//        f=a.find(1);
//        System.out.println(a.count());
        String s="ttt";
       //Films cust1 = new Films(2);
      Calendar c = new GregorianCalendar(2016, 04, 30,21, 0,0);//календарь на 25.11.2013
      Date d=new Date(c.getTimeInMillis());
     // Seans cust1 = new Seans(2, 1,d, d, 50000, "00100010", "00010100", "11101111", "01101101", "01011010", "00011101");

//     javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Seans.class));
//        List<Seans> models =  em.createQuery(cq).getResultList();
    int l=2;
//     Collection emps = em.createNativeQuery("SELECT * FROM films where id_f="+l).getResultList();
        Collection emps = em.createNativeQuery("SELECT * FROM films ORDER BY 'like' DESC LIMIT 3").getResultList();
              for(Iterator i=emps.iterator(); i.hasNext();){
         //Films f = (Films) i.next();
          Object[] obj = (Object[]) i.next();  
         Integer service = Integer.parseInt(String.valueOf(obj[0])); //SERVICE assumed as int
         String client = String.valueOf(obj[1]);
         
         System.out.println(service+"/"+client);
     }
     em.close();
     emf.close();
//        
//
//        // Print the name from the list....
//        for(Seans model : models) {
//            System.out.println(model.getIdS());
//        }

        
//        em.getTransaction().begin();
//        Seans cust1 = em.find(Seans.class, 1L);
//        em.persist(cust1);
//        em.getTransaction().commit();
    }

}
