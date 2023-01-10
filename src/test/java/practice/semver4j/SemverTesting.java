package practice.semver4j;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.vdurmont.semver4j.Semver;
import com.vdurmont.semver4j.SemverException;

import lombok.extern.slf4j.Slf4j;

public class SemverTesting {

	@Test
	public void givenTwoInequalValidStringVersions_ThenAssertInequality() {
		Semver actual = new Semver("1.1.0");
		Semver wanted = new Semver("1.2.0");
		Assertions.assertTrue(actual.isLowerThan(wanted));
	}

	@Test
	public void givenTwoEqualValidStringVersions_ThenAssertEquality() {
		Semver actual = new Semver("1.1.0");
		Semver wanted = new Semver("1.1.0");
		Assertions.assertTrue(actual.isEqualTo(wanted));
	}

	@Test
	public void givenInvalidStringVersion_ThenParseException() {
		assertThrows(SemverException.class, ()-> new Semver("abcd"));
	}

}
