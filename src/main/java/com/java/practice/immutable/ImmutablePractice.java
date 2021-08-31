package com.java.practice.immutable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImmutablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address a = new Address();
		a.setCity("gurgaon");
		a.setHouse("602");
		Employee e = new Employee("rohit", a);
		log.info(e.getName()+" "+e.getEmployeeAddress().getCity()+" "+e.getEmployeeAddress().getHouse());
		//a.setCity("delhi");
		//a.setHouse("44");
		e.getEmployeeAddress().setCity("goa");
		e.getEmployeeAddress().setHouse("23");
		log.info(e.getName()+" "+e.getEmployeeAddress().getCity()+" "+e.getEmployeeAddress().getHouse());
	}

}
