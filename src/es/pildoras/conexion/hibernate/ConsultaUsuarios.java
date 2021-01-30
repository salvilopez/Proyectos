package es.pildoras.conexion.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaUsuarios {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuarios.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		//***********Consulta de Datos*******
		try {

			//COmenzamos la sesion

			miSession.beginTransaction();
			
			//COnsulta de Usuarios
			
			//en el createquery metemos el formato HQL "en este caso from + el nombre de la Çlase"
			
			List<usuarios> losUsuarios=miSession.createQuery("from usuarios").getResultList();
			
			
			//mostrar los Usuarios
			
			
			for (usuarios unUsuario : losUsuarios) {
				System.out.println(unUsuario.getNombreUsuario()+" "+unUsuario.getEmail()+ " " +unUsuario.getPass());
			}
			
			
			//***********Consulta de solo los salvi*******
			
			// cl es un alias, da igual el que pongas
			
			losUsuarios=miSession.createQuery("from usuarios cl where cl.nombreUsuario='salvi'").getResultList();
			
			
			//mostrar los Usuarios
			
			
			for (usuarios unUsuario : losUsuarios) {
				System.out.println(unUsuario.getNombreUsuario()+" "+unUsuario.getEmail()+ " " +unUsuario.getPass());
			
			}
			
			
			
			
			// .commit para que se haga fijo
			// .roolback para volver atras si falla
			
			
			miSession.getTransaction().commit();
			
			
			miSession.close();
			

		} finally {

			miFactory.close();

		}

	}

}
