package src;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Consejo;

public class SelectConsejo {
	
	public static Consejo selectConsejo(Session mySession, Integer idConsejo) {
		
		mySession.beginTransaction();
		Consejo miConsejo = mySession.get(Consejo.class, idConsejo);
		mySession.getTransaction().commit();
		if(miConsejo == null) {
			JOptionPane.showMessageDialog(null, "No se encontró un consejo con ese número ID");
			return null;
		}
		else {
			return miConsejo;
		}
	}
	
	public static List<Consejo> selectAllTips(Session mySession){
		mySession.beginTransaction();
		List<Consejo> todosLosConsejos = mySession.createQuery("from Consejo", Consejo.class).getResultList();
		mySession.getTransaction().commit();
		return todosLosConsejos;
	}

}
