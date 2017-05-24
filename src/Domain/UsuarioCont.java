package Domain;

import javax.swing.JOptionPane;

import DataAccess.FacturaDA;
import DataAccess.UsuarioDA;
import Domain.Usuario;
import View.MenuPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;


import View.MenuPrincipalC;

public class UsuarioCont {
	boolean estado;

	public boolean iniciarSesion(String id, String clave) {
			
			if (id==""||clave==""){
				JOptionPane.showMessageDialog(null, "Debe ingresar su usuario y contraseña");	
			}
			else{
				try{
				Usuario unUser= new Usuario(id,clave);	
			UsuarioDA unUserDA=new UsuarioDA();
			estado=unUserDA.EnviarUsuario(unUser);
		
		if(estado){
		
		//Usado para mostrar el menu correspondiente al usuario.
		MenuPrincipalC menuC=new MenuPrincipalC();
	/*if(FacturaDA.verify()){
			MenuPrincipalC menuC=new MenuPrincipalC();
			menuC.setVisible(true);	
		}else{
			MenuPrincipal menu=new MenuPrincipal();
			menu.setVisible(true);
		}*/
		}
		else{
		JOptionPane.showMessageDialog(null, "Error de Conexión, Usuario o contraseña incorrecto");		
		estado=false;
			}
			}catch(Exception e){}	
			}
		return estado;
			}

}
