package com.sample.repository;

import com.sample.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath*:application-context/persistence-test-context.xml" })
@Transactional(propagation = Propagation.REQUIRED)
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
