package ir.maktabsharif127.jpa.config;

import ir.maktabsharif127.jpa.repository.ProvinceRepository;
import ir.maktabsharif127.jpa.repository.ProvinceRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {

    private static ApplicationContext applicationContext;

    private final String persistenceUnit;

    private static final String DEFAULT_UNIT = "default";

    private ApplicationContext(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    private final Map<Class<?>, Object> beanMap = new HashMap<>();

    public static ApplicationContext getInstance() {
//        if (Objects.isNull(applicationContext)) {
//            applicationContext = new ApplicationContext(DEFAULT_UNIT);
//        }
//        return applicationContext;
        return getInstance(DEFAULT_UNIT);
    }

    public static ApplicationContext getInstance(String persistenceUnit) {
        if (Objects.isNull(applicationContext)) {
            applicationContext = new ApplicationContext(persistenceUnit);
            initializeBeansStatic(applicationContext);
            applicationContext.initializeBeans();
        }
        return applicationContext;
    }

    private static void initializeBeansStatic(ApplicationContext applicationContext) {
//        TODO impl this
    }

    private void initializeBeans() {
        beanMap.put(EntityManagerFactory.class, createEntityManagerFactory());
        beanMap.put(EntityManager.class, createEntityManager());
        beanMap.put(ProvinceRepository.class, createProvinceRepository());
    }

    private EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(this.persistenceUnit);
    }

    private EntityManager createEntityManager() {
        return getBean(EntityManagerFactory.class).createEntityManager();
    }

    private ProvinceRepository createProvinceRepository() {
        return new ProvinceRepositoryImpl(
                getBean(EntityManager.class)
        );
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> clazz) {
        Object o = beanMap.get(clazz);
        if (o == null) {
            throw new RuntimeException("no such a bean");
        }
        return (T) o;
    }
}
