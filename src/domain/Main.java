package domain;

import java.util.Scanner;

public class Main implements IPrintPantalla {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int op=0;
		String entrada;
		boolean salir = false;
		Contenedor contenedor = new Contenedor();
		
		do {
			System.out.println(" Seleccione una opción del menú para continuar");
			System.out.println("------------- MENÚ ---------------");
			System.out
					.println(" | 1.* Crear Cliente            |\n" +
							 " | 2.* Crear Profesional        |\n" + 
							 " | 3.* Crear Administrativo     |\n" +
							 " | 4.* Crear Capacitación       |\n" + 
							 " | 5.* Eliminar Usuario         |\n" + 
							 " | 6.* Listar Usuarios          |\n" +
							 " | 7.* Listar Usuarios por tipo |\n" + 
							 " | 8.* Listar Capacitaciones    |\n" + 
							 " | 9.* Salir                    |");

			System.out.println("----------------------------------");
			System.out.print(":");
			//Control de error al transformar de string a int
			entrada = scanner.nextLine();
			try {
				op = Integer.valueOf(entrada);
			} catch (Exception e) {
				System.out.println("** Ingresa solo numeros **");
				op=11;
			}
			switch (op) {
			case 1:
				System.out.println("*******************************************");
				System.out.println("Ingrese los datos del nuevo Cliente");
				contenedor.almacenarCliente(scanner);
				System.out.println("Cliente creado con éxito");
				break;
			case 2:
				System.out.println("*******************************************");
				System.out.println("Ingrese los datos del nuevo Profesional");
				contenedor.almacenarProfesional(scanner);
				System.out.println("Profesional creado con éxito");
				break;
			case 3:
				System.out.println("*******************************************");
				System.out.println("Ingrese los datos del nuevo Administrativo");
				contenedor.almacenarAdministrativo(scanner);
				System.out.println("Administrativo creado con éxito");
				break;
			case 4:
				System.out.println("*******************************************");
				System.out.println("Ingrese los datos de la Capacitación");
				contenedor.almacenarCapacitacion(scanner);
				System.out.println("Capacitacion agregada con éxito");
				break;
			case 5:
				System.out.println("*******************************************");
				contenedor.eliminarUsuario(scanner);
				break;
			case 6:
				contenedor.listarUsuarios();
				break;
			case 7:
				System.out.println("-Seleccionaste Listar Usuarios por tipo");
				System.out.print("Escribe el tipo de usuario (Cliente, Profesional o Administrativo): ");
				scanner.nextLine(); //Para limpiar el buffer del nextInt
				String tipo = scanner.nextLine();
				contenedor.listarusuariosPorTipo(tipo);
				break;
			case 8:
				System.out.println("-Seleccionaste Listar Capacitaciones");
				contenedor.listarCapacitaciones();
				break;
			case 9:
				System.out.println("******** Ha seleccionado salir");
				salir = true;
				break;
			default:
				System.out.println("******* Ingrese una opción válida");
				break;
			}
		} while (!salir);
	}

	@Override
	public void noSeEncontroUsuario() {
		System.out.println("La acción de borrado no se concretó. \n No se encontro usuario ni rut vinculado");
	}

}
