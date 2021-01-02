package src;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Consejo;

public class UpdateConsejo {
	
	public static Consejo actualizarConsejo(Session mySession, Integer idConsejo) {
		mySession.beginTransaction();
		Consejo miConsejo = mySession.get(Consejo.class, idConsejo);
		
		if(miConsejo != null) {
			
			int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para actualizar el nombre "
																+ "\nIngrese 2 para cambiar la descripción "
																+ "\n3 para cambiar el contenido  "
																+ "\n4 para actualizar la fecha "
																+ "\nO 5 para cambiar el nombre de imagen: "));
			switch (opcionElegida) {
				case 1:
					String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del consejo");
					miConsejo.setNombre(nuevoNombre);
					break;
				case 2:
					String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese nueva descripcion del consejo");
					miConsejo.setDescripcion(nuevaDescripcion);
					break;
				case 3:
					String nuevoContenido = JOptionPane.showInputDialog("Ingrese el nuevo contenido del consejo");
					miConsejo.setContenido(nuevoContenido);		
					break;
				case 4:
					String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha");
					miConsejo.setFecha(nuevaFecha);
					break;
				case 5:
					String nuevaImg = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la imagen");
					miConsejo.setImagen(nuevaImg);
					break;
	
				default:
					JOptionPane.showMessageDialog(null, "Opción no soportada.");
			}
			mySession.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Registro actualizado con éxito.");
			return miConsejo;
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro un registro con ese ID");
			return null;
		}

	}
}
