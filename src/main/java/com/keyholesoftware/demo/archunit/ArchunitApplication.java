package com.keyholesoftware.demo.archunit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

import com.keyholesoftware.demo.archunit.domain.Address;
import com.keyholesoftware.demo.archunit.domain.Customer;
import com.keyholesoftware.demo.archunit.domain.Employee;
import com.keyholesoftware.demo.archunit.domain.Order;
import com.keyholesoftware.demo.archunit.domain.OrderDetail;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EntityScan(basePackageClasses= {Address.class,Customer.class,Employee.class,Order.class,OrderDetail.class})
@EnableAutoConfiguration
public class ArchunitApplication { 

    public static void main(String[] args) {
        SpringApplication.run(ArchunitApplication.class, args);
    }

}

