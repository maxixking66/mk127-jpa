package ir.maktabsharif127.jpa;

import ir.maktabsharif127.jpa.designpatters.User;

public class JpaApplication {

    public static void main(String[] args) {

        User user = getUser();

        User clone = user.clone();


    }

    private static User getUser() {
        return new User();
    }
}
