package com.quinnox.qyrus.devicefarm.services;

import java.util.List;

import com.quinnox.qyrus.devicefarm.domain.Byod;
import com.quinnox.qyrus.devicefarm.domain.Count;

public interface ByodService {
	
	
	public List<Byod> getByods();

	public Byod getByod(long id);

	public Byod addByods(Byod byod);

	public Byod updateByods(Byod byod);

	public void deleteByod(long id);
	
	long total();
	
	List<Count> devices();

	List<Count> active();

	List<Count> inactive();

	List<Count> damaged();

}
