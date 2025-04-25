package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.domains.Province_;
import ir.maktabsharif127.jpa.repository.base.SimpleJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ProvinceRepositoryImpl extends SimpleJpaRepository<Province, Long>
        implements ProvinceRepository {

    public ProvinceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Province> getDomainClass() {
        return Province.class;
    }

    @Override
    public boolean existsByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Province> from = query.from(getDomainClass());
        query.select(cb.count(from));
        query.where(
                cb.equal(
                        from.get(Province_.name), name
                )
        );
        return entityManager.createQuery(query).getSingleResult() > 0;
    }

    @Override
    public boolean existsByNameAndIdIsNot(String name, Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Province> from = query.from(getDomainClass());
        query.select(cb.count(from));
        query.where(
                cb.and(
                        cb.equal(
                                from.get(Province_.name), name
                        ),
                        cb.notEqual(
                                from.get(Province_.id), id
                        )
                )
        );
        return entityManager.createQuery(query).getSingleResult() > 0;
    }
}
