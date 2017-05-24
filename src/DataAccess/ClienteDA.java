package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DataAccess.UsuarioDA;
import Domain.Cliente;

public class ClienteDA extends UsuarioDA{

	static PreparedStatement prestat=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd;
	boolean estado;
	
	
	
	public  boolean RegistrarCliente(Cliente unCliente) {
	  try{ 
	  prestat=con.prepareStatement("insert into AguAgroDBA.Clientes (cedCliente, nombre, apellido, direccion, telefono, codEmpleado) "+
			 "values ("+"'"+unCliente.getCedula()+"'"+",'"+unCliente.getNombre()+"','"
			 +unCliente.getApellido()+"','" +unCliente.getDireccion()+"','" +unCliente.getTelefono()+"',"+unCliente.getCodEmpleado()+")");
	 prestat.execute();
	 estado=true;
	 }
	 catch(SQLException e){
	  estado=false;
		}	
	  return estado;
		 }
	

	
	public Cliente ConsultarCliente(String cedula) { 
		Cliente unCliente=new Cliente();
		try{ 	
			prestat=con.prepareStatement("select cedCliente, nombre, apellido, direccion, telefono "
									+ "from AguAgroDBA.Clientes where cedCliente="+"'"+cedula+"'");
			rs=prestat.executeQuery();
	
			if(rs.next()){
			unCliente.setCedula(rs.getString(1));
			unCliente.setNombre(rs.getString(2));
			unCliente.setApellido(rs.getString(3));
			unCliente.setDireccion(rs.getString(4));
			unCliente.setTelefono(rs.getString(5));
			unCliente.resultado=true;
			}
	 }catch(Exception e){
		 unCliente.resultado=false;
		 }
		 return unCliente;
	 }


//
	public boolean ActualizarCliente(Cliente unCliente) {
	 try{ 
		prestat=con.prepareStatement("update AguAgroDBA.Clientes set Nombre= '"+unCliente.getNombre()+
									"',Apellido='"+unCliente.getApellido()+"',Direccion='"+unCliente.getDireccion()+
									"',Telefono='"+unCliente.getTelefono()+"', "+"codEmpleado="+unCliente.getCodEmpleado()
									+ "where cedCliente="+"'"+unCliente.getCedula()+"'");
		prestat.execute();
		estado=true;
	 }catch(Exception e){ 
		 estado=false;	
		
	}
	 return estado;
	}


	public Cliente Consultar(int codigo) {
	Cliente unCliente=new Cliente();
	 try{ 
		 prestat=con.prepareStatement("select c.cedCliente, c.nombre||' '||c.apellido "
		 		+ "from AguAgroDBA.Terrenos t,AguAgroDBA.Clientes c "
		 		+ "where c.cedCliente=t.cedCliente and t.codTerreno="+codigo);
			rs=prestat.executeQuery();
			if(rs.next()){
				unCliente.setNombre(rs.getString(1));
				unCliente.setCedula(rs.getString(2));
				unCliente.resultado=true;	
			}
	}catch(Exception e){
		}
	
	return unCliente;
}

}
