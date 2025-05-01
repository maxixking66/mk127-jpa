package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.repository.ProvinceRepository;
import ir.maktabsharif127.jpa.service.base.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;

public class ProvinceServiceImpl extends BaseServiceImpl<Province, Long, ProvinceRepository>
        implements ProvinceService {
    public ProvinceServiceImpl(ProvinceRepository repository) {
        super(repository);
    }

    @Override
    public Province save(Province entity) {
        validateEntity(entity);
        return super.save(entity);
    }

    private void validateEntity(Province entity) {
        validateName(entity);
//        validatePreCode(entity);
//        validateSomething(entity);
    }

    private void validateName(Province entity) {
        if (StringUtils.isBlank(entity.getName())) {
            throw new RuntimeException("name is blank");
        }
        if (entity.getId() == null) {
            if (repository.existsByName(entity.getName())) {
                throw new RuntimeException(
                        "duplicate name for province, name " + entity.getName() + " is already taken"
                );
            }
        } else {
            if (repository.existsByNameAndIdIsNot(entity.getName(), entity.getId())) {
                throw new RuntimeException(
                        "duplicate name for province, name " + entity.getName() + " is already taken"
                );
            }
        }
    }
}
