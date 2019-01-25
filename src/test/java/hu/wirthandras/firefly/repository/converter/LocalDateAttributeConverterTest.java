package hu.wirthandras.firefly.repository.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class LocalDateAttributeConverterTest {

	private static final int DAY = 1;
	private static final int MONTH = 1;
	private static final int YEAR = 2019;
	private static final long dateTimestamp = 1546297200000l;
	private LocalDateAttributeConverter converter;

	@Before
	public void setUp() {
		converter = new LocalDateAttributeConverter();
	}

	@Test
	public void testConvertToDatabaseColumnWithRealDate() {
		Date date = converter.convertToDatabaseColumn(LocalDate.of(YEAR, MONTH, DAY));

		assertNotNull(date);
		assertEquals("2019-01-01", date.toString());
		assertEquals(dateTimestamp, date.getTime());
	}

	@Test
	public void testConvertToDatabaseColumnWithNull() {
		Date date = converter.convertToDatabaseColumn(null);

		assertNull(date);
	}

	@Test
	public void testConvertToEntityAttributeWithRealDate() {
		LocalDate localDate = converter.convertToEntityAttribute(new Date(dateTimestamp));

		assertNotNull(localDate);
		assertEquals(YEAR, localDate.getYear());
		assertEquals(Month.JANUARY, localDate.getMonth());
		assertEquals(DAY, localDate.getDayOfMonth());
	}

	@Test
	public void testConvertToEntityAttributeWithNull() {
		LocalDate localDate = converter.convertToEntityAttribute(null);

		assertNull(localDate);
	}

}
