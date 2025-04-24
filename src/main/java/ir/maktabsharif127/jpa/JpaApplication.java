package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.*;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        EntityManager entityManager = applicationContext.getEntityManager();

        TypedQuery<City> typedQuery = entityManager.createQuery("from City", City.class);

//        EntityGraph<?> entityGraph = entityManager.createEntityGraph("city-graph");
        EntityGraph<City> cityEntityGraph = entityManager.createEntityGraph(City.class);
        cityEntityGraph.addAttributeNodes(City_.PROVINCE);

        typedQuery.setHint(
                "jakarta.persistence.fetchgraph",
//                "jakarta.persistence.loadgraph",
                cityEntityGraph
        );

        List<City> resultList = typedQuery.getResultList();
        System.out.println("resultList is fetched");
        resultList.forEach(city -> System.out.println(city.getProvince().getName()));

        entityManager.close();
    }

    private static List<Customer> findAll(EntityManager entityManager, CustomerSearch search) {
//        select count(*) from Customer c -> cb.createQuery(Long.class)
//        select count(*) from Admin a -> cb.createQuery(Long.class)
//        select c.firstName from Customer c -> cb.createQuery(String.class) & query.from(Customer.class) & query.select(root.get("firstName"))
//        select c from Customer c -> cb.createQuery(Customer.class) & query.from(Customer.class) & query.select(root)
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
//        query.select(root);
        List<Predicate> predicates = new ArrayList<>();
        fillPredicates(predicates, root, cb, search);

        if (!predicates.isEmpty()) {
            query.where(
                    cb.and(
                            predicates.toArray(new Predicate[0])
                    )
            );
        }

        TypedQuery<Customer> typedQuery = entityManager.createQuery(query);
//        add firstResult/maxResult
        return typedQuery.getResultList();
    }

    private static void fillPredicates(List<Predicate> predicates, Root<Customer> root, CriteriaBuilder cb, CustomerSearch search) {
        addFirstNamePredicate(predicates, root, cb, search.getFirstName());
        addLastNamePredicate(predicates, root, cb, search.getLastName());
        addCodePredicate(predicates, root, cb, search.getCode());
    }

    private static void addFirstNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                              CriteriaBuilder cb, String firstName) {
//        c.firstName like '%m%'
//        "      " -> is blank & is not empty
        if (StringUtils.isNotBlank(firstName)) {
            predicates.add(
                    cb.like(
                            root.get(Customer_.firstName),
                            "%" + firstName + "%"
                    )
            );
        }
    }

    private static void addLastNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                             CriteriaBuilder cb, String lastName) {
        if (StringUtils.isNotBlank(lastName)) {
            predicates.add(
                    cb.like(
                            root.get(Customer_.LAST_NAME),
                            "%" + lastName + "%"
                    )
            );
        }
    }

    private static void addCodePredicate(List<Predicate> predicates, Root<Customer> root,
                                         CriteriaBuilder cb, String code) {
        if (StringUtils.isNotBlank(code)) {
            predicates.add(
                    cb.like(
                            root.get(Customer_.code),
                            "%" + code + "%"
                    )
            );
        }
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


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class CustomerSearch {
    private String firstName;
    private String lastName;
    private String code;
}
