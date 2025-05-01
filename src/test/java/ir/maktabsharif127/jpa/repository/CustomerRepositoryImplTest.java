package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerRepositoryImplTest {

    CustomerRepository customerRepository;

    @Test
    void save() {
//        تقلید کردن


        Assertions.assertNotNull(
                customerRepository.save(new Customer())
                        .getId()
        );
    }
}