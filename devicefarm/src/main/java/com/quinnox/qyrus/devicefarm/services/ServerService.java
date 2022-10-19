package com.quinnox.qyrus.devicefarm.services;

import java.util.List;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Server;

public interface ServerService {
	
	public List<Server> getServers();

	public Server getServer(long id);

	public Server addServers(Server server);

	public Server updateServer(Server server);

	public void deleteServer(long id);
	
	long total();
	
	List<Count> devices();

	List<Count> active();

	List<Count> inactive();

	List<Count> damaged();

}
