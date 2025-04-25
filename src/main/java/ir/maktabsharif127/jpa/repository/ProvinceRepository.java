package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.repository.base.CrudRepository;

public interface ProvinceRepository extends CrudRepository<Province, Long> {

    boolean existsByName(String name);

    boolean existsByNameAndIdIsNot(String name, Long id);
}
