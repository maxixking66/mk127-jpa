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
//        tag.setId(1L);
        tag.setName("my-tag2");
        tag.setIsActive(true);
        entityManager.persist(tag);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
