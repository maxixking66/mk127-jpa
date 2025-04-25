package ir.maktabsharif127.jpa;

import com.github.javafaker.Faker;
import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.domains.Province;

import java.util.Optional;

public class JpaApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        Optional<Province> optionalProvince =
                applicationContext.getProvinceService().findById(1L);
        if (optionalProvince.isPresent()) {

//            Province province = new Province();
            Province province = optionalProvince.get();
            province.setPreCode("021");
            province.setName("تهران");

            applicationContext.getProvinceService().save(province);
        }

        applicationContext.getEntityManager().close();
    }
}
