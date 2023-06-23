package data;

import java.util.ArrayList;
import java.util.List;

public class ContenedorLelen {
	
	public List<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;

	public ContenedorLelen() {
	}
	
	public void almacenarCapacitacion(Capacitacion capacitacion) {
		if (capacitaciones == null) {
			capacitaciones = new ArrayList<Capacitacion>();
		}
		capacitaciones.add(capacitacion);

	}
	
	public void listarCapacitaciones() {
		for (Capacitacion capacitacion : capacitaciones) {
			System.out.println(capacitacion.toString());
			for (IAsesoria asesoria : asesorias) {
				if (asesoria instanceof Cliente) {
					Cliente cliente = (Cliente) asesoria;
					if (capacitacion.getRutCliente().contains(cliente.getRut()+"")) {
						System.out.println(cliente.toString());						
					}
				}
			}
		}
	}

}
