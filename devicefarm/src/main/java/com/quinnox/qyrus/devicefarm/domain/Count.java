package com.quinnox.qyrus.devicefarm.domain;

public class Count {
	
	private Long total;
	private Long active;
	private Long inactive;
	private Long damaged;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getActive() {
		return active;
	}
	public void setActive(Long active) {
		this.active = active;
	}
	public Long getInactive() {
		return inactive;
	}
	public void setInactive(Long inactive) {
		this.inactive = inactive;
	}
	public Long getDamaged() {
		return damaged;
	}
	public void setDamaged(Long damaged) {
		this.damaged = damaged;
	}
	public Count(Long total, Long active, Long inactive, Long damaged) {
		super();
		this.total = total;
		this.active = active;
		this.inactive = inactive;
		this.damaged = damaged;
	}
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
