package org.jajworld.theshinylog.repository;

import java.util.List;

import org.jajworld.theshinylog.model.Hunts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HuntsRepository extends PagingAndSortingRepository<Hunts, Integer>{

	List<Hunts> findAll();
	
	List<Hunts> findByPidAndGenAndPokenum(Integer pid, Integer gen, Integer pokenum);
	List<Hunts> findByGenAndPokenum(Integer gen, Integer pokenum);
	List<Hunts> findByPidAndPokenum(Integer pid, Integer pokenum);
	List<Hunts> findByPidAndGen(Integer pid, Integer gen);
	List<Hunts> findByPokenum(Integer pokenum);
	List<Hunts> findByGen(Integer gen);
	List<Hunts> findByPid(Integer pid);
	List<Hunts> findByHid(Integer hid);
}
