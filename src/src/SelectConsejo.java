package src;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Consejo;

public class SelectConsejo {
	
	public static Consejo selectConsejo(Session mySession, Integer idConsejo) {
		
		mySession.beginTransaction();
		Consejo miConsejo = mySession.get(Consejo.class, idConsejo);
		
		if(miConsejo == null) {
			JOptionPane.showMessageDialog(null, "No se encontr� un consejo con ese n�mero ID");
			return null;
		}
		else {
			return miConsejo;
		}
	}

}
