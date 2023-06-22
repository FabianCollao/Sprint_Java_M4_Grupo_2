package domain;

import java.util.ArrayList;
import java.util.List;

import data.Administrativo;
import data.Capacitacion;
import data.Cliente;
import data.IAsesoria;
import data.Profesional;
import data.Usuario;

public class Contenedor {
	public ArrayList<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;
	Usuario usuario;
	IPrintPantalla print;

	public Contenedor() {
		asesorias = new ArrayList<IAsesoria>();
		capacitaciones = new ArrayList<Capacitacion>();
	}

	public void almacenarCliente(Cliente cliente) {
		// permite agregar un nuevo cliente a la lista de instancias dela interface
		// Asesoria.

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
		for (IAsesoria asesoria : asesorias) {
			System.out.println(asesoria);
		}
	}

	public void listarusuariosPorTipo() {
		// recibe un tipo de usuario (cliente, administrador o
		// profesional), y retorna los datos respectivos según el tipo de usuario.
	}

	public void listarCapacitaciones() {
		/*
		 * este método despliega las capacitaciones registradas en la lista respectiva,
		 * junto con los datos del cliente al que está asociada dicha capacitación.
		 */
	}
}
