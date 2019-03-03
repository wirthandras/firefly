package hu.wirthandras.firefly.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.wirthandras.firefly.controller.Input;

public class PDFGeneratorTest {
	
	private PDFGenerator classToTest;
	
	private Input input;
	
	@Before
	public void setUp() {
		classToTest = new PDFGenerator();
		
		input = mock(Input.class);
		
		when(input.getValid()).thenReturn("2018.01.01");
		when(input.getApplicable()).thenReturn("2018.02.02");
		when(input.getAuthorizingPersonName()).thenReturn("John");
		when(input.getProxyPersonName()).thenReturn("Billy");
		when(input.getCondition()).thenReturn("Condition");
		when(input.getWitness1Address()).thenReturn("Witness1Address");
		when(input.getWitness2Address()).thenReturn("Witness2Address");
		when(input.getWitness1Name()).thenReturn("Witness1Name");
		when(input.getWitness2Name()).thenReturn("Witness2Name");
		
	}
	
	private void verification() {
		verify(input, times(1)).getValid();
		verify(input, times(1)).getApplicable();
		verify(input, times(1)).getAuthorizingPersonName();
		verify(input, times(1)).getProxyPersonName();
		verify(input, times(1)).getCondition();
		verify(input, times(1)).getWitness1Address();
		verify(input, times(1)).getWitness2Address();
		verify(input, times(1)).getWitness1Name();
		verify(input, times(1)).getWitness2Name();
	}
	
	@Test
	public void testa() throws IOException {
		classToTest.addData(input);
		Assert.assertNotNull(classToTest.generate());
		
		verification();
	}

}
