package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;

public class CityRepositoryImpl extends SimpleJpaRepository<City, Long>
        implements CityRepository {

    protected CityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<City> getDomainClass() {
        return City.class;
    }
}
