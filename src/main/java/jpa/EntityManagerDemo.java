package jpa;

import entity.Demo;

import javax.persistence.EntityManager;

public class EntityManagerDemo {
    public static void main(String[] args) {
        EntityManager em = MyPersistence.JAVA5.getEntityManager();
        Demo demo = em.find(Demo.class, 1);
        System.out.println(demo);
        em.close();
    }
}
