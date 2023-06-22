package data;

import java.time.LocalDate;

public class Usuario implements IAsesoria {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int run;

	
	
	public Usuario() {
	}
	
	
	public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}

	public Usuario(int run) {
		this.run=run;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "Usuario: \n Nombre: " + nombre + "\n Fecha de Nacimiento: " + fechaNacimiento + "\n Run: " + run;
	}

	@Override
	public int analizarUsuario() {
		System.out.println(" Nombre: " + nombre + "\n Run:  " + run);
		return run;
	}

	public String mostrarEdad() {
		int añoNacimiento = this.fechaNacimiento.getYear();
		int edad = LocalDate.now().getYear() - añoNacimiento;
		return "“El usuario tiene " + edad + " años”";
	}
}
