package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Factura;

public class FacturaDA extends UsuarioDA{
	 
		PreparedStatement prestat=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd;
		
		public ArrayList<Factura> buscarPagos(int year)  {
			
			ArrayList<Factura> Factura=new ArrayList<Factura>();
			Factura unaFactura;	
		try{ 
			prestat = con.prepareStatement("select f.codTerreno, f.fechaRealizoPago,  f.pago, t.direccion "
					+ "from AguAgroDBA.Facturas as f,  AguAgroDBA.Terrenos t "
					+ "where f.codTerreno=t.codTerreno "
				+ "and pagoYear=(select min(pagoYear) from AguAgroDBA.facturas ff where ff.pagoYear>="
					+year+"and ff.codTerreno=f.codTerreno)");
		rs=prestat.executeQuery();
		rsmd=rs.getMetaData();
		int cantidadC=rsmd.getColumnCount();

		while(rs.next()){
			 unaFactura=new Factura();
			
			for(int i=0;i<cantidadC;i++){
				 
				unaFactura.setCodigo(rs.getInt(1));
				unaFactura.setFechaRegPago(rs.getString(2));
				unaFactura.setMonto(rs.getDouble(3));
				unaFactura.setDireccion(rs.getString(4));
				unaFactura.estado=true;
			
				}
			 Factura.add(unaFactura);
		}
		
		}catch(SQLException e){
			
			}
		return Factura;

	}

		
		
		public int ConsultarFecha(int codigo) {
			int ultimoPago = 0;
			
			try
			{
			prestat = con.prepareStatement(" select  f.pagoYear, t.cantidadTarea,  f.cedCliente, c.nombre || ' '|| c.apellido "
					+ "from AguAgroDBA.Facturas  as f, AguAgroDBA.Terrenos as t , AguAgroDBA.Clientes as c"
					+ " where f.pagoYear=(select max(fs.pagoYear) "
					+ "from AguAgroDBA.Facturas as fs where fs.codTerreno=f.codTerreno) "
					+ "and f.cedCliente=t.cedCliente "
					+ "and c.cedCliente=f.cedCliente"
					+ " and c.cedCliente=t.cedCliente "
					+ "and f.codTerreno="+codigo);
			rs=prestat.executeQuery();
			
			
			if(rs.next()){
				
				ultimoPago=(rs.getInt(1));
				
			}else{
				}}catch(Exception e){
					ultimoPago=0;
					
				}
			return ultimoPago;
			
			}
		
		
		public boolean Guardar(Factura unaFactura,  int codigo,  String cedC) {
			try
			{prestat=con.prepareStatement("insert into AguAgroDBA.Facturas (pagoYear, pago,  codTerreno, codEmpleado, cedCliente, fechaRealizoPago) values ("
											+unaFactura.getYearApagar()+","+unaFactura.getMonto()+","+codigo+","+unaFactura.getCodEmpleado()+",'"
											+cedC+"','"+unaFactura.getFechaRegPago()+"'"+")");
			
			prestat.execute();
		
			estado=true;
			
		}
		catch(Exception e){
			estado=false;
			
		}	
			return estado;
		}
		
		
		
		public static Boolean verify(){
			try{
				
				PreparedStatement pres = con.prepareStatement(" select  *from AguAgroDBA.Facturas");
				pres.executeQuery();
				return true;
			}catch(Exception e){
				return false;
				}
			}
}
