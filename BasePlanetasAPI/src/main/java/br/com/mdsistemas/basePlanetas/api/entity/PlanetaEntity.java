package br.com.mdsistemas.basePlanetas.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the planeta database table.
 * 
 */
@Entity
@Table(name="planeta")
@NamedQuery(name="Planeta.findAll", query="SELECT p FROM PlanetaEntity p")
public class PlanetaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_planeta")
	private int idPlaneta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_descobrimento")
	private Date dataDescobrimento;

	private int diametro;

	private int massa;

	private String nome;

	@Column(name="planeta_colonizado")
	private boolean planetaColonizado;

	//bi-directional many-to-one association to ClassePlaneta
	@ManyToOne
	@JoinColumn(name="id_classe")
	private ClassePlanetaEntity classePlaneta;

	//bi-directional many-to-one association to QuadranteEstelar
	@ManyToOne
	@JoinColumn(name="id_quadrante")
	private QuadranteEntity quadrante;

	//bi-directional many-to-one association to TipoAtmosfera
	@ManyToOne
	@JoinColumn(name="id_tipo_atmosfera")
	private TipoAtmosferaEntity tipoAtmosfera;

	public PlanetaEntity() {
	}

	public int getIdPlaneta() {
		return this.idPlaneta;
	}

	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public Date getDataDescobrimento() {
		return this.dataDescobrimento;
	}

	public void setDataDescobrimento(Date dataDescobrimento) {
		this.dataDescobrimento = dataDescobrimento;
	}

	public int getDiametro() {
		return this.diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public int getMassa() {
		return this.massa;
	}

	public void setMassa(int massa) {
		this.massa = massa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getPlanetaColonizado() {
		return this.planetaColonizado;
	}

	public void setPlanetaColonizado(boolean planetaColonizado) {
		this.planetaColonizado = planetaColonizado;
	}

	public ClassePlanetaEntity getClassePlaneta() {
		return this.classePlaneta;
	}

	public void setClassePlaneta(ClassePlanetaEntity classePlaneta) {
		this.classePlaneta = classePlaneta;
	}

	public QuadranteEntity getQuadrante() {
		return this.quadrante;
	}

	public void setQuadrante(QuadranteEntity quadrante) {
		this.quadrante = quadrante;
	}

	public TipoAtmosferaEntity getTipoAtmosfera() {
		return this.tipoAtmosfera;
	}

	public void setTipoAtmosfera(TipoAtmosferaEntity tipoAtmosfera) {
		this.tipoAtmosfera = tipoAtmosfera;
	}

}