package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
