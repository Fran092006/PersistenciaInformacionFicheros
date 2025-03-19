package dtos;

import java.time.LocalDate;

import controladores.Inicio;

public class PropietarioDto {

	long id;

	String dni = "AAAAA";
	
	LocalDate fchCompra = LocalDate.MAX;
	
	String matricula = "AAAAA";
	
	boolean esHistorico = false;

	
	
	
	public PropietarioDto(long id, String dni, LocalDate fchCompra, String matricula, boolean esHistorico) {
		super();
		this.id = id;
		this.dni = dni;
		this.fchCompra = fchCompra;
		this.matricula = matricula;
		this.esHistorico = esHistorico;
	}
	
	public PropietarioDto() {
		super();
	}
	
	
	
	
	public long getId() {
		return id;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFchCompra() {
		return fchCompra;
	}

	public void setFchCompra(LocalDate fchCompra) {
		this.fchCompra = fchCompra;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isEsHistorico() {
		return esHistorico;
	}

	public void setEsHistorico(boolean esHistorico) {
		this.esHistorico = esHistorico;
	}
	
	
	
	@Override
	public String toString() {
		return "Nuevo propietario: " + Inicio.ultimoId + " - ".concat(dni);
	}
}
