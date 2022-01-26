package com.sample.repository;

import com.sample.domain.Titolare;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TitolareRepositoryTest {

	@Autowired
	private TitolareRepository titolareRepository;
	
	@Test
	@Order(1)
	public void findAll() {
		List<Titolare> all = titolareRepository.findAll();
		System.out.println(all);
	}
	
	@Test
	@Order(2)
	@Rollback(false)
	public void save() {
		Titolare titolare = new Titolare();
		titolare.setTitolare("Massimo Ugues");
		titolare.setNote("note per titolare");
		titolare.setDataInserimento("26/01/2022");
		titolare.setDataAggiornamento("26/01/2022");
		titolareRepository.save(titolare);
	}

	//@Test
	//@Order(3)
	public void read() {
		Titolare byId = titolareRepository.getById(1L);
		Assertions.assertEquals(byId.getTitolare(), "Massimo Ugues");
	}


	

}
