package com.keyholesoftware.archunit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.keyholesoftware.archunit.demo.domain.Product;

@RepositoryRestResource
public interface Repository extends JpaRepository<Product, Long> {
}