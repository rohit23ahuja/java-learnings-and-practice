package practice.immutableandbuilder;

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

	private Employee(Builder builder) {
		this.name = builder.getName();
		Address clonedAddress = new Address();
		clonedAddress.setCity(builder.getEmployeeAddress().getCity());
		clonedAddress.setHouse(builder.getEmployeeAddress().getHouse());
		this.employeeAddress = clonedAddress;
	}

	public static Builder builder() {
		return new Employee.Builder();
	}

	public static final class Builder {
		private String name;
		private Address employeeAddress;

		public String getName() {
			return name;
		}

		public Address getEmployeeAddress() {
			return employeeAddress;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder address(Address address) {
			this.employeeAddress = address;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

}
