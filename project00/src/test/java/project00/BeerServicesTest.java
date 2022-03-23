package project00;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Beer;
import com.revature.services.BeerServices;

@ExtendWith(MockitoExtension.class)
public class BeerServicesTest {

	private static List<Beer> beers;
	private static BeerDao mockDao;
	private static BeerServices bs;

	@BeforeAll
	public static void setup() {
		mockDao = mock(BeerDao.class);
		bs = new BeerServices(mockDao);
		beers = new ArrayList<>();

		beers.add(new Beer(1, "Beer 1", 0.00, "Type 1"));
		beers.add(new Beer(2, "Beer 2", 1.11, "Type 2"));
		beers.add(new Beer(3, "Beer 3", 2.22, "Type 3"));
		beers.add(new Beer(4, "Beer 4", 3.33, "Type 4"));
	}

	@Test
	public void testGetAll() {
		when(mockDao.getAllBeers()).thenReturn(beers);
		System.out.println("Test all" + beers);
		System.out.println(bs.getAll());		
		assertDoesNotThrow(() -> {
			assertEquals(beers, bs.getAll());

		});

	}

	@Test
	public void testGetBeerbyId() {
		when(mockDao.getBeerById(2)).thenReturn(beers.get(1));
		assertDoesNotThrow(() -> {
			assertEquals(beers.get(1), bs.getById(2));
		});
	}

	@Test
	public void testGetBeerbyName() {
		when(mockDao.getBeerByName("Beer 3")).thenReturn(beers.get(2));
		System.out.println(beers.get(2));
		System.out.println(mockDao.getBeerByName("Beer 3"));
		assertDoesNotThrow(() -> {
			assertEquals(beers.get(2), bs.getByName("Beer 3"));
		});
	}

	@Test
	public void testGetBeerbyNameFail() {
		when(mockDao.getBeerByName("Beer 5")).thenReturn(null);
		System.out.println("null");
		System.out.println(mockDao.getBeerByName("Beer 5"));
		assertThrows(ItemNotFoundException.class, () -> {
				bs.getByName(null);
		});
	}

//	@Test
//	public void testGetSpecificBeers() {  
//		when(mockDao.getSpecificBeers(1.11, "Type 2")).thenReturn(null);
//		System.out.println("Test Specific Beer" + mockDao.getSpecificBeers(1.11, "Type 2"));
//		//System.out.println(mockDao.getBeerByName("Beer 5"));
//		assertDoesNotThrow(() -> {
//			assertEquals(beers.get(1), bs.getSpecific(1.11, "Type 2"));
//		});
//	}

}
