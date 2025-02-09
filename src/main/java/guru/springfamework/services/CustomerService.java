package guru.springfamework.services;

import java.util.List;

import guru.springfamework.api.v1.model.CustomerDTO;

public interface CustomerService {
    
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByLastName(String lastName);
}
