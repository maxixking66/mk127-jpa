package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.repository.CityRepository;
import ir.maktabsharif127.jpa.service.base.BaseServiceImpl;

public class CityServiceImpl extends BaseServiceImpl<City, Long, CityRepository>
        implements CityService {
    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }
}
