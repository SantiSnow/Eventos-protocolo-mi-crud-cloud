package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Consejo;
import src.SelectConsejo;

public class TestSistema {
	
	@Test
	public void pruebaDeConexion() {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
		
		Session mySession = sessionFactory.openSession();
		
		if(mySession != null) {
			System.out.println("Conexion exitosa");
		}else {
			System.out.println("Error");
		}
		
		Assert.assertTrue(mySession != null);
		
		mySession.close();
		sessionFactory.close();
	}
	
	@Test
	public void testBuscarConsejoPorId() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
		
		Session mySession = sessionFactory.openSession();
		
		Consejo miConsejo = SelectConsejo.selectConsejo(mySession, 1);
		
		System.out.println("Datos del tip buscado: ");
		System.out.println(miConsejo.getNombre());
		System.out.println(miConsejo.getFecha());
		System.out.println(miConsejo.getDescripcion());
		
		mySession.close();
		sessionFactory.close();
	}

}
