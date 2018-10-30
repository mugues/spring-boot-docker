package com.sample.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Customer;
import com.sample.service.CustomerService;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
    List<Customer> findAll() {
		logger.debug("findAll start1");
		return customerService.findAll();
    }

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	void save(@RequestBody Customer customer) {
		logger.debug("save start");
		customerService.save(customer);
	}
	

}
