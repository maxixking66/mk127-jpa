package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Customer;
import ir.maktabsharif127.jpa.repository.base.BaseUserRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getDomainClass() {
        return Customer.class;
    }
}
