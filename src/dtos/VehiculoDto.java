package dtos;

import java.time.LocalDate;

public class VehiculoDto {

	long id;
	
	String matricula = "AAAAA";
	
	LocalDate fchMatriculacion = LocalDate.MAX;

	
	public long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getFchMatriculacion() {
		return fchMatriculacion;
	}

	public void setFchMatriculacion(LocalDate fchMatriculacion) {
		this.fchMatriculacion = fchMatriculacion;
	}
	
	
	@Override
	public String toString() {
		return "Nuevo vehículo: " + matricula;
	}
}
