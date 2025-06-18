package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;


@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MokingConstructorTest {
	
	// PrepareForTest => SystemUnderTest.class
	//override the constructor
	
	@Mock
	ArrayList<Integer> arrayList;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void badTest() throws Exception {
		
		// Given - setup
		// stubbing constructor call
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(arrayList);
		//stubbing the method call
		when(arrayList.size()).thenReturn(4);
						
		// When - actual method call
		int result = systemUnderTest.methodUsingAnArrayListConstructor();
		
		// Then - asserts
		assertEquals(4, result);
	}

}
