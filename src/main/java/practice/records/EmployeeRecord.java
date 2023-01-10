package practice.records;

import practice.immutableandbuilder.Address;

public record EmployeeRecord(String name, Address address) {

	private EmployeeRecord(Builder builder) {
		this(builder.getName(), cloneAddress(builder.getAddress()));
	}

	public Address address() {
		return cloneAddress(this.address);
	}
	
	public static Address cloneAddress(Address address) {
		Address clonedAddress = new Address();
		clonedAddress.setCity(address.getCity());
		clonedAddress.setHouse(address.getHouse());
		return clonedAddress;
	}

	public static Builder builder() {
		return new EmployeeRecord.Builder();
	}

	public static final class Builder {
		private String name;
		private Address address;

		public String getName() {
			return name;
		}

		public Address getAddress() {
			return address;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder address(Address address) {
			this.address = address;
			return this;
		}

		public EmployeeRecord build() {
			return new EmployeeRecord(this);
		}
	}

}
