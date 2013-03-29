package com.stefan.order.mvc;

import static com.stefan.order.mvc.HomeController.DEFAULT_SPITTLES_PER_PAGE;

import static java.util.Arrays.*;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import com.stefan.spitter.SpitterService;
import com.stefan.spittle.Spittle;

public class HomeControllerTest {
	@Test
	public void shouldDisplayRecentSpittles(){
		List<Spittle> expectedSpittles = 
				asList(new Spittle(), new Spittle(), new Spittle());
		
		SpitterService spitterService = mock(SpitterService.class);
		
		when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).
		thenReturn(expectedSpittles);
		
		HomeController controller = new HomeController(spitterService);
		
		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);
		
		assertEquals("home", viewName);
		assertSame(expectedSpittles, model.get("spittles"));
		verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
	}
}
