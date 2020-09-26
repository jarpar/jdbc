package jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum MyPersistence {
    JAVA5("java5");//public static MyPersistence JAVA5 = new MyPersistence();

    private final EntityManagerFactory factory;

    MyPersistence(String peristenceUnit) {
        this.factory = Persistence.createEntityManagerFactory(peristenceUnit);
    }
}
