package data;

import java.time.LocalDate;

//La clase Profesional extiende de la clase Usuario
public class Profesional extends Usuario {

	//Atributos de la clase en privado
	private String titulo;
	private LocalDate fechaIngreso;
	
	//Método constructor de la clase Profesional
	public Profesional(String nombre,LocalDate fechaNacimiento,
			int run,String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	//Método constructor vacio
	public Profesional() {
	}


	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	//Método toString
	@Override
	public String toString() {
		return super.toString()+"\n título: " + titulo + "\n fecha de ingreso:" + fechaIngreso;
	}
	
	//Método que valida que el titulo tenga un mínimo de 10 caracteres y máximo de 50
	  public void validarTitulo(String titulo) {
	        if (titulo.length() >= 10 && titulo.length() <= 50) {
	            this.titulo = titulo;
	        } else {
	            System.out.println("El título debe tener entre 10 y 50 caracteres...");
	        }
	    }
	//Método analizarUsuario
	   public void analizarUsuario() {
	        super.analizarUsuario();
	        System.out.println("Título: " + titulo);
	        System.out.println("Fecha de ingreso: " + fechaIngreso);
	    }
}
