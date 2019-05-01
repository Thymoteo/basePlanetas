package br.com.mdsistemas.basePlanetas.api.test.unit;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.repository.PlanetaRepository;

import org.junit.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetaRepositoryUnitTest {

	@SuppressWarnings("unused")
	@Autowired
    private TestEntityManager entityManager;

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Test
	public void listaTodosSucessoTest() {
	
		//cria planetas
		PlanetaEntity planeta1 = new PlanetaEntity();
		PlanetaEntity planeta2 = new PlanetaEntity();
		
		planeta1.setNome("Terra");
		planeta2.setNome("Marte");
		
		planetaRepository.save(planeta1);
		planetaRepository.save(planeta2);
		
		Iterable<PlanetaEntity> iterable = planetaRepository.findAll();
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		iterable.iterator().forEachRemaining(planetas::add);
		
		Assert.assertTrue(planetas.size() == 2);
		Assert.assertTrue("Terra".equals(planetas.get(0).getNome()));
		Assert.assertTrue("Marte".equals(planetas.get(1).getNome()));
	}
	
	@Test
	public void listaTodosErroTest() {
		
		//cria planetas
		PlanetaEntity planeta1 = new PlanetaEntity();
		PlanetaEntity planeta2 = new PlanetaEntity();
		
		planeta1.setNome("Terra");
		planeta2.setNome("Marte");
		
		planetaRepository.save(planeta1);
		planetaRepository.save(planeta2);
		
		Iterable<PlanetaEntity> iterable = planetaRepository.findAll();
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		iterable.iterator().forEachRemaining(planetas::add);
		
		Assert.assertTrue(planetas.size() == 2);
		Assert.assertTrue("Plutao".equals(planetas.get(0).getNome()));
		Assert.assertFalse("Jupiter".equals(planetas.get(1).getNome()));
	}
	
}
