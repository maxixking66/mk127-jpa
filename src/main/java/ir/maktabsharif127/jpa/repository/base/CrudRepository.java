package ir.maktabsharif127.jpa.repository.base;

import ir.maktabsharif127.jpa.domains.base.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T entity);

    List<T> saveAll(Collection<T> entities);

    Optional<T> findById(ID id);

    List<T> findAll();

    List<T> findAllById(Iterable<ID> ids);

    long countAll();

    void deleteById(ID id);

    void deleteAllById(Iterable<ID> ids);

    boolean existsById(ID id);

}
