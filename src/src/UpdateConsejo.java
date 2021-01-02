package src;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Consejo;

public class UpdateConsejo {
	
	public static Consejo actualizarConsejo(Session mySession, Integer idConsejo) {
		mySession.beginTransaction();
		Consejo miConsejo = mySession.get(Consejo.class, idConsejo);
		
		if(miConsejo != null) {
			miConsejo.setNombre("Nuevo nombre");
			
			mySession.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Registro actualizado con éxito.");
			
			return miConsejo;
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un registro con ese ID");
			return null;
		}
	
		//actualizaciones nec:
		/*
		 * 
		 * nombre
		 * descripcion
		 * contenido
		 * fecha
		 * imagen
		 * 
		 */
	}
}
