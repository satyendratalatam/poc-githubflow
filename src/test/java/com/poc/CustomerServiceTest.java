package com.poc;

import com.poc.entity.Customer;
import com.poc.repository.CustomerRepository;
import com.poc.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getAllReturnsEmptyListWhenNoCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of());
        assertThat(customerService.getAll()).isEmpty();
    }

    @Test
    void getAllReturnsCustomers() {
        Customer c = new Customer();
        c.setId(1L);
        c.setName("Alice");
        c.setEmail("alice@example.com");

        when(customerRepository.findAll()).thenReturn(List.of(c));

        List<Customer> result = customerService.getAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Alice");
    }
}
