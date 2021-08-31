package com.java.practice.immutable;

public final class Employee {
	private final String name;
	private final Address employeeAddress;

	public String getName() {
		return name;
	}

	public Address getEmployeeAddress() {
		Address clonedAddress = new Address();
		clonedAddress.setCity(employeeAddress.getCity());
		clonedAddress.setHouse(employeeAddress.getHouse());
		return clonedAddress;
	}
	
	public Employee(String name, Address a) {
		this.name=name;
		Address clonedAddress = new Address();
		clonedAddress.setCity(a.getCity());
		clonedAddress.setHouse(a.getHouse());	
		this.employeeAddress=clonedAddress;
	}

}
