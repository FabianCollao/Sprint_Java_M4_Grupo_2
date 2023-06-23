package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import domain.Contenedor;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contenedor contenedor = new Contenedor();
		int op = 0;
		
		boolean salir = false;
		DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			System.out.println("****** Menu ****** ");
			System.out.println("Seleccione una opción: ");
			System.out.println("1: Crear Cliente.");
			System.out.println("2: Crear Profesional.");
			System.out.println("3: Crear Administrativo.");
			System.out.println("4: Crear Capacitacion.");
			System.out.println("5: Eliminar Usuario.");
			System.out.println("6: Listar Usuarios.");
			System.out.println("7: Listar Usuarios por tipo.");
			System.out.println("8: Listar Capacitaciones.");
			System.out.println("9: Salir.");

			op = scanner.nextInt();
			switch (op) {

			case 4:
				Capacitacion capacitacion = new Capacitacion();
				System.out.println("Identificador");
				int identificador = scanner.nextInt();
				capacitacion.setIdentificador(identificador);
				
				System.out.println("Rut cliente");
				String rutCliente = scanner.nextLine();
				capacitacion.setRutCliente(rutCliente);
				
				System.out.println("Ingrese el día (Lunes, Martes, Miércoles, Jueves, Viernes)");
				String dia = scanner.nextLine();
				capacitacion.setDia(dia);
				
				System.out.println("Ingrese hora en formato HH:MM (hora desde 0 a\r\n"
						+ "23, minutos entre 0 y 59)");
				String hora = scanner.nextLine();
				capacitacion.setHora(hora);
				
				System.out.println("Ingrese el lugar (min 10 carácteres, max 50");
				String lugar = scanner.nextLine();
				capacitacion.setLugar(lugar);
				
				System.out.println("Ingrese la duración (max 70 carácteres)");
				String duracion = scanner.nextLine();
				capacitacion.setDuracion(duracion);
				
				System.out.println("Cantidad de Asistentes:");
				int cantAsistentes = scanner.nextInt();
				capacitacion.setCantidadAsistentes(cantAsistentes);// Crear metodo para pasar el String a int (Rut)
				contenedor.almacenarCapacitacion(capacitacion);
				break;
				
			case 8:
				contenedor.listarCapacitaciones();
				break;
			}
		} while (salir);
	}
}
