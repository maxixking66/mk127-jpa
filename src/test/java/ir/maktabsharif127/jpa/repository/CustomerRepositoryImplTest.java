package ir.maktabsharif127.jpa.repository;

import ir.maktabsharif127.jpa.domains.Customer;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerRepositoryImplTest {

    ;

    @Test
    void save() {

        EntityManager em = mock(EntityManager.class);

        CustomerRepository customerRepository = new CustomerRepositoryImpl(em);

        doAnswer(i -> {
            Customer customer = i.getArgument(0, Customer.class);
            customer.setId(100L);
            customer.setCreateDate(ZonedDateTime.now());
            return null;
        }).when(em).persist(any(Customer.class));

        Customer customer = customerRepository.save(new Customer());

        Assertions.assertNotNull(customer.getId());
        Assertions.assertNotNull(customer.getCreateDate());
        Assertions.assertNull(customer.getLastUpdateDate());

//        1
//        Customer updated = new Customer();
//        updated.setLastUpdateDate(ZonedDateTime.now());
//        when(em.merge(any(Customer.class))).thenReturn(updated);

        when(em.merge(any(Customer.class))).then(
                i -> {
                    Customer arg = i.getArgument(0, Customer.class);
                    arg.setLastUpdateDate(ZonedDateTime.now());
                    return arg;
                }
        );

        Customer updated = customerRepository.save(customer);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getLastUpdateDate());
        Assertions.assertNotNull(updated.getId());
    }
}