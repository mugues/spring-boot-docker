package com.sample.repository;

import com.sample.domain.Titolare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TitolareRepository extends JpaRepository<Titolare, Long> {

}
