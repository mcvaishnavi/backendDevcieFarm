package com.quinnox.qyrus.devicefarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Server;
import com.quinnox.qyrus.devicefarm.services.ServerService;

@RestController
@CrossOrigin
public class ServerController {
	
	@Autowired
	private ServerService serverService;
	
	@GetMapping("/home2")
	public String home() {
		return " Namaskara";
	}
	
	// GET
	
	@GetMapping("/server")
	public List<Server> getServers() {
		
		return this.serverService.getServers(); 		
		
	}
	
	// GET id
	
	@GetMapping("/server/{id}")
	public Server getServer(@PathVariable long id) {
		
		return this.serverService.getServer(id);		
	}
	
	// POST 
	
	@PostMapping("/postserver")
	public Server addServers(@RequestBody Server server) {
		
		return this.serverService.addServers(server);
		
	}
	
	// PUT
	
	@PutMapping("/putserver")
	public Server updateServer(@RequestBody Server server) {
		
		return this.serverService.updateServer(server); 
	}
	
	
	@GetMapping("/server/total")
	public long total() {
		
		return serverService.total();		
	}
	
	@GetMapping("/server/report")
	public List<Count> devices() {
		
		return serverService.devices();		
	}
	
	
	// DELETE
	
	
	@DeleteMapping("/server/{id}")
	public ResponseEntity<HttpStatus> deleteServer(@PathVariable String id){
		
		try {
			this.serverService.deleteServer(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
	
	
