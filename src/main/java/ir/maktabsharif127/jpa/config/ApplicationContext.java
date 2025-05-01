package ir.maktabsharif127.jpa.config;

import ir.maktabsharif127.jpa.repository.CityRepository;
import ir.maktabsharif127.jpa.repository.CityRepositoryImpl;
import ir.maktabsharif127.jpa.repository.ProvinceRepository;
import ir.maktabsharif127.jpa.repository.ProvinceRepositoryImpl;
import ir.maktabsharif127.jpa.service.CityService;
import ir.maktabsharif127.jpa.service.CityServiceImpl;
import ir.maktabsharif127.jpa.service.ProvinceService;
import ir.maktabsharif127.jpa.service.ProvinceServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class ApplicationContext {

    private static ApplicationContext applicationContext;

    private final String persistenceUnit;

    private static final String DEFAULT_UNIT = "default";

    private ApplicationContext(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public static ApplicationContext getInstance() {
        if (Objects.isNull(applicationContext)) {
            applicationContext = new ApplicationContext(DEFAULT_UNIT);
        }
        return applicationContext;
    }

    public static ApplicationContext getInstance(String persistenceUnit) {
        if (Objects.isNull(applicationContext)) {
            applicationContext = new ApplicationContext(persistenceUnit);
        }
        return applicationContext;
    }

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        if (Objects.isNull(entityManagerFactory)) {
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnit);
        }
        return entityManagerFactory;
    }

    private EntityManager em;

    public EntityManager getEntityManager() {
        if (Objects.isNull(em)) {
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }

    private ProvinceRepository provinceRepository;

    public ProvinceRepository getProvinceRepository() {
        if (Objects.isNull(provinceRepository)) {
            provinceRepository = new ProvinceRepositoryImpl(getEntityManager());
        }
        return provinceRepository;
    }


    private CityRepository cityRepository;

    public CityRepository getCityRepository() {
        if (Objects.isNull(cityRepository)) {
            cityRepository = new CityRepositoryImpl(getEntityManager());
        }
        return cityRepository;
    }

    private ProvinceService provinceService;

    public ProvinceService getProvinceService() {
        if (Objects.isNull(provinceService)) {
            provinceService = new ProvinceServiceImpl(getProvinceRepository());
        }
        return provinceService;
    }

    private CityService cityService;

    public CityService getCityService() {
        if (Objects.isNull(cityService)) {
            cityService = new CityServiceImpl(getCityRepository(), getProvinceService());
        }
        return cityService;
    }
}
