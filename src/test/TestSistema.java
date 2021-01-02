package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.jupiter.api.Test;

import model.Consejo;

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
		
		mySession.close();
		sessionFactory.close();
	}

}
