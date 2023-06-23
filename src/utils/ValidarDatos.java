package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidarDatos {
	public ValidarDatos() {
	}
	
	public boolean validarRangoCaracteres(String entrada, int min, int max) {
		boolean retorno;
		try {
			if (entrada.length() < min || entrada.length() > max) {
				retorno = false;
				System.out.println("** mínimo " + min + " caracteres y máximo " + max + " caracteres.");
			} else {
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}

	public boolean esObligatorio(String entrada) {
		boolean retorno = true;
		if (entrada == null || entrada == "") {
			System.out.println("Campo Obligatorio");
			retorno = false;
		}
		return retorno;
	}

	public boolean validarFecha(String fecha) {
		boolean retorno;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(fecha, formatter);
			retorno = true;
		} catch (Exception e) {
			System.out.println("La fecha de nacimiento debe estar en formato DD/MM/AAAA.");
			retorno = false;
		}
		return retorno;
	}

	public boolean validarRutRun(String rutRunString, String rol) {
		boolean retorno = true;
		int rutRun;
		try {
			rutRun=Integer.valueOf(rutRunString);
			if (rutRun >= 99999999) {
				System.out.println("El " + rol + " debe ser menor que 99.999.999");
				retorno = false;
			}
		} catch (Exception e) {
			System.out.println("Ingresa solo números");
			retorno = false;
		}
		return retorno;
	}

	public boolean validarEdad(String edad, int min, int max) {
		boolean retorno = false;
		int edadInt;
		try {
			edadInt= Integer.valueOf(edad);
			if (edadInt >= min && edadInt < max) {
				retorno = true;
			} else {
				System.out.println("** La edad debe estar entre " + min + " y " + max);
			}
		} catch (Exception e) {
			System.out.println("Ingresa solo números");
			retorno = false;
		}
		return retorno;
	}

}
