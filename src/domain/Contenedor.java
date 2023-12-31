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
		Capacitacion capacitacion = new Capacitacion();
		String[] atributos = { "Identificador", "RUT Cliente", "dia (entre lunes y domingo)", "hora (hh:mm)", "lugar",
				"duracion", "cantidad de asistentes" };
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
					try {
						if (salir = dato.esObligatorio(identificador)) {
							capacitacion.setIdentificador(Integer.valueOf(identificador));
						}
					} catch (Exception e) {
						System.out.println("Ingresa solo números");
						salir = false;
					}
					break;
				case 1:
					rutCliente = input.nextLine().trim();
					try {
						if (salir = dato.esObligatorio(rutCliente)) {
							capacitacion.setRutCliente(Integer.valueOf(rutCliente));
						}
					} catch (Exception e) {
						System.out.println("Ingresa solo números");
						salir = false;
					}

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
		int run=0;
		boolean eliminado=false;
		if(!asesorias.isEmpty()) {
			System.out.print("Ingrese el rut del usuario para su eliminación: ");
			String entrada=input.nextLine();
			try {
				run= Integer.valueOf(entrada);
			}catch (Exception e) {
				System.out.println("** Ingresa un rut válido **");
			} finally {
				Usuario buscar = new Usuario(run);
				for (int i = 0; i < asesorias.size(); i++) {
					if (asesorias.get(i).getRun() == buscar.getRun()) {
						asesorias.remove(i);
						eliminado=true;
						System.out.println("Usuario eliminado con éxito");
					}
				}
				if(!eliminado) {
					System.out.println("No se encontró el usuario con el rut "+ buscar.getRun());
				}
			}
		}else {
			System.out.println("** No hay usuarios registrados **");
		}
	}

	/**
	 * Lista los usuarios registrados en la lista de asesorías.
	 */
	public void listarUsuarios() {
		int i = 1;
		if(asesorias.isEmpty()) {
			System.out.println("No hay ningun usuario registrado");
		}else {
			for (IAsesoria asesoria : asesorias) {
				System.out.println("Usuario #" + i);
				i++;
				System.out.println(asesoria.mostrarUsuario());
			}
		}
	}

	/**
	 * Lista los usuarios por tipo (cliente, profesional o administrativo).
	 * 
	 * @param tipo El tipo de usuario a listar.
	 */
	public void listarusuariosPorTipo(String tipo) {
		if (asesorias.isEmpty()) {
			System.out.println("** No hay ningun usuario registrado **");
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
					}else {
						System.out.println("No hay usuarios del tipo "+tipo);
					}
				}
			} else {
				System.out.println("**** Opcion no válida");
			}
		}
	}

	/**
	 * Lista las capacitaciones registradas junto con los datos del cliente asociado
	 * a cada una.
	 */
	public void listarCapacitaciones() {
		if(capacitaciones.isEmpty()) {
			System.out.println("********* No hay registro de capacitaciones");
		}else {
			for (Capacitacion capacitacion : capacitaciones) {
				System.out.println(capacitacion);
				for (IAsesoria asesoria : asesorias) {
					if (asesoria instanceof Cliente && ((Cliente) asesoria).getRut() == capacitacion.getRutCliente()) {
						System.out.println(" Datos del Cliente de esta capacitacion: ");
						System.out.println(asesoria);
					}else {
						System.out.println("********* No se encontró el rut del cliente registrado, rut "+capacitacion.getRutCliente());
					}
				}
			}
		}
	}
}
