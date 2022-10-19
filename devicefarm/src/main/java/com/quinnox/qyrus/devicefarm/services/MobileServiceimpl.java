package com.quinnox.qyrus.devicefarm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Mobile;
import com.quinnox.qyrus.devicefarm.repository.MobileRepo;

@Service
public class MobileServiceimpl implements MobileService {

	@Autowired
	private MobileRepo mobileRepo;
	public MobileServiceimpl() {
		
	}
	
		
	
	
	@Override
	public List<Mobile> getMobiles() {
		
		return mobileRepo.findAll();
		
	}
	
	
	@Override
	public Mobile getMobile(long id) {
		
		return mobileRepo.findById(id).orElse(null);
	}
	
	@Override	
	public Mobile addMobiles(Mobile mobile) {
		
		mobileRepo.save(mobile);
		return mobile;
	}



	@Override
	public Mobile updateMobiles(Mobile mobile) {
		
		
		 mobileRepo.save(mobile);
		 return null;
	}
	
	
	@Override
	public void deleteMobile(long parseLong) {
		
		Mobile entity = mobileRepo.getOne(parseLong);
		mobileRepo.delete(entity);
	}




	@Override
	public List<Count> devices() {
		
		Long td = mobileRepo.totalDevices();
		Long ta = mobileRepo.totalActive();
		Long ti = mobileRepo.totalInActive();
		Long tda = mobileRepo.totalDamaged();
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
		
		Long ta = mobileRepo.totalActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setActive(ta);
		list.add(count);
		return list;
		
		
	}
	
	@Override
	public List<Count>inactive(){
		
		Long ta = mobileRepo.totalInActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setInactive(ta);
		list.add(count);
		return list;
		
		
	}
	
	@Override
	public long total(){
		
		 return mobileRepo.count();
		
		
		
		
		
		
	}
	
	@Override
	public List<Count>damaged(){
		
		Long tda = mobileRepo.totalDamaged();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setDamaged(tda);
		list.add(count);
		return list;
	
	

}

}
