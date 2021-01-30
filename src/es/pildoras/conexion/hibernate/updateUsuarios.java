package es.pildoras.conexion.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class updateUsuarios {

	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuarios.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		 
		//***********Update de Datos*******
		
		try {
			//ponemos la clave del usuario que queremos modificar 
			
			String claveUsuario1 ="usu";
			
			
			
			//COmenzamos la sesion

			miSession.beginTransaction();
			
			usuarios miUsuario = miSession.get(usuarios.class, claveUsuario1);

;
			
			//hacemos el cambio que queramos
			
			miUsuario.setPass("usuario");
			
			
			
			// .commit para que se haga fijo
			// .roolback para volver atras si falla
			
			miSession.getTransaction().commit();
			
			
			
			
			System.out.println("Registro 1 actualizado correctamente en la BBDD");
			
			
			
		//*****************************otro metodo********************	
			//tambien lo podemos hacer con una consulta
			
			
			//COmenzamos la sesion

			miSession.beginTransaction();
			
			// y usamos la sentencia del update
			
			miSession.createQuery("update usuarios set nombreUsuario='usuario' where nombreUsuario LIKE 'usu'").executeUpdate();
			
			
			System.out.println("Registro 2 actualizado correctamente en la BBDD");
			
			
			miSession.getTransaction().commit();
			
			miSession.close();
			
			
			
		} finally {

			miFactory.close();

		}

	}

}
