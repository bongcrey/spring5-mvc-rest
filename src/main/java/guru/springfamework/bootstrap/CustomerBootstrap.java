package guru.springfamework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Component
public class CustomerBootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

        public CustomerBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstname("Charlie");
        customer1.setLastname("Rey");
        customer1.setCustomer_url("http://www.google.com");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstname("John");
        customer2.setLastname("Smith");
        customer2.setCustomer_url("http://www.google.com");

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setFirstname("Jane");
        customer3.setLastname("Doe");
        customer3.setCustomer_url("http://www.google.com");

        Customer customer4 = new Customer();
        customer4.setId(4L);
        customer4.setFirstname("Elon");
        customer4.setLastname("Musk");
        customer4.setCustomer_url("http://www.google.com");

        Customer customer5 = new Customer();
        customer5.setId(5L);
        customer5.setFirstname("Jeff");
        customer5.setLastname("Bezos");
        customer5.setCustomer_url("http://www.google.com");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        System.out.println("Customer Data Loaded = " + customerRepository.count());
    }
    
}
