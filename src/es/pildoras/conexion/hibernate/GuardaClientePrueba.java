package es.pildoras.conexion.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GuardaClientePrueba {

	public static void main(String[] args) {


		

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuarios.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			

			usuarios usuario1 = new usuarios("admin","admin","admin@gmail.com" );
			
			
			miSession.beginTransaction();
		/////esto guarda este objeto en la base de datos /////////////////	
			miSession.save(usuario1);
			
			//.commit para que se haga fijo
			//.roolback para volver atras si falla
			
			miSession.getTransaction().commit();
			
			System.out.println("Objeto insertado Correctamente en BBDD");
			
			miSession.close();
			
		} finally{
			
			miFactory.close();
			
		}
		
		
		
		
		
	}

}
