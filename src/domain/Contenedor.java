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

	public void almacenarCliente() {
		// permite agregar un nuevo cliente a la lista de instancias dela interface
		// Asesoria.
		/* Cliente de prueba:
		 * Cliente clientePrueba = new Cliente("Maria Castillo",LocalDate.of(1990,03,15),175542267,"Maria Antonietta","Castillo Montenegro",965362782,
						"Capital",SistemaSalud.Fonasa,"Calle Migración #4455, Las Torres", "Casablanca",33,175542267);
		   asesorias.add(clientePrueba);
		 * */
		Cliente cliente = new Cliente();
		Scanner input = new Scanner(System.in);
		String[] atributos = { "Nombre", "Fecha de Nacimiento (dd/mm/yyyy)", "Run", "Rut", "Nombres", "Apellidos",
				"Telefono", "AFP", "Sistema de Salud (Fonasa o Isapre)", "Direccion", "Comuna", "Edad" };

		String nombre = "", fechaNac = "", run = "", rut = "", nombres = "", apellidos = "", telefono = "", afp = "",
				sistemaSalud = "", direccion = "", comuna = "", edad = "";

		boolean salir = false;
		for (int i = 0; i < atributos.length; i++) {
			do {
				System.out.print("Ingresa " + atributos[i] + ": ");
				switch (i) {
				case 0:// Nombre
					nombre = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombre, 10, 50);
					break;
				case 1:// Fecha nacimiento
					fechaNac = input.nextLine().trim();
					salir = dato.validarFecha(fechaNac);
					break;
				case 2:// Run
					run = input.nextLine().trim();
					salir = dato.validarRutRun(run, "run");
					break;
				case 3:// Rut
					rut = input.nextLine().trim();
					salir = dato.validarRutRun(rut, "rut");
					break;
				case 4:// Nombres
					nombres = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(nombres, 5, 30);
					break;
				case 5:// Apellidos
					apellidos = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(apellidos, 5, 30);
					break;
				case 6:// Telefono
					telefono = input.nextLine().trim();
					salir = dato.esObligatorio(telefono);
					break;
				case 7:// AFP
					afp = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(afp, 4, 30);
					break;
				case 8:// SistemaSalud
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
				case 9:// Direccion
					direccion = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(direccion, 0, 70);
					break;
				case 10:// Comuna
					comuna = input.nextLine().trim();
					salir = dato.validarRangoCaracteres(comuna, 0, 50);
					break;
				case 11:// Edad
					edad = input.nextLine().trim();
					salir = dato.validarEdad(edad, 0, 150);
					break;
				}
			} while (!salir);
		}
		// Resto de atributos del cliente creado
		cliente.setNombre(nombre);
		cliente.setFechaNacimiento(LocalDate.parse(fechaNac, formatter));
		cliente.setRun(Integer.valueOf(run));
		cliente.setRut(Integer.valueOf(rut));
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setAfp(afp);
		cliente.setDireccion(direccion);
		cliente.setComuna(comuna);
		cliente.setEdad(Integer.valueOf(edad));
		asesorias.add(cliente);

	}

	public void almacenarProfesional(Profesional profesional) {
		// permite agregar un nuevo profesional a la lista de instancias de la interface
		// Asesoria.
		asesorias.add(profesional);
	}

	public void almacenarAdministrativo(Administrativo administrativo) {
		// permite agregar un nuevo administrativo a la lista de instancias de la
		// interface Asesoria.
		asesorias.add(administrativo);
	}

	public void almacenarCapacitacion(Capacitacion capacitacion) {
		// permite agregar una nueva capacitación a la lista de instancias de la clase
		// Capacitación
		capacitaciones.add(capacitacion);

	}

	public void eliminarUsuario(int run) {
		// permite eliminar un usuario desde la lista de interfaces de Asesoría acuerdo
		// con el RUN del usuario.
		Usuario buscar= new Usuario(run);

		for(int i=0; i<asesorias.size(); i++) {
			if(asesorias.get(i).analizarUsuario()==buscar.getRun()) {
				System.out.println("Es igual");
				
				asesorias.remove(i);
				//falta eliminarlo me piló el tiempo ;)
			}
		}
		
		
	}

	public void listarUsuarios() {
		/*
		 * permite desplegar la lista completa de usuarios, independiente del tipo. En
		 * este método solo se deben desplegar los datos de la clase usuario.
		 */
		int i=1;
		for (IAsesoria asesoria : asesorias) {
			System.out.println("Usuario #"+i);
			i++;
			System.out.println(asesoria.analizarUsuario());
		}
	}

	public void listarusuariosPorTipo(String tipo) {
		// recibe un tipo de usuario (cliente, administrador o
		// profesional), y retorna los datos respectivos según el tipo de usuario

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
