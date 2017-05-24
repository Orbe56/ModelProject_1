package Domain;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import DataAccess.ClienteDA;
import DataAccess.FacturaDA;
import DataAccess.TerrenoDA;
import Domain.Cliente;
import Domain.Factura;
import Domain.Terreno;
import View.FormConsultarPagos;
import View.FormFacturarPago;

public class FacturaCont {


	//
	public void consultarPagos(String year1) {
		
	if(year1.contains(" ")==true){
		JOptionPane.showMessageDialog(null, "Debes ingresar 4 dígitos en el campo año a consultar");	
		}
	else{	
		int year=Integer.parseInt(year1);
		FacturaDA fact=new FacturaDA();
		ArrayList<Factura> unaFact=fact.buscarPagos(year);
		
		if((unaFact.isEmpty()==false)){
			
			FormConsultarPagos.mostrarPagos(unaFact);
		}
		else{
			JOptionPane.showMessageDialog(null, "No se han realizado pagos para ese año");}
		}
	}

	

	public void ConsultarDatos(String codTerr, String yearApagar) {
		
		if((codTerr.isEmpty())){
			JOptionPane.showMessageDialog(null, "Primero debe llenar los campos año a pagar y código de terreno ");
			}
		else if((codTerr.isEmpty()==false)&&(yearApagar.contains(" ")==true)){
			JOptionPane.showMessageDialog(null, "Debe ingresar 4 dígitos en año a pagar");
		}
		else{
			
			int year=Integer.parseInt(yearApagar);
			int codigo=Integer.parseInt(codTerr);
			FacturaDA unaFacturaDA=new FacturaDA();
			int ultimaFecha=unaFacturaDA.ConsultarFecha(codigo);
		
		   if((ultimaFecha!=0)){
			  
			   
			   obtenerDatos(codigo, ultimaFecha, year);	
				}
		  
			else{
				obtenerDatos(codigo, ultimaFecha,year);		
			}
			} 
	}
	
	
	public void obtenerDatos(int codigo, int ultimaFecha, int year){
		Terreno unTerreno=new Terreno();
		TerrenoDA unTerrDA=new TerrenoDA();
		unTerreno=unTerrDA.Consultar(codigo);
		if((unTerreno!=null)&&(unTerreno.resultado==true)&&(ultimaFecha==0)){
			ultimaFecha=Integer.parseInt(unTerreno.getfechaTerreno().substring(0,4));
			}
	    try{
			if((unTerreno!=null)&&(unTerreno.resultado==true)){
		double cantidad=CalcularMonto( ultimaFecha,unTerreno.getcantidadTarea(), year);
		Cliente unCliente=new Cliente();
		ClienteDA unCliDA=new ClienteDA();
		unCliente=unCliDA.Consultar(codigo);
		FormFacturarPago.mostrarDatos(unCliente.getCedula(),unCliente.getNombre(),cantidad);}
	else{
			JOptionPane.showMessageDialog(null, "Código de terreno no registrado");
		}
		}catch(Exception e){e.printStackTrace();}
	}
		
	

	private double CalcularMonto(int ultimoPago, double canTarea, int aPagar) {
			
			
			double tiempo=aPagar-ultimoPago;
			double cantidad;
			double monto = 0;
		if(tiempo<=0){
			JOptionPane.showMessageDialog(null, "A esa año ingresado no tiene deuda");
		}else{
		if(canTarea<=110){
			cantidad=67.30;
		}
		else{
			cantidad=134.60;
			}
			monto=tiempo*canTarea*cantidad;
			}
		return Math.round(monto*100)/100D;
	}
	
//	
	public boolean Guardar(String year, String monto, String codTerreno, String codEmpl,
		String cedCliente) {
		boolean valor = false;
		String fA;
	fA=fechaHoy();
	
	 if((year.isEmpty())||(codTerreno.isEmpty())){
		JOptionPane.showMessageDialog(null, "Debe llenar los campos año a pagar/código terreno y darle clic al boton buscar ");
		 
	 }
	 else if((year.isEmpty()==false)&&(codTerreno.isEmpty()==false)&&(monto.isEmpty())&&(codEmpl.isEmpty())&&(cedCliente.contains("_"))){
		 JOptionPane.showMessageDialog(null, "Debe dar clic al boton buscar "); 
	 } 
	 else if((monto.isEmpty())||(codEmpl.isEmpty())||(cedCliente.contains("_"))){
		 JOptionPane.showMessageDialog(null, "Debe llenar todos los campos"); 
	 }
	
	else{	
		Factura unaFact=new Factura();
		unaFact.setMonto(Double.parseDouble(monto));
		if(unaFact.getMonto()<=0){
			 JOptionPane.showMessageDialog(null, "El monto a pagar debe ser mayor a 0"); 
		}

	unaFact.setCodEmpleado(Integer.parseInt(codEmpl));
	unaFact.setYearApagar(Integer.parseInt(year));
	unaFact.setFechaRegPago(fA);
	int codigo=Integer.parseInt(codTerreno);
	
		if(unaFact.getMonto()!=0){
			
			FacturaDA unaFactura=new FacturaDA(); 
			boolean estado=unaFactura.Guardar( unaFact,codigo, cedCliente);
		if(estado){
		JOptionPane.showMessageDialog(null, "Datos Guardados");
		valor=true;
				}}}
	 return valor;
	}
	
	//

	private String fechaHoy() {
		Calendar fech = Calendar.getInstance();
		int año = fech  .get(Calendar.YEAR);
		int mes = fech.get(Calendar.MONTH) + 1;
		int dia = fech.get(Calendar.DAY_OF_MONTH);
		String fechaH=dia+"."+mes+"."+año;
		return fechaH;
	}

}
