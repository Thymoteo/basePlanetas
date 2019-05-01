package br.com.mdsistemas.basePlanetas.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mdsistemas.basePlanetas.api.dto.PlanetaDTO;
import br.com.mdsistemas.basePlanetas.api.entity.ClassePlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.entity.QuadranteEntity;
import br.com.mdsistemas.basePlanetas.api.entity.TipoAtmosferaEntity;
import br.com.mdsistemas.basePlanetas.api.exception.PlanetaNaoEncontradoException;
import br.com.mdsistemas.basePlanetas.api.repository.ClassePlanetaRepository;
import br.com.mdsistemas.basePlanetas.api.repository.PlanetaRepository;
import br.com.mdsistemas.basePlanetas.api.repository.QuadranteEstelarRepository;
import br.com.mdsistemas.basePlanetas.api.repository.TipoAtmosferaRepository;
import br.com.mdsistemas.basePlanetas.api.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {
	
	@Autowired 
	private PlanetaRepository planetaRepository;
	
	@Autowired 
	private QuadranteEstelarRepository quadranteEstelarRepository;
	
	@Autowired 
	private ClassePlanetaRepository classePlanetaRepository;
	
	@Autowired
	private TipoAtmosferaRepository tipoAtmosferaRepository;
	
	@Override
	public List<PlanetaEntity> listarPlanetas() throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		Iterable<PlanetaEntity> iterable = planetaRepository.findAll();
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
	}

	@Override
	public List<PlanetaEntity> listarPlanetasHabitaveis() throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		Iterable<PlanetaEntity> iterable = planetaRepository.findByPlanetaColonizado(true);
		
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
	}

	@Override
	public List<PlanetaEntity> listarPlanetasPorQuadrante(int codigo) throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Optional<QuadranteEntity> optional_quadrante = quadranteEstelarRepository.findById(codigo);		
		Iterable<PlanetaEntity> iterable = planetaRepository.findByQuadrante(optional_quadrante.get());
		
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
	}

	@Override
	public List<PlanetaEntity> listarPlanetasPorClasse(String codigo) throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Optional<ClassePlanetaEntity> optional_classe = classePlanetaRepository.findById(codigo);		
		Iterable<PlanetaEntity> iterable = planetaRepository.findByClassePlaneta(optional_classe.get());
		
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;

		
	}

	@Override
	public List<PlanetaEntity> listarPlanetasPorTipoAtmosfera(int codigo) throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Optional<TipoAtmosferaEntity> optional_atmosfera = tipoAtmosferaRepository.findById(codigo);
		Iterable<PlanetaEntity> iterable = planetaRepository.findByTipoAtmosfera(optional_atmosfera.get());
		
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
		
	}

	@Override
	public List<PlanetaEntity> listarPlanetasPorMassa(int massa) throws Exception {
			
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Iterable<PlanetaEntity> iterable = planetaRepository.findByMassaGreaterThan(massa);
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
		
	}

	@Override
	public List<PlanetaEntity> listarPlanetaDiametroEntre(int diametro_inicial, int diametro_final) throws Exception {
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Iterable<PlanetaEntity> iterable = planetaRepository.findByDiametroBetween(diametro_inicial, diametro_final);
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
		
	}

	@Override
	public List<PlanetaEntity> listarPlanetasDescobertosEntre(Date data_inicial, Date data_final) throws Exception {
		
		if(data_final.compareTo(data_inicial) < 0) {
			throw new Exception("Data Final não pode ser menor que a Data Incial.");
		} 
		
		List<PlanetaEntity> planetas = new ArrayList<PlanetaEntity>();
		
		Iterable<PlanetaEntity> iterable = planetaRepository.findByDataDescobrimentoBetween(data_inicial, data_final);
		iterable.iterator().forEachRemaining(planetas::add);
		
		return planetas;
		
	}

	@Override
	public int salvarPlaneta(PlanetaEntity planetaEntity) throws Exception {

		Date dataNula = null;
		
		if (planetaEntity.getIdPlaneta() != 0 ) {
			Optional<PlanetaEntity> opt = planetaRepository.findById(planetaEntity.getIdPlaneta());
			if ( ! opt.isPresent()) throw new PlanetaNaoEncontradoException("Planeta não encontrado.");
		}
		
		if(planetaEntity.getNome().isEmpty()) throw new Exception("Nome do planeta é obrigatório.");
		else {
			Iterable<PlanetaEntity> iterableNome = planetaRepository.findByNomeIgnoreCase(planetaEntity.getNome());
			
			List<PlanetaEntity> planetaEncontrado = new ArrayList<PlanetaEntity>(); 
			iterableNome.iterator().forEachRemaining(planetaEncontrado::add);
			
			if(iterableNome.iterator().hasNext() && planetaEncontrado.get(0).getIdPlaneta() != planetaEntity.getIdPlaneta()) 
				throw new Exception("Já existe uma planeta com este nome.");
		}
		if(planetaEntity.getMassa() <= 0) throw new Exception("A massa do planeta é obrigatória.");
		if(planetaEntity.getDiametro() <= 0) throw new Exception("O diametro do planeta é obrigatório.");
		if(planetaEntity.getDataDescobrimento() == dataNula) throw new Exception("A data de descobrimento do planeta é obrigatória.");
		if(planetaEntity.getClassePlaneta().getIdClasse().isEmpty()) throw new Exception("A classe do planeta é obrigatória.");
		if(planetaEntity.getTipoAtmosfera().getIdTipoAtmosfera() <= 0) throw new Exception("O tipo de atmosfera do planeta é obrigatório.");
		if(planetaEntity.getQuadrante().getIdQuadrante() <= 0) throw new Exception("O quadrante do planeta é obrigatório.");
		
		PlanetaEntity planetaSalvo = planetaRepository.save(planetaEntity);
		
		return planetaSalvo.getIdPlaneta();
		
	}

	@Override
	public void excluirPlaneta(int codigo) throws Exception {
		
		Optional<PlanetaEntity> optional_planeta = planetaRepository.findById(codigo);
		
		if(!optional_planeta.isPresent()) throw new PlanetaNaoEncontradoException("Planeta não encontrado.");
		
		planetaRepository.delete(optional_planeta.get());
		
	}
	

}
