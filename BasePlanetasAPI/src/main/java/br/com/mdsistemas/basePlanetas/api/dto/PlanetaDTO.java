package br.com.mdsistemas.basePlanetas.api.dto;

import java.util.Date;

public class PlanetaDTO {

	private int idPlaneta;
	private int massa;
	private int diametro;
	
	private String nome;
	
	private boolean planetaColonizado;
	
	private Date dataDescobrimento;
	
	private ClassePlanetaDTO classePlaneta;
	private TipoAtmosferaDTO tipoAtmosfera;
	private QuadranteDTO quadrante;
	
	public int getIdPlaneta() {
		return idPlaneta;
	}
	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	public int getMassa() {
		return massa;
	}
	public void setMassa(int massa) {
		this.massa = massa;
	}
	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isPlanetaColonizado() {
		return planetaColonizado;
	}
	public void setPlanetaColonizado(boolean planetaColonizado) {
		this.planetaColonizado = planetaColonizado;
	}
	public Date getDataDescobrimento() {
		return dataDescobrimento;
	}
	public void setDataDescobrimento(Date dataDescobrimento) {
		this.dataDescobrimento = dataDescobrimento;
	}
	public ClassePlanetaDTO getClassePlaneta() {
		return classePlaneta;
	}
	public void setClassePlaneta(ClassePlanetaDTO classePlaneta) {
		this.classePlaneta = classePlaneta;
	}
	public TipoAtmosferaDTO getTipoAtmosfera() {
		return tipoAtmosfera;
	}
	public void setTipoAtmosfera(TipoAtmosferaDTO tipoAtmosfera) {
		this.tipoAtmosfera = tipoAtmosfera;
	}
	public QuadranteDTO getQuadrante() {
		return quadrante;
	}
	public void setQuadrante(QuadranteDTO quadrante) {
		this.quadrante = quadrante;
	}
	
	
	
}
