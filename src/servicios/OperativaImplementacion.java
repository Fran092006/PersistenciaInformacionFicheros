package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import controladores.Inicio;
import dtos.PropietarioDto;
import dtos.VehiculoDto;

public class OperativaImplementacion implements OperativaInterfaz {

	@Override
	public void altaNuevoPropietario() {

		PropietarioDto nuevoPropietario = new PropietarioDto();

		String dni;
		boolean dniValidado = false;

		do {
			System.out.println("Introduzca su dni: ");
			dni = Inicio.scanner.next();

			String dniLetra = validarDni(dni);

			if (dni.substring(8).equalsIgnoreCase(dniLetra) && dni.length() == 9) {

				System.out.println("El dni es correcto.");
				dniValidado = true;
			} else {
				System.out.println("El dni no es correcto. Inténtelo de nuevo.");
			}

		} while (!dniValidado);

		nuevoPropietario.setDni(dni);

		Inicio.ultimoId++;

		System.out.println(nuevoPropietario.toString());
	}

	public String validarDni(String dni) {

		String[] letrasDni = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };

		String numeroDni = dni.substring(0, 8);
		int resto = Integer.parseInt(numeroDni) % 23;
		String letraDni = letrasDni[resto];

		return letraDni;
	}

	@Override
	public void comprobarHistorico() {

		int totalHistoricos = 0;

		for (VehiculoDto auxiliar : Inicio.vehiculos) {

			LocalDate fecha = auxiliar.getFchMatriculacion();

			int edadCoche = LocalDate.now().getYear() - fecha.getYear();

			if (edadCoche >= 25) {

				for (PropietarioDto auxiliar2 : Inicio.propietarios) {
					
					if(auxiliar.getMatricula().equalsIgnoreCase(auxiliar2.getMatricula())) {
						
						auxiliar2.setEsHistorico(true);
						totalHistoricos++;
						break;
					}
				}
				
			}

		}

		System.out.println("N.Históricos:" + totalHistoricos);

	}

	@Override
	public void cargaInicialFichero() {
		Path path = Paths.get("datosIniciales.txt");
		boolean primeraLinea = true;

		try {
			
			Files.write(path, "matricula:fchMatriculacion:dni:fchCompra".getBytes());
			Files.write(path, "\n1234ATT:12-12-2019:12345678A:12-12-2019\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path, "9876WWW:10-11-2021:23456789P:21-12-2023\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path, "4567UOP:20-10-1998:98765432R:20-10-1999\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path, "4567UPO:20-10-1996:34567891I:20-10-2003".getBytes(), StandardOpenOption.APPEND);
			
			Inicio.lineasCsv.addAll(Files.readAllLines(path));
		} catch (IOException e) {

			System.out.println("Se ha producido un error al escribir en el archivo.");
		}

		for (String auxiliar : Inicio.lineasCsv) {

			if (primeraLinea) {

				primeraLinea = false;
				continue;
			}

			Inicio.ultimoId++;

			VehiculoDto nuevoVehiculo = new VehiculoDto();
			PropietarioDto nuevoPropietario = new PropietarioDto();

			String[] camposDto = auxiliar.split(":");

			String[] fechaDividad = camposDto[1].split("-");

			int dia = Integer.parseInt(fechaDividad[0]);
			int mes = Integer.parseInt(fechaDividad[1]);
			int anyo = Integer.parseInt(fechaDividad[2]);

			LocalDate fechaMatriculacion = LocalDate.of(anyo, mes, dia);
			nuevoVehiculo.setFchMatriculacion(fechaMatriculacion);
			nuevoVehiculo.setMatricula(camposDto[0]);

			nuevoPropietario.setDni(camposDto[2]);

			String[] fechaPartida = camposDto[3].split("-");

			int diaCompra = Integer.parseInt(fechaPartida[0]);
			int mesCompra = Integer.parseInt(fechaPartida[1]);
			int anyoCompra = Integer.parseInt(fechaPartida[2]);

			LocalDate fechaCompra = LocalDate.of(anyoCompra, mesCompra, diaCompra);
			nuevoPropietario.setFchCompra(fechaCompra);
			nuevoPropietario.setMatricula(camposDto[0]);

			Inicio.vehiculos.add(nuevoVehiculo);
			Inicio.propietarios.add(nuevoPropietario);

		}

	}

}
