package br.com.mdsistemas.basePlanetas.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quadrante_estelar database table.
 * 
 */
@Entity
@Table(name="quadrante_estelar")
@NamedQuery(name="QuadranteEstelar.findAll", query="SELECT q FROM QuadranteEntity q")
public class QuadranteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_quadrante")
	private int idQuadrante;
 
	private String descricao;

	//bi-directional many-to-one association to Planeta
	@OneToMany(mappedBy="quadrante")
	private List<PlanetaEntity> planetas;

	public QuadranteEntity() {
	}

	public int getIdQuadrante() {
		return this.idQuadrante;
	}

	public void setIdQuadrante(int idQuadrante) {
		this.idQuadrante = idQuadrante;
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
		planeta.setQuadrante(this);

		return planeta;
	}

	public PlanetaEntity removePlaneta(PlanetaEntity planeta) {
		getPlanetas().remove(planeta);
		planeta.setQuadrante(null);

		return planeta;
	}

}