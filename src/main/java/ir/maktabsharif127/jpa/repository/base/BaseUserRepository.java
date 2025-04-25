package ir.maktabsharif127.jpa.repository.base;

import ir.maktabsharif127.jpa.domains.User;

import java.util.Optional;

public interface BaseUserRepository<T extends User> extends CrudRepository<T, Long> {

    Optional<T> findByUsername(String username);

    Optional<T> findByUsernameAndPassword(String username, String password);
}
