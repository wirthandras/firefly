package hu.wirthandras.firefly.domain.authorization;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.wirthandras.firefly.TestBase;
import hu.wirthandras.firefly.domain.person.Client;
import hu.wirthandras.firefly.domain.person.Witness;

public class DefiniteAuthorizationTest extends TestBase {

	private Authorization classToTest;

	private final String filename = "sample.pdf";

	private Witness witness = new Witness("Joe", "New York");
	private Client client = new Client("John", "John", "Washington", LocalDate.now(), "Mother", "New York");

	@Before
	public void setUp() {
		classToTest = new DefiniteAuthorization(client, client, witness, witness);
	}

	@Test
	public void testCreateDefiniteAuthorization() throws IOException {
		File pdf = new File(folder.newFolder(), filename);
		classToTest.make(pdf.getAbsolutePath());

		assertTrue(pdf.exists());
	}

	@Test
	//TODO find a cross OS solution
	@Ignore("this test fails on circleci")
	public void testFileNotFoundExceptionOccured() throws IOException {

		String nonExistingPath = "BLABLA:\\" + filename;

		assumeFalse(new File(nonExistingPath).exists());

		expectedException.expect(FileNotFoundException.class);

		classToTest.make(nonExistingPath);
	}

}
