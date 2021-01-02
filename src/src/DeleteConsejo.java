package src;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Consejo;

public class DeleteConsejo {

	public static Consejo borrarConsejo(Session mySession, Integer idConsejo) {
		mySession.beginTransaction();
		Consejo miConsejo = mySession.get(Consejo.class, idConsejo);
		
		if(miConsejo != null) {
			mySession.delete(miConsejo);
			mySession.getTransaction().commit();
			return miConsejo;
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un registro con ese ID");
			return null;
		}
		
	}
}
