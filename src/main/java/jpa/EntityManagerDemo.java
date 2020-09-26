package jpa;

import entity.Demo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EntityManagerDemo {
    public static void main(String[] args) {
        EntityManager em = MyPersistence.JAVA5.getEntityManager();
        Demo demo = em.find(Demo.class, 1);
        System.out.println(demo);

        Demo newDemo = new Demo();
        newDemo.setName("TESTOWY");
        newDemo.setPoints(300);
        em.getTransaction().begin();
        em.persist(newDemo);
        em.getTransaction().commit();

        Query query = em.createQuery(
                "select d.name from Demo d where d.name = :qname and d.points = :qpoints",
                Demo.class
        );
        query.setParameter("qname", "TESTOWY");
        query.setParameter("qpoints", 300);
        List<Demo> resultList = query.getResultList();
        for (Demo d : resultList
        ) {
            System.out.println(d);
        }

        em.getTransaction().begin();
        em.remove(demo);
        em.getTransaction().commit();
        demo = em.find(Demo.class, 1);
        System.out.println(demo);
        em.close();

    }
}
