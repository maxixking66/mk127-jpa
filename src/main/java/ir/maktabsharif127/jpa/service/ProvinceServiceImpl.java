package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.repository.ProvinceRepository;
import ir.maktabsharif127.jpa.service.base.BaseServiceImpl;

public class ProvinceServiceImpl extends BaseServiceImpl<Province, Long, ProvinceRepository>
        implements ProvinceService {
    public ProvinceServiceImpl(ProvinceRepository repository) {
        super(repository);
    }
}
