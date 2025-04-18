package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.Tag;
import jakarta.persistence.EntityManager;

public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.getTransaction().begin();

        Tag tag = entityManager.find(Tag.class, 2L);

        System.out.println("1)tag name:" + tag.getName());

        tag.setName(tag.getName() + " - " + tag.getName());
        System.out.println("2)tag name:" + tag.getName());
        entityManager.refresh(tag);
        System.out.println("3)tag name:" + tag.getName());

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
