package project00;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;


import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.daos.BeerDao;
import com.revature.services.BeerServices;




@ExtendWith(MockitoExtension.class)

public class BeerServicesTest {
	private static BeerDao mockDoa;
	private static BeerServices bs;
	

//	mockDoa = mock(BeerServices.class);
//	bs = BeerServices(mockDoa);
//	
	
	@Test
	public void testGetAll() {
		assertEquals("Beers/);

	}
	

}
