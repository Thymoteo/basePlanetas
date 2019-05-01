package br.com.mdsistemas.basePlanetas.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_atmosfera database table.
 * 
 */
@Entity
@Table(name="tipo_atmosfera")
@NamedQuery(name="TipoAtmosfera.findAll", query="SELECT t FROM TipoAtmosferaEntity t")
public class TipoAtmosferaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_atmosfera")
	private int idTipoAtmosfera;

	private String descricao;

	//bi-directional many-to-one association to Planeta
	@OneToMany(mappedBy="tipoAtmosfera")
	private List<PlanetaEntity> planetas;

	public TipoAtmosferaEntity() {
	}

	public int getIdTipoAtmosfera() {
		return this.idTipoAtmosfera;
	}

	public void setIdTipoAtmosfera(int idTipoAtmosfera) {
		this.idTipoAtmosfera = idTipoAtmosfera;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PlanetaEntity> getPlanetas() {
		return this.planetas;
	}

	public void setPlanetas(List<PlanetaEntity> planetas) {
		this.planetas = planetas;
	}

	public PlanetaEntity addPlaneta(PlanetaEntity planeta) {
		getPlanetas().add(planeta);
		planeta.setTipoAtmosfera(this);

		return planeta;
	}

	public PlanetaEntity removePlaneta(PlanetaEntity planeta) {
		getPlanetas().remove(planeta);
		planeta.setTipoAtmosfera(null);

		return planeta;
	}

}