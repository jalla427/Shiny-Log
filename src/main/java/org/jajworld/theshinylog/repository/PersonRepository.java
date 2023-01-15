package org.jajworld.theshinylog.repository;

import java.util.List;

import org.jajworld.theshinylog.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>{

	List<Person> findAll();

	Person findByPnameAndPcode(String pname, String pcode);
	Person findByPname(String pname);
	Person findByPid(Integer pid);
	
}
