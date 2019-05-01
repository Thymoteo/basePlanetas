package br.com.mdsistemas.basePlanetas.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.mdsistemas.basePlanetas.api.entity.ClassePlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.entity.PlanetaEntity;
import br.com.mdsistemas.basePlanetas.api.entity.QuadranteEntity;
import br.com.mdsistemas.basePlanetas.api.entity.TipoAtmosferaEntity;


public interface PlanetaRepository extends CrudRepository<PlanetaEntity, Integer> {

	public List<PlanetaEntity> findByPlanetaColonizado(boolean planetaColonizado);
	
	public List<PlanetaEntity> findByQuadrante(QuadranteEntity quadrante);
	
	public List<PlanetaEntity> findByClassePlaneta(ClassePlanetaEntity classePlaneta);
	
	public List<PlanetaEntity> findByTipoAtmosfera (TipoAtmosferaEntity tipoAtmosfera);
	
	public List<PlanetaEntity> findByMassaGreaterThan (int massa);
	
	public List<PlanetaEntity> findByDataDescobrimentoBetween (Date data_inicial, Date data_final);
	
	public List<PlanetaEntity> findByDiametroBetween (int diametro_inicial, int diametro_final);
	
	public List<PlanetaEntity> findByNome(String nome);
	
	public List<PlanetaEntity> findByNomeIgnoreCase(String nome);
}
