package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.domains.Province;
import ir.maktabsharif127.jpa.dto.CityCreationRequest;
import ir.maktabsharif127.jpa.dto.CityUpdateRequest;
import ir.maktabsharif127.jpa.repository.CityRepository;
import ir.maktabsharif127.jpa.service.base.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;

public class CityServiceImpl extends BaseServiceImpl<City, Long, CityRepository>
        implements CityService {

    private final ProvinceService provinceService;

    public CityServiceImpl(CityRepository repository,
                           ProvinceService provinceService) {
        super(repository);
        this.provinceService = provinceService;
    }

    @Override
    public City create(CityCreationRequest request) {
        validateCreationUpdateRequest(request);
        repository.beginTransaction();
        City city = new City();
        fillCityProperties(request, city);
        repository.save(city);
        repository.commitTransaction();
        return city;
    }

    @Override
    public City update(CityUpdateRequest request) {
        Optional<City> optionalCity = findById(request.getId());
        if (optionalCity.isPresent()) {
            validateCreationUpdateRequest(request);
            repository.beginTransaction();
            City city = optionalCity.get();
            fillCityProperties(request, city);
            city = repository.save(city);
            repository.commitTransaction();
            return city;
        }
        throw new RuntimeException("wrong id");
    }

    @Override
    public City save(City entity) {
        throw new IllegalStateException();
    }

    private void validateCreationUpdateRequest(CityCreationRequest request) {
        validateName(request.getName());
        validateProvince(request.getProvinceId());
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("name is blank");
        }
    }

    private void validateProvince(Long provinceId) {
        if (Objects.isNull(provinceId)) {
            throw new RuntimeException("provinceId is null");
        }
        if (!provinceService.existsById(provinceId)) {
            throw new RuntimeException("wrong provinceId");
        }
    }

    private void fillCityProperties(CityCreationRequest request, City city) {
        city.setName(request.getName());
        city.setProvince(new Province(request.getProvinceId()));
    }
}
