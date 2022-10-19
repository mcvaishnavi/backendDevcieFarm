package com.quinnox.qyrus.devicefarm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

//import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.domain.Mobile;
import com.quinnox.qyrus.devicefarm.services.MobileService;


@RestController
@CrossOrigin
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@GetMapping("/home")
	public String home() {
		return " Namaskara";
	}
	
	// GET
	
	@GetMapping("/mobile")
	public List<Mobile> getMobiles() {
		
		return this.mobileService.getMobiles(); 		
		
	}
	
	// GET id
	
	@GetMapping("/mobile/{id}")
	public Mobile getMobile(@PathVariable long id) {
		
		return mobileService.getMobile(id);		
	}
	
	// POST 
	
	@PostMapping("/postmobile")
	public Mobile addMobiles(@RequestBody Mobile mobile) {
		
		return this.mobileService.addMobiles(mobile);
		
	}
	
	// PUT
	
	@PutMapping("/putmobile")
	public Mobile updateMobiles(@RequestBody Mobile mobile) {
		
		return this.mobileService.updateMobiles(mobile); 
	}
	
	
	// DELETE
	
	
	@DeleteMapping("/mobile/{id}")
	public ResponseEntity<HttpStatus> deleteMobile(@PathVariable String id){
		
		try {
			this.mobileService.deleteMobile(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/mobile/report")
	public List<Count> devices() {
		
		return mobileService.devices();		
	}
	
	@GetMapping("/mobile/total")
	public long total() {
		
		return mobileService.total();		
	}
	
	@GetMapping("/mobile/active")
	public List<Count> active() {
		
		return mobileService.active();		
	}
	
	@GetMapping("/mobile/inactive")
	public List<Count> inactive() {
		
		return mobileService.inactive();		
	}
	
	@GetMapping("/mobile/damaged")
	public List<Count> damaged() {
		
		return mobileService.damaged();		
	}

}
