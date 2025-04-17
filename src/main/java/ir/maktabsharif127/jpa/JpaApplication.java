package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JpaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

//        entityManager.getTransaction().begin();

//        Tag tag = new Tag();
//        tag.setId(1L);
//        tag.setName("my-tag1");
//        tag.setIsActive(true);
//        entityManager.merge(tag);

//        Tag tag = entityManager.find(Tag.class, 1L);
//        entityManager.remove(tag);

        TypedQuery<Tag> query = entityManager.createQuery(
//                "select t from Tag t where t.id = :id and t.isActive = :isActive",
                "from Tag t where t.id = :id and t.isActive = :isActive",
                Tag.class
        );
        query.setParameter("id", 2L);
        query.setParameter("isActive", true);

        System.out.println(query.getSingleResult());

//        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
