package data;

import java.time.LocalDate;

public class Usuario implements IAsesoria{
	private String nombre;
	private String rut;
	private LocalDate fechaNacimiento;
	private int run;
	
	public Usuario() {
		
	}
	public Usuario(String nombre, String rut, LocalDate fechaNacimiento, int run) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
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
		return "Usuario [nombre=" + nombre + ", rut=" + rut + ", fechaNacimiento=" + fechaNacimiento + ", run=" + run
				+ "]";
	}
	@Override
	public void analizarUsuario() {
		
	}
	public void mostrarEdad() {
		
	}
}
