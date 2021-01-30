package es.pildoras.conexion.hibernate;


import javax.persistence.*;


@Entity
@Table(name="usuarios")

public class usuarios {
	
	
	@Id
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="email")
	private String email;
	

	public usuarios(String nombreUsuario, String pass, String email) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.email = email;

	}

	public usuarios() {
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
}
