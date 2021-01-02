package src;

import org.hibernate.Session;

import model.Consejo;

public class InsertConsejo {
	
	public static Consejo createConsejo(Session mySession, String nombre, String descripcion, String contenido, String fecha, String fecha_creacion, String fecha_actualizacion, String imagen_nombre) {
		mySession.beginTransaction();
		Consejo nuevoConsejo = new Consejo(nombre, descripcion, contenido, fecha, fecha_creacion, fecha_actualizacion, imagen_nombre);
		mySession.save(nuevoConsejo);
		mySession.getTransaction().commit();
		return nuevoConsejo;
	}

}
