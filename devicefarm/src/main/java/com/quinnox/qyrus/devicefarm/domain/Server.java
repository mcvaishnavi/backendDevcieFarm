package com.quinnox.qyrus.devicefarm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	
@Entity
@Table(name = "server")
public class Server {
		


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String serial_number;
	@Column(name = "type_of_device")
	private String type_of_device;
	private String manufacturer;
	private String make;
	private String model;
	private String OS;
	private String date_of_purchase;
	private String current_client;
	private String device_id;
	private String IP_address;
	private String status;
	private String Description;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
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
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
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
	public String getIP_address() {
		return IP_address;
	}
	public void setIP_address(String iP_address) {
		IP_address = iP_address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Server(long id,String serial_number, String type_of_device, String manufacturer, String make, String model, String oS,
			String date_of_purchase, String current_client, String device_id, String iP_address, String status,
			String description) {
		super();
		this.id = id;
		this.serial_number = serial_number;
		this.type_of_device = type_of_device;
		this.manufacturer = manufacturer;
		this.make = make;
		this.model = model;
		OS = oS;
		this.date_of_purchase = date_of_purchase;
		this.current_client = current_client;
		this.device_id = device_id;
		IP_address = iP_address;
		this.status = status;
		Description = description;
	}
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
