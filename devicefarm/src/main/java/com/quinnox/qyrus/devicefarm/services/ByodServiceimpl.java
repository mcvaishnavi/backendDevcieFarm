package com.quinnox.qyrus.devicefarm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qyrus.devicefarm.domain.Byod;
import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.repository.ByodRepo;

@Service
public class ByodServiceimpl implements ByodService{
	
	@Autowired
	private ByodRepo byodRepo;
	public ByodServiceimpl() {
		
	}
	
		
	@Override
	public List<Byod> getByods() {
		
		return byodRepo.findAll();
		
	}
	
	
	@Override
	public Byod getByod(long id) {
		
		return byodRepo.findById(id).orElse(null);
	}
	
	@Override	
	public Byod addByods(Byod byod) {
		
		byodRepo.save(byod);
		return byod;
	}





	@Override
	public Byod updateByods(Byod byod) {
		
		byodRepo.save(byod);
		return null;
	}
	
	@Override
	public long total(){
		
		 return byodRepo.count();
		
	}
	
	@Override
	public void deleteByod(long parseLong) {
		
		Byod entity = byodRepo.getOne(parseLong);
		byodRepo.delete(entity);
	}
	
	@Override
	public List<Count> devices() {
		
		Long td = byodRepo.totalDevices();
		Long ta = byodRepo.totalActive();
		Long ti = byodRepo.totalInActive();
		Long tda = byodRepo.totalDamaged();
		List<Count>list = new ArrayList<Count>();
		Count count = new Count();
		count.setTotal(td);
		count.setActive(ta);
		count.setInactive(ti);
		count.setDamaged(tda);
		list.add(count);
		return list;
		
	}
	
	@Override
	public List<Count>active(){
		
		Long ta = byodRepo.totalActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setActive(ta);
		list.add(count);
		return list;
		
		
	}
	
	@Override
	public List<Count>inactive(){
		
		Long ta = byodRepo.totalInActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setInactive(ta);
		list.add(count);
		return list;
		
		
	}
	@Override
	public List<Count>damaged(){
		
		Long tda = byodRepo.totalDamaged();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setDamaged(tda);
		list.add(count);
		return list;
	
	

}

}
