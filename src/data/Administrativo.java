package data;

import java.time.LocalDate;

//La clase Administratico extiende de la Clase Usuario
public class Administrativo extends Usuario{
	
	//Atributos de la clase Administrativo
	String area;
	String experienciaPrevia;
	
	//M�todo constructor de la clase Administrativo
	public Administrativo(String nombre,LocalDate fechaNacimiento,
			int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}
	
	//M�todo constructor vacio
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

	//M�todo toString
	@Override
	public String toString() {
		return super.toString()+"\n �rea: " + area + "\n experiencia Previa: " + experienciaPrevia;
	}
	//M�todo para validar que el area tenga m�nimo 5 caracteres, m�ximo 20
	  public void validarArea(String area) {
	        if (area.length() >= 5 && area.length() <= 20) {
	            this.area = area;
	        } else {
	            System.out.println("El �rea debe tener entre 5 y 20 caracteres...");
	        }
	    }
	
	  //M�todo analizarUsuario
	    public int analizarUsuario() {
	        super.analizarUsuario();
	        System.out.println("�rea: " + area);
	        System.out.println("Experiencia previa: " + experienciaPrevia);
	       
	        return super.getRun();
	    }
	
}
