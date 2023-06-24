package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.Administrativo;
import data.Capacitacion;
import data.Cliente;
import data.IAsesoria;
import data.Profesional;
import data.SistemaSalud;
import data.Usuario;
import utils.ValidarDatos;

/**
 * Clase que representa un contenedor de datos y funciones relacionadas con la
 * gestión de asesorías, capacitaciones y usuarios.
 */
public class Contenedor {
	public ArrayList<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;
	Usuario usuario;
	IPrintPantalla print;
	private ValidarDatos dato = new ValidarDatos();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Constructor de la clase Contenedor.
	 */
	public Contenedor() {
		asesorias = new ArrayList<IAsesoria>();
		capacitaciones = new ArrayList<Capacitacion>();
	}

	/**
	 * Almacena los datos de un cliente ingresados por el usuario. para luego añadir
	 * el cliente a una lista de instancias de {@link IAsesoria}.
	 * 
	 * @param input Scanner para la entrada de datos.
	 */
	public void almacenarCliente(Scanner input) {
		input.nextLine(); // Limpiando el buffer cache
		Cliente cliente = new Cliente();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Rut", "Nombres", "Apellidos",
				"Telefono", "AFP", "Sistema de Salud (Fonasa o Isapre)", "Direccion", "Comuna", "Edad" };
		String nombre = "", fechaNac = "", run = "", rut = "", nombres = "", apellidos = "", telefono = "", afp = "",
				sistemaSalud = "", direccion = "", comuna = "", edad = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					nombre = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(nombre, 10, 50)) {
						cliente.setNombre(nombre);
					}
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					if (salir = dato.validarFecha(fechaNac)) {
						cliente.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
					}
					break;
				case 2:
					run = input.nextLine().trim();
					if (salir = dato.validarRutRun(run, "run")) {
						cliente.setRun(Integer.valueOf(run));
					}
					break;
				case 3:
					rut = input.nextLine().trim();
					if (salir = dato.validarRutRun(rut, "rut")) {
						cliente.setRut(Integer.valueOf(rut));
					}
					break;
				case 4:
					nombres = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(nombres, 5, 30)) {
						cliente.setNombres(nombres);
					}
					break;
				case 5:
					apellidos = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(apellidos, 5, 30)) {
						cliente.setApellidos(apellidos);
					}
					break;
				case 6:
					telefono = input.nextLine().trim();
					try {
						if (salir = dato.esObligatorio(telefono)) {
							cliente.setTelefono(Integer.valueOf(telefono));
						}
					} catch (Exception e) {
						System.out.println("Ingresa solo números");
						salir = false;
					}
					break;
				case 7:
					afp = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(afp, 4, 30)) {
						cliente.setAfp(afp);
					}
					break;
				case 8:
					sistemaSalud = input.nextLine().trim();
					salir = dato.esObligatorio(sistemaSalud);
					if (sistemaSalud.toLowerCase().equals("fonasa")) {
						cliente.setSistemaSalud(SistemaSalud.Fonasa);
					} else if (sistemaSalud.toLowerCase().equals("isapre")) {
						cliente.setSistemaSalud(SistemaSalud.Isapre);
					} else {
						System.out.println("** Solo puede ser Fonasa o Isapre");
						salir = false;
					}
					break;
				case 9:
					direccion = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(direccion, 0, 70)) {
						cliente.setDireccion(direccion);
					}
					break;
				case 10:
					comuna = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(comuna, 0, 50)) {
						cliente.setComuna(comuna);
					}
					break;
				case 11:
					edad = input.nextLine().trim();
					if (salir = dato.validarEdad(edad, 0, 150)) {
						cliente.setEdad(Integer.valueOf(edad));
					}
					break;
				}
			} while (!salir);
		}
		asesorias.add(cliente);
	}

	/**
	 * Almacena los datos de un profesional ingresados por el usuario. para luego
	 * añadir el profesional a una lista de instancias de {@link IAsesoria}.
	 * 
	 * @param input Scanner para la entrada de datos.
	 */
	public void almacenarProfesional(Scanner input) {
		input.nextLine(); // Limpiando el buffer cache
		Profesional profesional = new Profesional();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Título", "Fecha de ingreso" };
		String nombre = "", fechaNac = "", run = "", titulo = "", fechaIngreso = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					nombre = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(nombre, 10, 50)) {
						profesional.setNombre(nombre);
					}
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					if (salir = dato.validarFecha(fechaNac)) {
						profesional.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
					}
					break;
				case 2:
					run = input.nextLine().trim();
					if (salir = dato.validarRutRun(run, "run")) {
						profesional.setRun(Integer.valueOf(run));
					}
					break;
				case 3:
					titulo = input.nextLine().trim();
					if (salir = dato.validarRangoCaracteres(titulo, 10, 50)) {
						profesional.setTitulo(titulo);
					}
					break;
				case 4:
					fechaIngreso = input.nextLine().trim();
					if (salir = dato.validarFecha(fechaIngreso)) {
						profesional.setFechaNacimiento(LocalDate.parse(fechaIngreso, formatter));
					}
					break;
				}
			} while (!salir);
		}
		asesorias.add(profesional);
	}

	/**
	 * Almacena los datos de un administrativo ingresados por el usuario. para luego
	 * añadir el administrativo a una lista de instancias de {@link IAsesoria}.
	 * 
	 * @param input Scanner para la entrada de datos.
	 */
	public void almacenarAdministrativo(Scanner input) {
		input.nextLine(); // Limpiando el buffer cache
		Administrativo admin = new Administrativo();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Área", "Experiencia previa" };
		String nombre = "", fechaNac = "", run = "", area = "", experienciaPrevia = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					nombre = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombre, 10, 50);
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					salir = dato.validarFecha(fechaNac);
					break;
				case 2:
					run = input.nextLine().trim();
					salir = dato.validarRutRun(run, "run");
					break;
				case 3:
					area = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(area, 5, 20);
					break;
				case 4:
					experienciaPrevia = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(experienciaPrevia, 20, 100);
					break;
				}
			} while (!salir);
		}
		admin.setNombre(nombre);
		admin.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
		admin.setRun(Integer.valueOf(run));
		admin.setArea(area);
		admin.setExperienciaPrevia(experienciaPrevia);
		asesorias.add(admin);
	}

	/**
	 * 
	 * Almacena una nueva capacitación en la lista de instancias de la clase
	 * {@link Capacitacion}.
	 * 
	 * @param capacitacion La capacitación a almacenar.
	 */

	public void almacenarCapacitacion(Scanner input) {

		input.nextLine(); // Limpiando el buffer cache
		Capacitacion capacitacion = new Capacitacion();
		String[] atributos = { "Identificador", "RUT Cliente", "dia", "hora", "lugar", "duracion",
				"cantidad de asistentes" };
		String identificador = "", rutCliente = "", dia = "", hora = "", lugar = "", duracion = "",
				cantidadAsistentes = "";
		// Falta terminar de agregar la capacitacion
		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					identificador = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(identificador, 10, 50);
					break;
				case 1:
					rutCliente = input.nextLine().trim();
					salir = dato.validarFecha(rutCliente);
					break;
				case 2:
					dia = input.nextLine().trim();
					salir = dato.esDiaValido(dia);
					break;
				case 3:
					hora = input.nextLine().trim();
					salir = dato.esHoraValida(hora);
					break;
				case 4:
					lugar = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(lugar, 10, 50);
					break;
				case 5:
					duracion = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(duracion, 10, 50);
					break;
				case 6:
					cantidadAsistentes = input.nextLine().trim();
					salir = dato.validarNumero(cantidadAsistentes, 1, 1000);
				}
			} while (!salir);
		}
		capacitacion.setIdentificador(Integer.valueOf(identificador));
		capacitacion.setRutCliente(Integer.valueOf(rutCliente));
		capacitacion.setDia(dia);
		capacitacion.setHora(hora);
		capacitacion.setLugar(lugar);
		capacitacion.setDuracion(duracion);
		capacitacion.setCantidadAsistentes(Integer.valueOf(cantidadAsistentes));
		capacitaciones.add(capacitacion);

	}

	/**
	 * Elimina un usuario de la lista de asesorías. Solicita el rut de tipo int.
	 * 
	 * @param input Scanner para la entrada de datos.
	 */
	public void eliminarUsuario(Scanner input) {
		Usuario buscar = new Usuario(input.nextInt());
		for (int i = 0; i < asesorias.size(); i++) {
			if (asesorias.get(i).analizarUsuario() == buscar.getRun()) {
				asesorias.remove(i);
			}
		}
	}

	/**
	 * Lista los usuarios registrados en la lista de asesorías.
	 */
	public void listarUsuarios() {
		int i = 1;
		for (IAsesoria asesoria : asesorias) {
			System.out.println("Usuario #" + i);
			i++;
			System.out.println(asesoria.toString());
		}
	}

	/**
	 * Lista los usuarios por tipo (cliente, profesional o administrativo).
	 * 
	 * @param tipo El tipo de usuario a listar.
	 */
	public void listarusuariosPorTipo(String tipo) {
		if (asesorias.isEmpty()) {
			System.out.println("** No hay nigun usuario registrado **");
		} else {
			if (tipo != null) {
				for (IAsesoria asesoria : asesorias) {
					if (tipo.toLowerCase().equals("cliente") && asesoria instanceof Cliente) {
						System.out.println(" Usuario del tipo Cliente: ");
						System.out.println(asesoria);
					} else if (tipo.toLowerCase().equals("profesional") && asesoria instanceof Profesional) {
						System.out.println(" Usuario del tipo Profesional: ");
						System.out.println(asesoria);
					} else if (tipo.toLowerCase().equals("administrativo") && asesoria instanceof Administrativo) {
						System.out.println(" Usuario del tipo Administrativo: ");
						System.out.println(asesoria);
					}
				}
			} else {
				System.out.println("Opcion no válida");
			}
		}
	}

	/**
	 * Lista las capacitaciones registradas junto con los datos del cliente asociado
	 * a cada una.
	 */
	public void listarCapacitaciones() {
		for (Capacitacion capacitaciones : capacitaciones) {
			System.out.println(capacitaciones);
			for (IAsesoria asesoria : asesorias) {
				System.out.println(" Datos del Cliente de esta capacitacion: ");
				if (asesoria instanceof Cliente && ((Cliente) asesoria).getRut() == capacitaciones.getRutCliente()) {
					System.out.println(asesoria);
				}
			}
		}
	}
}
