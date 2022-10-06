package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
	//LocalDate day1,day2;
	IDateLapse lapse1,lapse2;
	@BeforeEach
	void setUp() throws Exception {
		lapse1= new DateLapse("2022-10-20", "2022-10-22");
		lapse2= new DateLapse2("2022-10-20", 2);
	}

	@Test
	void test() {
		assertTrue(lapse1.includesDate(LocalDate.parse("2022-10-21")));
		assertTrue(lapse1.includesDate(LocalDate.parse("2022-10-22")));
		assertEquals(2, lapse1.sizeInDays());
		assertTrue(lapse2.includesDate(LocalDate.parse("2022-10-21")));
		assertTrue(lapse2.includesDate(LocalDate.parse("2022-10-22")));
		assertEquals(2, lapse2.sizeInDays());
	}

}
