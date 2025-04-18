package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.domains.Province;
import jakarta.persistence.EntityManager;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.getTransaction().begin();

        for (int i = 0; i < 5; i++) {
            insertNewProvinceAndCities(entityManager, 3);
        }

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    private static void insertNewProvinceAndCities(EntityManager entityManager, int count) {
        Province province = getNewProvince();
        entityManager.persist(province);
        for (int i = 0; i < count; i++) {
            City city = getNewCity();
            city.setProvince(province);
            entityManager.persist(city);
        }
    }

    private static Province getNewProvince() {
        Province province = new Province();
        province.setName(faker.name().title());
        province.setPreCode(faker.number().digits(3));
        return province;
    }

    private static City getNewCity() {
        City city = new City();
        city.setName(faker.name().title());
        return city;
    }
}
