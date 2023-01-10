package pratice.records;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import practice.immutableandbuilder.Address;
import practice.records.EmployeeRecord;

public class EmployeeRecordTest {

	@Test
	public void givenAnAddressAsFieldEmployee_WhenUpdateAddress_ThenEmployeeAddressShouldRemainImmutable() {
		Address a = new Address();
		a.setCity("gurgaon");
		a.setHouse("602");

		EmployeeRecord employeeRecord = EmployeeRecord.builder().name("rohit").address(a).build();

		assertEquals("gurgaon", employeeRecord.address().getCity());
		assertEquals("602", employeeRecord.address().getHouse());

		// update Address a
		a.setCity("delhi");
		a.setHouse("148");

		// update Address field of Employee e
		employeeRecord.address().setCity("goa");
		employeeRecord.address().setHouse("23");

		assertEquals("gurgaon", employeeRecord.address().getCity());
		assertEquals("602", employeeRecord.address().getHouse());
	}
}
