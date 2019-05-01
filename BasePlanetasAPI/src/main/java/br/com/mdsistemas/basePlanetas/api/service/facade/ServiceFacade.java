package br.com.mdsistemas.basePlanetas.api.service.facade;

import java.util.Date;
import java.util.List;

import br.com.mdsistemas.basePlanetas.api.dto.PlanetaDTO;

public interface ServiceFacade {

	public List<PlanetaDTO>listarPlanetasDTO() throws Exception;
	
	public List<PlanetaDTO>listaPlanetasHabitaveis() throws Exception;
	
	public List<PlanetaDTO>listaPlanetasPorQuadrante(int codigo) throws Exception;
	
	public List<PlanetaDTO>listaPlanetasPorClasse(String codigo) throws Exception;
	
	public List<PlanetaDTO>listaPlanetasPorTipoAtmosfera(int codigo) throws Exception;
	
	public List<PlanetaDTO>listaPlanetasPorMassa(int massa) throws Exception;
	
	public List<PlanetaDTO>listarPlanetaDiametroEntre(int diametro_inicial, int diametro_final) throws Exception;

	public List<PlanetaDTO>listaPlanetasDescobertosEntre(Date data_inicial, Date data_final) throws Exception;

	public int salvarPlaneta (PlanetaDTO planetaDTO) throws Exception;
	
	public void excluirPlaneta (int codigo) throws Exception;
}
