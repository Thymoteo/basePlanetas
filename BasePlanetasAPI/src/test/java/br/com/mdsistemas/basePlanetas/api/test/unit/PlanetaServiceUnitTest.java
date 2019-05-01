package br.com.mdsistemas.basePlanetas.api.test.unit;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.repository.PlanetaRepository;
import br.com.mdsistemas.basePlanetas.api.service.PlanetaService;
import br.com.mdsistemas.basePlanetas.api.service.impl.PlanetaServiceImpl;

@RunWith(SpringRunner.class)
public class PlanetaServiceUnitTest {
	
	/** (1) */
	//@MockBean
	//private PlanetaService planetaService;

	/** (2) */
	@Autowired
	private PlanetaService planetaService;
	
	/** (2) */
	@MockBean
	private PlanetaRepository repository;
	
	/** (2) */
	@TestConfiguration
	static class PlanetaServiceUnitTestContextConfiguration {
		@Bean
		public PlanetaService planetaService( ) {
			return new PlanetaServiceImpl();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		PlanetaEntity planeta1 = new PlanetaEntity();
		
		planeta1.setNome("Terra");
		planetas.add(planeta1);
		
		/** (1) */
		//when(planetaService.listarPlanetas()).thenReturn(planetas);
		
		/** (2) */
		Iterable<PlanetaEntity> iterable = (Iterable<PlanetaEntity>)planetas;
		when(repository.findAll()).thenReturn(iterable);
	}
	
	@Test
	public void obterTodosSucesosTeste() throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetas();
		Assert.assertTrue(planetas.size() == 0);
		
	}
	
}
