package com.quinnox.qyrus.devicefarm.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quinnox.qyrus.devicefarm.domain.Mobile;

@Repository
public interface MobileRepo extends JpaRepository<Mobile, Long >{

	List<Mobile> findAll();

	Mobile getOne(long parseLong);

	void save(long id);
	
	@Query(value = "SELECT count(*) FROM Mobile")
	Long total();
	
	@Query(value = "SELECT count(id) FROM mobile",nativeQuery=true)
	Long totalDevices();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='Active' THEN 1 ELSE 0 END)AS Active from mobile",nativeQuery=true)
	Long totalActive();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='InActive' THEN 1 ELSE 0 END)AS InActive from mobile",nativeQuery=true)
	Long totalInActive();
	
	@Query(value ="SELECT SUM(CASE WHEN status ='Damaged' THEN 1 ELSE 0 END)AS Damaged from mobile",nativeQuery=true)
	Long totalDamaged();
	
	@Query(value ="SELECT  status, count(id) FROM devicefarm.mobile group by status",nativeQuery=true)
	List<Map<String, Object>> getDeviceStatus();
	
	
	

}
