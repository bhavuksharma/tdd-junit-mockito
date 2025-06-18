package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {
	
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		// Specific Runner
		// Initialize UtilityClass.class
		// Mock
		
		// Given - setup		
		List<Integer> stats = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		// mocking class with static method
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(6)).thenReturn(130);
				
		// When - actual method call
		int result = systemUnderTest.methodCallingAStaticMethod();
		
		// Then - asserts
		assertEquals(130, result);
		
		//verify call in two steps
		PowerMockito.verifyStatic(UtilityClass.class);
		UtilityClass.staticMethod(6);
	}

}
