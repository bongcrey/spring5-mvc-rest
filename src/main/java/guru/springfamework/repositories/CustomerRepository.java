package guru.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.springfamework.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Customer findByLastname(String lastname);
}
