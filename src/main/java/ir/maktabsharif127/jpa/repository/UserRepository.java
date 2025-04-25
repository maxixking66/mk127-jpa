package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.User;
import ir.maktabsharif127.jpa.repository.base.BaseUserRepository;

import java.util.Optional;

public interface UserRepository extends BaseUserRepository<User> {

    Optional<User> findByUsername(String username);
}
