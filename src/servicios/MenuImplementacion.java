package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {

	@Override
	public void mostrarMenuYRecogerOpcion() {
		
		boolean esCerrado = false;
		OperativaInterfaz operativaInterfaz = new OperativaImplementacion();
		
		do {
		System.out.println("==========MENÚ==========");
		System.out.println("1. Cerrar aplicación");
		System.out.println("2. Números históricos");
		System.out.println("3. Alta nuevo propietario");
		System.out.println("========================");
		System.out.println("Eliga una opción: ");
		byte opcionUsuario = Inicio.scanner.nextByte();
		
		switch (opcionUsuario) {
		case 1: {
			
			esCerrado = true;
			System.out.println("Cerrando la aplicación...");
			break;
		}
		case 2: {
			
			operativaInterfaz.comprobarHistorico();
			break;
			
		}
		case 3: {
			operativaInterfaz.altaNuevoPropietario();
			break;
			
		}
		default:
			
		}
		}while(!esCerrado);	
	}

}
