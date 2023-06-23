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
import utils.SolicitarDatoValido;

public class Contenedor {
	public ArrayList<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;
	Usuario usuario;
	IPrintPantalla print;
	private SolicitarDatoValido dato = new SolicitarDatoValido();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Contenedor() {
		asesorias = new ArrayList<IAsesoria>();
		capacitaciones = new ArrayList<Capacitacion>();
	}

	public void almacenarCliente(Scanner input) {
		Cliente cliente = new Cliente();
		input.nextLine();
		cliente.setNombre(dato.solicitarRangoValido("Nombre", input, 10, 30));
		cliente.setFechaNacimiento(dato.solicitarFechaValida("Fecha de Nacimiento (dd/mm/yyyy)", input));
		cliente.setRun(dato.solicitarRutValido("Run", input));
		cliente.setRut(dato.solicitarRutValido("Rut", input));
		cliente.setNombres(dato.solicitarRangoValido("Nombres", input, 5, 30));
		cliente.setApellidos(dato.solicitarRangoValido("Apellidos", input, 5, 30));
		cliente.setTelefono(dato.solicitarDatoObligatorio("Telefono", input));
		cliente.setSistemaSalud(dato.solicitarSistemaSalud(input));
		cliente.setDireccion(dato.solicitarRangoValido("Direccion", input, 0, 70));
		cliente.setComuna(dato.solicitarRangoValido("Comuna", input, 0, 50));
		cliente.setEdad(dato.solicitarEdadValida("Edad", input, 0, 150));
		asesorias.add(cliente);
	}

	public void almacenarProfesional(Scanner input) {
		Profesional profesional = new Profesional();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Título", "Fecha de ingreso" };
		String nombre = "", fechaNac = "", run = "", rut = "", titulo = "", fechaIngreso = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					nombre = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombre, 10, 50);
					profesional.setNombre(nombre);
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					salir = dato.validarFecha(fechaNac);
					profesional.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
					break;
				case 2:
					run = input.nextLine().trim();
					salir = dato.validarRutRun(run, "run");
					profesional.setRun(Integer.valueOf(run));
					break;
				case 3:
					titulo = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(titulo, 10, 50);
					break;
				case 4:
					fechaIngreso = input.nextLine().trim();
					salir = dato.validarFecha(fechaIngreso);
					break;
				}
			} while (!salir);
		}
		asesorias.add(profesional);
	}

	public void almacenarAdministrativo(Scanner input) {
		Administrativo admin = new Administrativo();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Área", "Experiencia previa" };
		String nombre = "", fechaNac = "", run = "", rut = "", area = "", experienciaPrevia = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:
					nombre = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombre, 10, 50);
					admin.setNombre(nombre);
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					salir = dato.validarFecha(fechaNac);
					admin.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
					break;
				case 2:
					run = input.nextLine().trim();
					salir = dato.validarRutRun(run, "run");
					admin.setRun(Integer.valueOf(run));
					break;
				case 3:
					area = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(area, 5, 20);
					admin.setArea(area);
					break;
				case 4:
					experienciaPrevia = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(experienciaPrevia, 20, 100);
					admin.setExperienciaPrevia(experienciaPrevia);
					break;
				}
			} while (!salir);
		}
		asesorias.add(admin);
	}

	public void almacenarCapacitacion(Capacitacion capacitacion) {
		// permite agregar una nueva capacitación a la lista de instancias de la clase
		// Capacitación
		capacitaciones.add(capacitacion);

	}

	public void eliminarUsuario(Scanner input) {
		Usuario buscar = new Usuario(input.nextInt());
		for (int i = 0; i < asesorias.size(); i++) {
			if (asesorias.get(i).analizarUsuario() == buscar.getRun()) {
				asesorias.remove(i);
			}
		}
	}

	public void listarUsuarios() {
		int i = 1;
		for (IAsesoria asesoria : asesorias) {
			System.out.println("Usuario #" + i);
			i++;
			System.out.println(asesoria.analizarUsuario());
		}
	}

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

	public void listarCapacitaciones() {
		/*
		 * este método despliega las capacitaciones registradas en la lista respectiva,
		 * junto con los datos del cliente al que está asociada dicha capacitación.
		 */
	}
}
