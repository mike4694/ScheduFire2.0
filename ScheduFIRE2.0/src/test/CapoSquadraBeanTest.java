package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.bean.CapoSquadraBean;

class CapoSquadraBeanTest {
	
	static CapoSquadraBean tester;
	static CapoSquadraBean testing;

	@BeforeAll
	static void setUp() {
		tester = new CapoSquadraBean();
		tester = new CapoSquadraBean("nome", "cognome", "email", "b", "username");
	}
	
	@BeforeEach
	void prepare() {
		testing = new CapoSquadraBean("nome", "cognome", "email", "b", "username");
	}

	@Test
	void equalNull() {
		assertFalse(tester.equals(null));
	}
	
	@Test
	void equalDiffClass() {
		assertFalse(tester.equals("a"));
	}
	
	@Test
	void equalDiffCognome() {
		testing.setCognome("a");
		assertFalse(tester.equals(testing));
	}
	
	@Test
	void equalDiffEmail() {
		testing.setEmail("a");
		assertFalse(tester.equals(testing));
	}
	
	@Test
	void equalDiffNome() {
		testing.setNome("a");
		assertFalse(tester.equals(testing));
	}
	
	@Test
	void equalDiffTurno() {
		testing.setTurno("a");
		assertFalse(tester.equals(testing));
	}
	
	@Test
	void equalDiffUsername() {
		testing.setUsername("a");
		assertFalse(tester.equals(testing));
	}
	
	@Test
	void equal() {
		assertTrue(tester.equals(testing));
	}

}
