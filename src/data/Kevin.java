package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import data.Administrativo;
import data.Capacitacion;
import data.Cliente;
import data.Profesional;
import data.SistemaSalud;
import data.Usuario;

public class Kevin {
	
	//Creaci�n de profesional
	
	System.out.println("Ingrese los Datos del nuevo Profesional");
	Profesional profesional = new Profesional("Sara Martinez",LocalDate.of(1990,03,15),174867518,"Ingeniero Comercial",LocalDate.of(2023,06,22));  // Solicitar e ingresar los datos a profesional
	contenedor.almacenarProfesional(profesional);
	System.out.println("Profesional creado con �xito");
	
	//Creacion del Administrativo
	System.out.println("Ingrese los Datos del nuevo Administrativo");
	Administrativo admin = new Administrativo("Jose Fernandez",LocalDate.of(1980,05,12),150002345,"Contabilidad",
			"Experiencia en: registro y an�lisis de transacciones,\n elaboraci�n de informes financieros, gestion "
			+ "en cuentas por pagar y control presupuestario.");// Solicitar e ingresar los datos a profesional
	contenedor.almacenarAdministrativo(admin);
	System.out.println("Administrador creado con �xito");

	
	
	//Metodo para dar el formato a la fecha de ingreso
	  public void formatoFechaIngreso(String fechaIngreso) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fecha = LocalDate.parse(fechaIngreso, formatter);
	        this.fechaIngreso = fecha;
	    }
	  
	// M�todo que valida que el titulo tenga un m�nimo de 10 caracteres y
		// m�ximo de 50
		public void validarTitulo(String titulo) {
			if (titulo != null && titulo.length() >= 10 && titulo.length() <= 50) {
				this.titulo = titulo;
			} else {
				System.out.println("Error: El t�tulo debe tener entre 10 y 50 caracteres.");
			}

		}
		
		// M�todo para validar que el area sea obligatorio y tenga m�nimo 5 caracteres, m�ximo 20
		public void validarArea(String area) {
			if (area != null && area.length() >= 5 && area.length() <= 20) {
				this.area = area;
			} else {
				System.out.println("Error: El �rea debe tener entre 5 y 20 caracteres.");
			}
		}

		// M�todo para validar que la experiencia previa tenga como m�ximo 100 caracteres
		public void validarExperienciaPrevia(String experienciaPrevia) {
			if (experienciaPrevia.length() <= 100) {
				this.experienciaPrevia = experienciaPrevia;
			} else {
				System.out.println("La experiencia previa debe tener como m�ximo 100 caracteres.");
			}
		}

		
}
