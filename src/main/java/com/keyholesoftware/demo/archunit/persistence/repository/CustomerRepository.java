package com.keyholesoftware.demo.archunit.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.keyholesoftware.demo.archunit.domain.Customer;

@Repository
@Transactional
@RepositoryRestResource
public interface CustomerRepository extends DomainObjectRepository<Customer> {
   
    
    @Query(value = "SELECT C FROM CUSTOMERS C WHERE C.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
    Customer findByEmailAddress(String emailAddress);
    
    @Query("SELECT C FROM CUSTOMERS C WHERE C.FIRSTNAME = :firstName OR C.LASTNAME = :lastName")
    Customer findByLastNameOrFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);
}