package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.designpatters.User;

public class JpaApplication {

    public static void main(String[] args) {

//        User first = new User();
//        first.setFirstName("mohsen");
//        first.setLastName("asgari");

        System.out.println(
                User.builder()
                        .firstName("mohsen")
                        .lastName("asgari")
                        .build()
        );

        System.out.println(
                User.builder()
                        .username("x")
                        .password("x")
                        .build()
        );

    }

    private static User getUser() {
        return new User();
    }
}
