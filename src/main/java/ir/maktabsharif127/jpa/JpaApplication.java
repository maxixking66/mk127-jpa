package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.Tag;
import jakarta.persistence.EntityManager;

public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.getTransaction().begin();

        Tag tag = new Tag();
        tag.setName("first");
        tag.setIsActive(true);

        entityManager.persist(tag); /*managed*/

        tag.setName("second");
//        entityManager.persist(tag);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
