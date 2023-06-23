package domain;

import java.time.LocalDate;
import java.util.Scanner;
import data.Administrativo;
import data.Capacitacion;
import data.Cliente;
import data.Profesional;
import data.SistemaSalud;
import data.Usuario;
/*
		 * Finalmente, cree la clase Principal, la que tendrá como objetivo 
		 * crear una instancia de la clase Contenedor, 
		 * lo que creará con ello las dos listas que considera esta clase. 
		 * Posterior a esto, deberá crear un menú principal con nueve opciones: 
		 * ocho para las acciones indicadas en el listado anterior, y una opción 
		 * para salir del programa. En caso de que se ingrese una opción incorrecta, 
		 * se debe pedir nuevamente. El programa solo terminará una vez que ingrese 
		 * la opción de salida.
 */
public class Main implements IPrintPantalla {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int op;
		boolean salir = false;
		Contenedor contenedor = new Contenedor();
		Usuario usuario;
		
		do {
			System.out.println("       ****** MENÚ ****** ");
			System.out.println(" Seleccione una opción del menú para continuar");
			System.out
					.println(" OP 1: Crear Cliente \n" + " OP 2: Crear Profesional \n" + " OP 3: Crear Administrativo\n"
							+ " OP 4: Crear Capacitación \n" + " OP 5: Eliminar Usuario \n" + " OP 6: Listar Usuarios\n"
							+ " OP 7: Listar Usuarios por tipo\n" + " OP 8: Listar Capacitaciones \n" + " OP 9: Salir");

			op = scanner.nextInt();
			switch (op) {
			case 1:
				System.out.println("Ingrese los datos del nuevo Cliente");
				contenedor.almacenarCliente();
				System.out.println("Cliente creado con éxito");
				break;
			case 2:
				Profesional profesional = new Profesional();// Solicitar e ingresar los datos a profesional
				contenedor.almacenarProfesional(profesional);
				break;
			case 3:
				Administrativo admin = new Administrativo();// Solicitar e ingresar los datos a profesional
				contenedor.almacenarAdministrativo(admin);
				break;
			case 4:
				Capacitacion cap = new Capacitacion();// Crear metodo para pasar el String a int (Rut)
				contenedor.almacenarCapacitacion(cap);
				break;
			case 5:
				System.out.println("Ingrese el rut del usuario para su eliminación ");
				int rut = scanner.nextInt();
				contenedor.eliminarUsuario(rut);
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
				break;
			case 9:
				System.out.println("Ha seleccionado salir");
				salir = true;
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}
		} while (salir=true);
	}

	@Override
	public void noSeEncontroUsuario() {
		System.out.println("La acción de borrado no se concretó. \n No se encontro usuario ni rut vinculado");
	}
	
}
