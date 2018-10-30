package com.sample.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application-context/persistence-test-context.xml" })
@Transactional(propagation = Propagation.REQUIRED)
@WebAppConfiguration
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void findAll() {
		List<Customer> findAll = customerRepository.findAll();		
		System.out.println(findAll);
	}
	
	@Test
	@Rollback(false)
	public void save() {
		Customer customer = new Customer();
		customer.setName("max");
		customer.setSurname("xam");
		customer.setAge(38);
		customerRepository.save(customer);		
	}
	

}
