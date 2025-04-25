package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.dto.CityCreationRequest;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        CityCreationRequest request = new CityCreationRequest();
        request.setName("اصفهان");
        request.setProvinceId(52L);

        applicationContext.getCityService().create(request);


        applicationContext.getEntityManager().close();
    }
}
