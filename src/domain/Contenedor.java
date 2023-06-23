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

public class Contenedor {
	public ArrayList<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;
	Usuario usuario;
	IPrintPantalla print;
	private ValidarDatos dato = new ValidarDatos();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Contenedor() {
		asesorias = new ArrayList<IAsesoria>();
		capacitaciones = new ArrayList<Capacitacion>();
	}

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
					salir = dato.validarRangoCaracteres(nombre, 10, 50);
					cliente.setNombre(nombre);
					break;
				case 1:
					fechaNac = input.nextLine().trim();
					salir = dato.validarFecha(fechaNac);
					cliente.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
					break;
				case 2:
					run = input.nextLine().trim();
					salir = dato.validarRutRun(run, "run");
					cliente.setRun(Integer.valueOf(run));
					break;
				case 3:
					rut = input.nextLine().trim();
					salir = dato.validarRutRun(rut, "rut");
					cliente.setRut(Integer.valueOf(rut));
					break;
				case 4:
					nombres = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombres, 5, 30);
					cliente.setNombres(nombres);
					break;
				case 5:
					apellidos = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(apellidos, 5, 30);
					cliente.setApellidos(apellidos);
					break;
				case 6:
					telefono = input.nextLine().trim();
					salir = dato.esObligatorio(telefono);
					//cliente.setTelefono(telefono);   ///////////////////////////////////////
					break;
				case 7:
					afp = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(afp, 4, 30);
					cliente.setAfp(afp);
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
					salir = dato.validarRangoCaracteres(direccion, 0, 70);
					cliente.setDireccion(direccion);
					break;
				case 10:
					comuna = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(comuna, 0, 50);
					cliente.setComuna(comuna);
					break;
				case 11:
					edad = input.nextLine().trim();
					salir = dato.validarEdad(edad, 0, 150);
					cliente.setEdad(Integer.valueOf(edad));
					break;
				}
			} while (!salir);
		}
		asesorias.add(cliente);
	}

	public void almacenarProfesional(Scanner input) {
		Profesional profesional = new Profesional();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run","Título","Fecha de ingreso"};
		String nombre = "", fechaNac = "", run = "", rut = "", titulo= "", fechaIngreso="";
		
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
					titulo= input.nextLine().trim();
					salir = dato.validarRangoCaracteres(titulo,10, 50);
					break;
				case 4:
					fechaIngreso= input.nextLine().trim();
					salir = dato.validarFecha(fechaIngreso);
					break;
				}
			} while (!salir);
		}
		asesorias.add(profesional);
	}

	public void almacenarAdministrativo(Scanner input) {
		Administrativo admin = new Administrativo();
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run","Área","Experiencia previa"};
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
					area= input.nextLine().trim();
					salir = dato.validarRangoCaracteres(area,5,20);
					admin.setArea(area);
					break;
				case 4:
					experienciaPrevia= input.nextLine().trim();
					salir = dato.validarRangoCaracteres(experienciaPrevia,20, 100);
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
		Usuario buscar= new Usuario(input.nextInt());
		for(int i=0; i<asesorias.size(); i++) {
			if(asesorias.get(i).analizarUsuario()==buscar.getRun()) {
				asesorias.remove(i);
			}
		}
	}

	public void listarUsuarios() {
		int i=1;
		for (IAsesoria asesoria : asesorias) {
			System.out.println("Usuario #"+i);
			i++;
			System.out.println(asesoria.analizarUsuario());
		}
	}

	public void listarusuariosPorTipo(String tipo) {
		if(asesorias.isEmpty()) {
			System.out.println("** No hay nigun usuario registrado **");
		}else {
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
