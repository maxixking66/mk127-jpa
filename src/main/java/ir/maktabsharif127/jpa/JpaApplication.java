package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.domains.Province;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<City> typedQuery = entityManager.createQuery("from City order by id desc", City.class);
//        order(sort) & page & size
//        offset = page * size
        typedQuery.setFirstResult(5);/*offset*/
        typedQuery.setMaxResults(5);/*size, limit*/

        System.out.println(typedQuery.getResultList().stream().map(City::getId).toList());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void insertNewProvinceAndCities(EntityManager entityManager, int count) {
        Province province = getNewProvince();
        for (int i = 0; i < count; i++) {
            City city = getNewCity();
            city.setProvince(province);
//            entityManager.persist(city);
            province.getCities().add(city);
        }
        entityManager.persist(province);
    }

    private static Province getNewProvince() {
        Province province = new Province();
        province.setName(faker.name().title());
        province.setPreCode(faker.number().digits(3));
        province.setCities(new HashSet<>());
        return province;
    }

    private static City getNewCity() {
        City city = new City();
        city.setName(faker.name().title());
        return city;
    }
}
