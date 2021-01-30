package es.pildoras.pruebas.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {

		String JDBCurl = "jdbc:mysql://localhost:3306/login?useSSL=false";

		String usuario = "usuario";

		String pass = "usuario";

		try {

			System.out.println("Intentando conectar con la BBDD:" + JDBCurl);

			Connection miConexion = DriverManager.getConnection(JDBCurl, usuario, pass);

			System.out.println("Conexion exitosa");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
