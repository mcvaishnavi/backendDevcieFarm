package com.quinnox.qyrus.devicefarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.qyrus.devicefarm.domain.Byod;
import com.quinnox.qyrus.devicefarm.domain.Count;
import com.quinnox.qyrus.devicefarm.services.ByodService;

@RestController
public class ByodController {
	
	@Autowired
	private ByodService byodService;
	
	@GetMapping("/home3")
	public String home() {
		return " Namaskara";
	}
	
	// GET
	
	@GetMapping("/byod")
	public List<Byod> getByods() {
		
		return this.byodService.getByods(); 		
		
	}
	
	// GET id
	
	@GetMapping("/byod/{id}")
	public Byod getByod(@PathVariable long id) {
		
		return this.byodService.getByod(id);		
	}
	
	// POST 
	
	@PostMapping("/postbyod")
	public Byod addByods(@RequestBody Byod byod) {
		
		return this.byodService.addByods(byod);
		
	}
	
	// PUT
	
	@PutMapping("/putbyod")
	public Byod updateByods(@RequestBody Byod byod) {
		
		return this.byodService.updateByods(byod); 
	}
	
	@GetMapping("/byod/total")
	public long total() {
		
		return byodService.total();		
	}
	
	@GetMapping("/byod/report")
	public List<Count> devices() {
		
		return byodService.devices();		
	}
	
	
	// DELETE
	
	
	@DeleteMapping("/byod/{id}")
	public ResponseEntity<HttpStatus> deleteByod(@PathVariable String id){
		
		try {
			this.byodService.deleteByod(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
