package br.com.mdsistemas.basePlanetas.api.service.facade.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mdsistemas.basePlanetas.api.dto.PlanetaDTO;
import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.service.PlanetaService;
import br.com.mdsistemas.basePlanetas.api.service.facade.ServiceFacade;

@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceFacadeImpl implements ServiceFacade {

	@Autowired
	private PlanetaService planetaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private PlanetaDTO convertToDto(PlanetaEntity planetaEntity) {
		PlanetaDTO planetaDTO = modelMapper.map(planetaEntity, PlanetaDTO.class);
	    return planetaDTO;
	}

	private PlanetaEntity convertToEntity(PlanetaDTO planetaDTO) {
		PlanetaEntity planetaEntity = modelMapper.map(planetaDTO, PlanetaEntity.class);
	    return planetaEntity;
	}
	
	@Override
	public List<PlanetaDTO> listarPlanetasDTO() throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetas();
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity) )
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasHabitaveis() throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasHabitaveis();
	
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasPorQuadrante(int codigo) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasPorQuadrante(codigo);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasPorClasse(String codigo) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasPorClasse(codigo);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasPorTipoAtmosfera(int codigo) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasPorTipoAtmosfera(codigo);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasPorMassa(int massa) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasPorMassa(massa);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listarPlanetaDiametroEntre(int diametro_inicial, int diametro_final) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetaDiametroEntre(diametro_inicial, diametro_final);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<PlanetaDTO> listaPlanetasDescobertosEntre(Date data_inicial, Date data_final) throws Exception {
		
		List<PlanetaEntity> planetas = planetaService.listarPlanetasDescobertosEntre(data_inicial, data_final);
		
		return planetas.stream()
				.map(planetaEntity -> convertToDto(planetaEntity))
				.collect(Collectors.toList());
		
	}

	@Override
	public int salvarPlaneta(PlanetaDTO planetaDTO) throws Exception {
		
		PlanetaEntity planetaEntity = this.convertToEntity(planetaDTO);
		
		return planetaService.salvarPlaneta(planetaEntity); 
	}

	@Override
	public void excluirPlaneta(int codigo) throws Exception {
		planetaService.excluirPlaneta(codigo);
	}

}
