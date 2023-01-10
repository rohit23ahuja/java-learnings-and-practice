package practice.immutableandbuilder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import practice.immutableandbuilder.Address;
import practice.immutableandbuilder.Employee;

public class ImmutableEmployeeTest {

	@Test
	public void givenAnAddressAsFieldEmployee_WhenUpdateAddress_ThenEmployeeAddressShouldRemainImmutable() {
		Address a = new Address();
		a.setCity("gurgaon");
		a.setHouse("602");

		Employee e = Employee.builder().name("rohit").address(a).build();

		assertEquals("gurgaon", e.getEmployeeAddress().getCity());
		assertEquals("602", e.getEmployeeAddress().getHouse());

		// update Address a
		a.setCity("delhi");
		a.setHouse("148");

		// update Address field of Employee e
		e.getEmployeeAddress().setCity("goa");
		e.getEmployeeAddress().setHouse("23");

		assertEquals("gurgaon", e.getEmployeeAddress().getCity());
		assertEquals("602", e.getEmployeeAddress().getHouse());
	}
}
