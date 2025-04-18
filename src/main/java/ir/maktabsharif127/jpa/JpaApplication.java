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
        tag.setName("new with merge 2");
        tag.setIsActive(true);

        System.out.println("before merge: " + entityManager.contains(tag));

        Tag merge = entityManager.merge(tag);/*managed*/
//        tag = entityManager.merge(tag);/*managed*/

        System.out.println("after merge: " + entityManager.contains(tag));
        System.out.println("after merge and return type of merge method: " + entityManager.contains(merge));
        merge.setName("merge return type");
//        entityManager.persist(tag);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
