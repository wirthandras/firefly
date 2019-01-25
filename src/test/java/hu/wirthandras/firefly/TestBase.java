package hu.wirthandras.firefly;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

public class TestBase {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Rule
	public Timeout timeout = new Timeout(2, TimeUnit.SECONDS);

}
