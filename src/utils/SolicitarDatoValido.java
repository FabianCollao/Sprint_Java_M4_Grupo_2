package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import data.SistemaSalud;

/**
 * Clase que extiende la clase ValidarDato y se encarga de solicitar y validar
 * datos ingresados por el usuario.
 */
public class SolicitarDatoValido extends ValidarDatos {

	/**
	 * Constructor de la clase SolicitarDatoValido.
	 */
	public SolicitarDatoValido() {
	}

	/**
	 * Solicita al usuario ingresar una edad válida dentro de un rango.
	 *
	 * @param datoSolicitado el nombre del dato que se solicita.
	 * @param input          el objeto Scanner utilizado para leer la entrada del
	 *                       usuario.
	 * @param min            la edad mínima permitida.
	 * @param max            la edad máxima permitida.
	 * @return la edad válida ingresada por el usuario.
	 */
	public int solicitarEdadValida(String datoSolicitado, Scanner input, int min, int max) {
		boolean salir = false;
		input.reset();
		int retorno = 0;
		String captura = "";
		do {
			System.out.print(" Ingresa " + datoSolicitado + ": ");
			captura = input.nextLine().trim();
			salir = validarEdad(captura, min, max);
			if (salir) {
				retorno = Integer.valueOf(captura);
			}
		} while (!salir);
		return retorno;
	}

	/**
	 * Solicita al usuario ingresar un número de rut o run válido.
	 *
	 * @param datoSolicitado el nombre del dato que se solicita.
	 * @param input          el objeto Scanner utilizado para leer la entrada del
	 *                       usuario.
	 * @return el número de rut o run válido ingresado por el usuario.
	 */
	public int solicitarRutValido(String datoSolicitado, Scanner input) {
		boolean salir = false;
		input.reset();
		int retorno = 0;
		String captura = "";
		do {
			System.out.print(" Ingresa " + datoSolicitado + ": ");
			captura = input.nextLine().trim();
			salir = validarRutRun(captura, datoSolicitado);
			if (salir) {
				retorno = Integer.valueOf(captura);
			}
		} while (!salir);
		return retorno;
	}

	/**
	 * Solicita al usuario ingresar una cadena de caracteres con un rango válido.
	 *
	 * @param datoSolicitado el nombre del dato que se solicita.
	 * @param input          el objeto Scanner utilizado para leer la entrada del
	 *                       usuario.
	 * @param min            la longitud mínima permitida de la cadena.
	 * @param max            la longitud máxima permitida de la cadena.
	 * @return la cadena de caracteres válida ingresada por el usuario.
	 */

	public String solicitarRangoValido(String datoSolicitado, Scanner input, int min, int max) {
		boolean salir = false;
		input.reset();
		String retorno = "";
		String captura = "";
		do {
			System.out.print(" Ingresa " + datoSolicitado + ": ");
			captura = input.nextLine().trim();
			salir = validarRangoCaracteres(captura, min, max);
			if (salir) {
				retorno = captura;
			}
		} while (!salir);
		return retorno;
	}

	/**
	 * Solicita al usuario ingresar una fecha válida en formato "dd/MM/yyyy".
	 *
	 * @param datoSolicitado el nombre del dato que se solicita.
	 * @param input          el objeto Scanner utilizado para leer la entrada del
	 *                       usuario.
	 * @return la fecha válida ingresada por el usuario.
	 */
	public LocalDate solicitarFechaValida(String datoSolicitado, Scanner input) {
		boolean salir = false;
		input.reset();
		LocalDate fecha =null;
		String captura = "";
		do {
			System.out.print(" Ingresa " + datoSolicitado + ": ");
			captura = input.nextLine().trim();
			salir = validarFecha(captura);
			if (salir) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fecha = LocalDate.parse(captura, formatter);
			}
		} while (!salir);
		return fecha;
	}

	/**
	 * Solicita al usuario ingresar un dato obligatorio.
	 *
	 * @param datoSolicitado el nombre del dato que se solicita.
	 * @param input          el objeto Scanner utilizado para leer la entrada del
	 *                       usuario.
	 * @return el dato ingresado por el usuario.
	 */
	public int solicitarDatoObligatorio(String datoSolicitado, Scanner input) {
		boolean salir = false;
		input.reset();
		int retorno = 0;
		String captura = "";
		do {
			System.out.print(" Ingresa " + datoSolicitado + ": ");
			captura = input.nextLine().trim();
			salir = esObligatorio(captura);
			try {
				if (salir) {
					retorno = Integer.valueOf(captura);
				}
			} catch (Exception e) {
				System.out.println("Ingresa solo números");
				salir = false;
			}
		} while (!salir);
		return retorno;
	}

	/**
	 * Solicita al usuario ingresar un sistema de salud válido (Fonasa o Isapre).
	 *
	 * @param input el objeto Scanner utilizado para leer la entrada del usuario.
	 * @return el sistema de salud válido ingresado por el usuario.
	 */
	public SistemaSalud solicitarSistemaSalud(Scanner input) {
		boolean salir = false;
		input.reset();
		SistemaSalud retorno = null;
		String captura = "";
		do {
			System.out.print(" Ingresa Sistema de salud (Fonasa o Isapre): ");
			captura = input.nextLine().trim();
			salir = esObligatorio(captura);
			if (salir) {
				if (captura.toLowerCase().equals("fonasa")) {
					retorno = SistemaSalud.Fonasa;
				} else if (captura.toLowerCase().equals("isapre")) {
					retorno = SistemaSalud.Isapre;
				}
			}
		} while (!salir);
		return retorno;

	}
}
