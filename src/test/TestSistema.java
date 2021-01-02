package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Consejo;
import src.DeleteConsejo;
import src.InsertConsejo;
import src.SelectConsejo;
import src.UpdateConsejo;

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
		
		Assert.assertEquals("La precedencia", miConsejo.getNombre());
		
		mySession.close();
		sessionFactory.close();
	}
	
	@Test
	public void testParaVerTodosLosConsejos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
			
		Session mySession = sessionFactory.openSession();
		
		List<Consejo> misConsejos = SelectConsejo.selectAllTips(mySession);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Lista Completa de tips:");
		
		for(Consejo i: misConsejos) {
			System.out.println(i.getNombre());
			System.out.println(i.getDescripcion());
			System.out.println(i.getFecha());
			
		}
		
		mySession.close();
		sessionFactory.close();
	}

	@Test
	public void testParaInsertarConsejos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
				
		Session mySession = sessionFactory.openSession();
		
		Consejo nuevoConsejo = InsertConsejo.createConsejo(
				mySession, 
				"Consejo practica", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
				"2021-01-02",
				"NULL",
				"NULL",
				"consejos-imgs/la-precedencia.jpg"
				);
		
		Assert.assertEquals("Consejo practica", nuevoConsejo.getNombre());
		
		mySession.close();
		sessionFactory.close();
	}
	
	@Test
	public void testParaActualizarConsejos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
					
		Session mySession = sessionFactory.openSession();
	
		Consejo nuevoConsejo = UpdateConsejo.actualizarConsejo(mySession, 7);
		
		Assert.assertEquals("Nuevo nombre", nuevoConsejo.getNombre());
		
		mySession.close();
		sessionFactory.close();
	}
	
	@Test
	public void testParaBorrarConsejos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Consejo.class)
			.buildSessionFactory();
						
		Session mySession = sessionFactory.openSession();
		
		Consejo consejoEliminado = DeleteConsejo.borrarConsejo(mySession, 7);
		
		Assert.assertEquals(7, consejoEliminado.getId(), 0);
		
		mySession.close();
		sessionFactory.close();
	}
	
	
}
