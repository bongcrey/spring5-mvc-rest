package guru.springfamework.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

public class CustomerServiceTest {

    private static final long ID = 1L;
    private static final String FIRST_NAME = "Charlie";
    private static final String LAST_NAME = "Rey";
    private static final String CUST_URL = "http://www.google.com";

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void testGetAllCustomers() {
        // given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        // when
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();

        // then
        assertEquals(customers.size(), customerDTOs.size());
    }

    @Test
    void testGetCustomerByLastName() {
        // given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRST_NAME);
        customer.setLastname(LAST_NAME);
        customer.setCustomer_url(CUST_URL);

        when(customerRepository.findByLastname(LAST_NAME)).thenReturn(customer);

        // when
        CustomerDTO customerDTO = customerService.getCustomerByLastName(LAST_NAME);

        // then
        assertEquals(ID, customerDTO.getId());
        assertEquals(LAST_NAME, customerDTO.getLastname());
        assertEquals(FIRST_NAME, customerDTO.getFirstname());
        assertEquals(CUST_URL, customerDTO.getCustomer_url());
    }
}
