package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import jakarta.persistence.EntityManager;

public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.close();
    }
}
