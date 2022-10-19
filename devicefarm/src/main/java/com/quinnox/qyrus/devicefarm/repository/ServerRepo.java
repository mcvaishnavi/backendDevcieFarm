package com.quinnox.qyrus.devicefarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.qyrus.devicefarm.domain.Server;

@Repository
public interface ServerRepo extends JpaRepository<Server, Long >{
	
	List<Server> findAll();

	Server getOne(long parseLong);
	
	void save(long id);
	
	@Query(value = "SELECT count(*) FROM Server")
	Long total();
	
	@Query(value = "SELECT count(id) FROM Server",nativeQuery=true)
	Long totalDevices();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='Active' THEN 1 ELSE 0 END)AS Active from Server",nativeQuery=true)
	Long totalActive();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='InActive' THEN 1 ELSE 0 END)AS InActive from Server",nativeQuery=true)
	Long totalInActive();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='Damaged' THEN 1 ELSE 0 END)AS Damaged from Server",nativeQuery=true)
	Long totalDamaged();

}
