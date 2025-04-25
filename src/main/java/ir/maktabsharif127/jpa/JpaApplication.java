package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.dto.CityUpdateRequest;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        CityUpdateRequest request = new CityUpdateRequest();
        request.setName("ورامین");
        request.setProvinceId(1L);
        request.setId(202L);

        applicationContext.getCityService().update(request);


        applicationContext.getEntityManager().close();
    }
}
