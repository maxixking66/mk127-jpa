package ir.maktabsharif127.jpa.service;

import ir.maktabsharif127.jpa.domains.City;
import ir.maktabsharif127.jpa.dto.CityCreationRequest;
import ir.maktabsharif127.jpa.dto.CityUpdateRequest;
import ir.maktabsharif127.jpa.service.base.BaseService;

public interface CityService extends BaseService<City, Long> {

    City create(CityCreationRequest request);

    City update(CityUpdateRequest request);

}
