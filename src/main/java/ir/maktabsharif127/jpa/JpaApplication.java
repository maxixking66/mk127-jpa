package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.domains.User;
import ir.maktabsharif127.jpa.domains.enumerations.UserType;
import jakarta.persistence.EntityManager;

import java.util.HashSet;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        entityManager.getTransaction().begin();

//        User user = new User();
//        user.setFirstName("mat");
//        user.setLastName("mat");
//        user.setUsername("mat");
//        user.setPassword("mat");
//        user.setUserType(UserType.REAL);
//        entityManager.persist(user);

        entityManager.find(User.class, 1L).setUserType(UserType.NEW_ONE);

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
