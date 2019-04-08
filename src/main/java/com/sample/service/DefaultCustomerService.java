package com.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.Customer;
import com.sample.integration.SimpleGateway;
import com.sample.repository.CustomerRepository;

@Service
public class DefaultCustomerService implements CustomerService{
	private static final Logger logger = LoggerFactory.getLogger(DefaultCustomerService.class);

	private final CustomerRepository customerRepository;

	@Autowired
	private SimpleGateway gateway;

	@Autowired
	public DefaultCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}		
	
	@Override
	public List<Customer> findAll() {
		logger.debug("findAll start ");
		
		return customerRepository.findAll();
	}

	@Override
	public Customer findOne(Long idCustomer) {
		logger.debug("findOne start with idCustomer {}", idCustomer);

		return customerRepository.getOne(idCustomer);
	}

	@Override
	public void save(Customer customer) {
		logger.debug("save start with customer {}", customer);

		customerRepository.save(customer);

		gateway.handleMessage("customer saved");

		logger.debug("save stop ");
	}
}
