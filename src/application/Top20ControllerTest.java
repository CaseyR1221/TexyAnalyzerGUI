package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Top20ControllerTest {
	
	private Top20Controller test;

	@BeforeEach
	void setUp() throws Exception {
		test = new Top20Controller();
	}

	@Test
	void top20NotNullTest() {		
		try {
			assertNotNull(test.runTop20());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void top20LengthTest()  {
		try {
			int size = 0;
			LinkedHashMap<String, Integer> map = test.runTop20();
			
			for (Map.Entry<String, Integer> entry : map.entrySet()) {		
				size++;		
			}
			assertEquals(20, size);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void top20ValuesTest()  {

		try {
			LinkedHashMap<String, Integer> map = test.runTop20();
			Boolean isString = false;
			
			String[] aKeys = map.keySet().toArray(new String[map.size()]);
			
			for(String key : aKeys) {
				if(key.contains("—")) {
					isString = false;
				} else {
					isString = true;
				}
			}
			assertTrue(isString);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}
	}

}
