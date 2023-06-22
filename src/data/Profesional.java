package data;

import java.time.LocalDate;

//La clase Profesional extiende de la clase Usuario
public class Profesional extends Usuario {

	//Atributos de la clase en privado
	private String titulo;
	private LocalDate fechaIngreso;
	
	//M�todo constructor de la clase Profesional
	public Profesional(String nombre,LocalDate fechaNacimiento,
			int run,String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	//M�todo constructor vacio
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

	//M�todo toString
	@Override
	public String toString() {
		return super.toString()+"\n t�tulo: " + titulo + "\n fecha de ingreso:" + fechaIngreso;
	}
	
	//M�todo que valida que el titulo tenga un m�nimo de 10 caracteres y m�ximo de 50
	  public void validarTitulo(String titulo) {
	        if (titulo.length() >= 10 && titulo.length() <= 50) {
	            this.titulo = titulo;
	        } else {
	            System.out.println("El t�tulo debe tener entre 10 y 50 caracteres...");
	        }
	    }
	  //M�todo analizarUsuario
	   public int analizarUsuario() {
	        super.analizarUsuario();
	        System.out.println("T�tulo: " + titulo);
	        System.out.println("Fecha de ingreso: " + fechaIngreso);
	        
	        return super.getRun();
	    }
}
