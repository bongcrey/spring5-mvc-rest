package guru.springfamework.controllers.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.services.CustomerService;

public class CustomerControllerTest {
    
    private static final long ID = 1L;
    private static final String FIRST_NAME = "Charlie";
    private static final String LAST_NAME = "Rey";
    private static final String CUST_URL = "http://www.google.com";

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testGetAllCustomers() throws Exception {
        // given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(ID);
        customer1.setFirstname(FIRST_NAME);
        customer1.setLastname(LAST_NAME);
        customer1.setCustomer_url(CUST_URL);

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setId(ID + 1L);
        customer2.setFirstname("John");
        customer2.setLastname("Smith");
        customer2.setCustomer_url(CUST_URL);

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2);

        // when
        when(customerService.getAllCustomers()).thenReturn(customers);

        // then
        mockMvc.perform(get("/api/v1/customers/")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.customers", hasSize(2)));
    }

    @Test
    void testGetCustomerByLastName() throws Exception {
        // given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(ID);
        customer1.setFirstname(FIRST_NAME);
        customer1.setLastname(LAST_NAME);
        customer1.setCustomer_url(CUST_URL);

        // when
        when(customerService.getCustomerByLastName(LAST_NAME)).thenReturn(customer1);

        // then
        mockMvc.perform(get("/api/v1/customers/Rey")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.lastname", equalTo(LAST_NAME)));
    }
}
