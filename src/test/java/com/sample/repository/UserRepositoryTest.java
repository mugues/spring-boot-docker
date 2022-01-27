package com.sample.repository;

import com.sample.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath*:application-context/persistence-test-context.xml" })
@Transactional(propagation = Propagation.REQUIRED)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAll() {
		List<User> all = userRepository.findAll();
		System.out.println(all);
	}
	
	@Test
	@Rollback(false)
	public void save() {
		User user = new User();
		user.setName("max");
		user.setEmail("m@x.it");
		userRepository.save(user);
	}
	

}
