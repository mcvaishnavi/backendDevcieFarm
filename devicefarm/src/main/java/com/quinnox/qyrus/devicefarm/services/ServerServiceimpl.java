package com.quinnox.qyrus.devicefarm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Server;
import com.quinnox.qyrus.devicefarm.repository.ServerRepo;

@Service
public class ServerServiceimpl implements ServerService{
	
	@Autowired
	private ServerRepo serverRepo;
	public ServerServiceimpl() {
		
	}
	
		
	@Override
	public List<Server> getServers() {
		
		return serverRepo.findAll();
		
	}
	
	
	@Override
	public Server getServer(long id) {
		
		return serverRepo.findById(id).orElse(null);
	}
	
	@Override	
	public Server addServers(Server server) {
		
		serverRepo.save(server);
		return server;
	}





	@Override
	public Server updateServer(Server server) {
		
		serverRepo.save(server);
		return null;
	}
	
	
	@Override
	public void deleteServer(long parseLong) {
		
		Server entity = serverRepo.getOne(parseLong);
		serverRepo.delete(entity);
	}
	
	@Override
	public long total(){
		
		 return serverRepo.count();
		

    }
	
	@Override
	public List<Count> devices() {
		
		Long td = serverRepo.totalDevices();
		Long ta = serverRepo.totalActive();
		Long ti = serverRepo.totalInActive();
		Long tda = serverRepo.totalDamaged();
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
		
		Long ta = serverRepo.totalActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setActive(ta);
		list.add(count);
		return list;
		
		
	}
	
	@Override
	public List<Count>inactive(){
		
		Long ta = serverRepo.totalInActive();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setInactive(ta);
		list.add(count);
		return list;
		
		
	}
	@Override
	public List<Count>damaged(){
		
		Long tda = serverRepo.totalDamaged();
		List<Count>list = new ArrayList<Count>();
		Count count =new Count();
		count.setDamaged(tda);
		list.add(count);
		return list;
	
	
	


	

}
}
