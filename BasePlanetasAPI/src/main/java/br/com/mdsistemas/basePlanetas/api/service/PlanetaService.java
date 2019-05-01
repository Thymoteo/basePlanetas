package br.com.mdsistemas.basePlanetas.api.service;

import java.util.Date;
import java.util.List;

import br.com.mdsistemas.basePlanetas.api.dto.PlanetaDTO;
import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;

public interface PlanetaService {

	public List<PlanetaEntity>listarPlanetas() throws Exception;
	
	public List<PlanetaEntity>listarPlanetasHabitaveis() throws Exception;
	
	public List<PlanetaEntity>listarPlanetasPorQuadrante(int codigo) throws Exception;
	
	public List<PlanetaEntity>listarPlanetasPorClasse(String codigo) throws Exception;
	
	public List<PlanetaEntity>listarPlanetasPorTipoAtmosfera(int codigo) throws Exception;
	
	public List<PlanetaEntity>listarPlanetasPorMassa(int massa) throws Exception;
	
	public List<PlanetaEntity>listarPlanetaDiametroEntre(int diametro_inicial, int diametro_final) throws Exception;

	public List<PlanetaEntity>listarPlanetasDescobertosEntre(Date data_inicial, Date data_final) throws Exception;

	public int salvarPlaneta (PlanetaEntity planetaEntity) throws Exception;
	
	public void excluirPlaneta (int codigo) throws Exception;
	
}
