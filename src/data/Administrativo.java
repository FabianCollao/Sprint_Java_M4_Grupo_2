package data;

import java.time.LocalDate;

//La clase Administratico extiende de la Clase Usuario
public class Administrativo extends Usuario{
	
	//Atributos de la clase Administrativo
	String area;
	String experienciaPrevia;
	
	//Método constructor de la clase Administrativo
	public Administrativo(String nombre,LocalDate fechaNacimiento,
			int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}
	
	//Método constructor vacio
	public Administrativo() {
	}

//Getters y Setters
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	//Método toString
	@Override
	public String toString() {
		return super.toString()+"\n área: " + area + "\n experiencia Previa: " + experienciaPrevia;
	}
	//Método para validar que el area tenga mínimo 5 caracteres, máximo 20
	  public void validarArea(String area) {
	        if (area.length() >= 5 && area.length() <= 20) {
	            this.area = area;
	        } else {
	            System.out.println("El área debe tener entre 5 y 20 caracteres...");
	        }
	    }
	
	  //Método analizarUsuario
	    public void analizarUsuario() {
	        super.analizarUsuario();
	        System.out.println("Área: " + area);
	        System.out.println("Experiencia previa: " + experienciaPrevia);
	    }
	
}
