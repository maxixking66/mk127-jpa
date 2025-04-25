package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;

public class ProvinceRepositoryImpl extends SimpleJpaRepository<Province, Long>
        implements ProvinceRepository {

    protected ProvinceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Province> getDomainClass() {
        return Province.class;
    }
}
