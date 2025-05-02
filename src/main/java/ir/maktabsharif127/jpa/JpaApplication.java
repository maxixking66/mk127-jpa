package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.config.ApplicationContext;
import ir.maktabsharif127.jpa.designpatters.User;
import ir.maktabsharif127.jpa.repository.ProvinceRepository;

public class JpaApplication {

    public static void main(String[] args) {


        System.out.println(
                ApplicationContext.getInstance().getBean(ProvinceRepository.class)
                        .countAll()
        );


    }

    private static User getUser() {
        return new User();
    }
}
