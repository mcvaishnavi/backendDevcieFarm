package com.quinnox.qyrus.devicefarm.domain;


import java.util.Date;
import java.util.function.IntPredicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;


@Entity
@Table(name = "mobile")
public class Mobile {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_generator")
	//@SequenceGenerator(name="mobile_generator", sequenceName = "mobile_seq", allocationSize=1)
	//@Column(name = "serial_number", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name = "serial_number" )
	private String serial_number;
    @Column(name = "type_of_device" )
	private String type_of_device;
    @Column(name = "manufacturer" )
	private String manufacturer;
    @Column(name = "make" )
	private String make;
    @Column(name = "model" )
	private String model;
    @Column(name = "os" )
	private String os;
    @Column(name = "date_of_purchase" )
	private String date_of_purchase;
    @Column(name = "current_client" )
	private String current_client;
    @Column(name = "device_id" )
	private String device_id;
    @Column(name = "ip_address" )
	private String ip_address;
    @Column(name = "server_connected" )
	private String server_connected;
    @Column(name = "phno" )
	private String phno;
    @Column(name = "status" )
	private String status;
    @Column(name = "description" )
	private String description;
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType_of_device() {
		return type_of_device;
	}
	public void setType_of_device(String type_of_device) {
		this.type_of_device = type_of_device;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOS() {
		return os;
	}
	public void setOS(String oS) {
		os = oS;
	}
	public String getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(String date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
	public String getCurrent_client() {
		return current_client;
	}
	public void setCurrent_client(String current_client) {
		this.current_client = current_client;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getIP_address() {
		return ip_address;
	}
	public void setIP_address(String iP_address) {
		ip_address = iP_address;
	}
	public String getServer_connected() {
		return server_connected;
	}
	public void setServer_connected(String server_connected) {
		this.server_connected = server_connected;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Mobile(long id,String type_of_device, String manufacturer, String make, String model, String os, String date_of_purchase,
			String current_client, String device_id, String serial_number, String ip_address, String server_connected,
			String phno, String status, String description) {
		super();
		this.id = id;
		this.type_of_device = type_of_device;
		this.manufacturer = manufacturer;
		this.make = make;
		this.model = model;
		this.os = os;
		this.date_of_purchase = date_of_purchase;
		this.current_client = current_client;
		this.device_id = device_id;
		this.serial_number = serial_number;
		this.ip_address = ip_address;
		this.server_connected = server_connected;
		this.phno = phno;
		this.status = status;
		this.description = description;
	}
	public Mobile() {
		super();
	}

	/*
	 * public void setDate_of_purchase(String i) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 */
	public Object thenReturn(Mobile mobile) {
		// TODO Auto-generated method stub
		return null;
	}
	public IntPredicate isEqualTo(Mobile mobile) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object id(long l) {
		// TODO Auto-generated method stub
		return null;
	}
	public IntPredicate get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
