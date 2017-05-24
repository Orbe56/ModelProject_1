package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Domain.Terreno;

public class TerrenoDA extends UsuarioDA{
	
	 PreparedStatement prestat=null;
		ResultSet rs=null;
		boolean estado;
		Statement st;
	
		public Terreno buscarTerreno(int cod) {
		Terreno unTerreno=new Terreno();
		 try{ 
				prestat=con.prepareStatement("select *"
						+ "from AguAgroDBA.Terrenos"
						+ " where codTerreno="+cod);
				rs=prestat.executeQuery();
				if(rs.next()){
					unTerreno.setcodTerreno(rs.getInt(1));
					unTerreno.setdireccion(rs.getString(2));
					unTerreno.setcantidadTarea(rs.getDouble(3));
					unTerreno.setformAdquisicion(rs.getString(4));
					unTerreno.setformaRiego(rs.getString(5));
					unTerreno.setfechaTerreno(rs.getString(6));
					unTerreno.setcedCliente(rs.getString(7));
					
					unTerreno.resultado=true;
				}
		
		}catch(Exception e){ 
			unTerreno.resultado=false;
		}
		 return unTerreno;
		}

	
	public boolean  actualizarTerreno(Terreno unTerreno) {
		 try{ 
			prestat=con.prepareStatement("update AguAgroDBA.Terrenos set Direccion= '"+unTerreno.getdireccion()+
					"',cantidadTarea="+unTerreno.getcantidadTarea()+",FormAdquisicion='"+unTerreno.getformAdquisicion()+
					"',FormaRiego='"+unTerreno.getformaRiego()+"',FechaTerreno='"+unTerreno.getfechaTerreno()+"',cedCliente="+"'"+unTerreno.getcedCliente()+"'"+
					" where codTerreno="+unTerreno.getcodTerreno());
			prestat.execute();
			
			estado=true;
		 	}catch(Exception e){ 
			  estado=false;
		 	}
		 return estado;
		}
	
	

	public boolean registrarTerreno(Terreno unTerreno) {
		try{ 
			prestat=con.prepareStatement("insert into AguAgroDBA.Terrenos ( Direccion, cantidadTarea, formAdquisicion, formaRiego, fechaTerreno, cedCliente) "
					+ "values ('"+unTerreno.getdireccion()+"',"+unTerreno.getcantidadTarea()+",'"+unTerreno.getformAdquisicion()+"','"+unTerreno.getformaRiego()+
					"','"+unTerreno.getfechaTerreno()+"','"+unTerreno.getcedCliente()+"'"+")");
			prestat.execute();
			estado=true;
		}catch(SQLException e){
		 estado=false;
		}
		return estado;
		}
	
	
	
	public long BuscarCodigo(){
		
		long cod=0;
		try {
			prestat=con.prepareStatement("select max(codTerreno) as cod "
					+ "from AguAgroDBA.Terrenos ");
			rs=prestat.executeQuery();
			Object[] guardar=new Object[1];
			
			if(rs.next()){
				
				for(int i=0;i<1;i++){
					guardar[i]=rs.getObject(i+1);
					cod=(long) guardar[i];
				}
			}
		} catch (SQLException e) {
			
		}
		return cod;
		}


	public Terreno Consultar(int codigo) {
		
		Terreno unTerreno=new Terreno();
		
		 try{ 
			  prestat=con.prepareStatement("select codTerreno, cantidadTarea, fechaTerreno, direccion"
			  		+ " from AguAgroDBA.Terrenos "
			  		+ "where codTerreno="+codigo);
				rs=prestat.executeQuery();
				
				if(rs.next()){
					unTerreno.setcodTerreno(rs.getInt(1));
					unTerreno.setcantidadTarea(rs.getDouble(2));
					unTerreno.setfechaTerreno(rs.getString(3));
					unTerreno.setdireccion(rs.getString(4));
					
					unTerreno.resultado=true;
					
				}
		
		}catch(Exception e){ 
			
			unTerreno.resultado=false;
		}
		
		return unTerreno;
	}
}
