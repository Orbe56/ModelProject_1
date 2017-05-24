package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

import Domain.Usuario;

public class UsuarioDA {

	public static Connection con;

	static boolean estado;

	public boolean EnviarUsuario(Usuario unUser) {
		
		try{ 
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			con = DriverManager.getConnection("jdbc:derby://localhost:1527/testdb;user="+unUser.getId()+";password="+unUser.getClave());
		 estado=true;	 
		}catch(Exception e){ 
		
		estado=false;
		}	
		return estado;
		}
		

	Connection conectar()  {
		return con;	
		}
		

}
