package com.quinnox.qyrus.devicefarm.services;

import java.util.List;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Mobile;

public interface MobileService {
	
	public List<Mobile> getMobiles();

	public Mobile getMobile(long id);

	public Mobile addMobiles(Mobile mobile);

	public Mobile updateMobiles(Mobile mobile);

	public void deleteMobile(long id);

	

	List<Count> devices();

	List<Count> active();

	List<Count> inactive();

	List<Count> damaged();

	long total();
	
	

}