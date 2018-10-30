package com.sample.service;

import java.util.List;

import com.sample.domain.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findOne(Long idCustomer);

	public void save(Customer customer);

}
