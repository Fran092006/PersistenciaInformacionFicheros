package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.PropietarioDto;
import dtos.VehiculoDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;

public class Inicio {
	
	public static Scanner scanner = new Scanner(System.in);
	public static long ultimoId = 0;
	public static List<VehiculoDto> vehiculos = new ArrayList<>();
	public static List<PropietarioDto> propietarios = new ArrayList<>();
	public static List<String> lineasCsv = new ArrayList<>();

	public static void main(String[] args) {
		
		
		
		MenuInterfaz menuInterfaz = new MenuImplementacion();
		OperativaInterfaz operativaInterfaz = new OperativaImplementacion();
		
		operativaInterfaz.cargaInicialFichero();
		
		menuInterfaz.mostrarMenuYRecogerOpcion();
		
 	}

}
