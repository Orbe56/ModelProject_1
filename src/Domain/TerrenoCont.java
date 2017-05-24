package Domain;

import javax.swing.JOptionPane;
import DataAccess.TerrenoDA;
import Domain.Terreno;
import View.FormModificarTerreno;
import View.FormRegistrarTerreno;

public class TerrenoCont {

boolean estado=false;




public Terreno BuscarTerreno(String cod) {
	Terreno unTerreno=new Terreno();
		try{
		int codigo=Integer.parseInt(cod);
		TerrenoDA unTerrenoDA=new TerrenoDA();
		 unTerreno=unTerrenoDA.buscarTerreno(codigo);
		
	if((unTerreno.resultado==true)){
		return unTerreno;
	}
	else{
		JOptionPane.showMessageDialog(null, "No existe terreno registrado con ese código " );
		
	}
	}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "Debes ingresar el código del terreno ");	
		
	}
		return unTerreno;
	}


//
public void CrearTerreno( String direccion, String canTarea,
		String formAdqui, String formaR, String fecha, String cedCliente) {
	
	double cant = 0;
	int cod = 0;
	if((direccion.isEmpty())||(formAdqui.isEmpty())||(canTarea.isEmpty())||(formaR.isEmpty())||(fecha.contains("_"))||(cedCliente.contains("_"))){
		JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}
	else{
		try{
			
		cant=Double.parseDouble(canTarea);
		Terreno unTerreno=new Terreno(cod,direccion, formAdqui, formaR, cant,fecha, cedCliente);
		
		TerrenoDA unTerrDA=new TerrenoDA();
		estado=unTerrDA.registrarTerreno(unTerreno);
	if(estado){
		FormRegistrarTerreno.resultado();
		long codigo=unTerrDA.BuscarCodigo();
		JOptionPane.showMessageDialog(null, "Código del terreno registrado: "+codigo );	
	} else{
		JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto o Cliente no registrado");
	}
	}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");	
		}	
	}}

//
	
	public void ModificarTerreno(String codTerre, String direccion, String canTarea,
			String formAdqui, String formaRiego, String fechaTerr, String cedula) {
		
		if(codTerre.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe ingresar el código del terreno y darle al boton buscar");
		}else if((codTerre.isEmpty()==false)&&((direccion.isEmpty())&&(canTarea.isEmpty())&&(formAdqui.isEmpty())&&(formaRiego.isEmpty())&&(fechaTerr.contains("_")==true)&&(cedula.contains("_")==true)))
		{JOptionPane.showMessageDialog(null, "Debe dar clic al boton buscar");}
		else if(((direccion.isEmpty())||(canTarea.isEmpty())||(formAdqui.isEmpty())||(formaRiego.isEmpty())||(fechaTerr.contains("_")==true)||(cedula.contains("_")==true)))
		{JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}else{
		
		
			try{
				int codT=Integer.parseInt(codTerre);
				double tareaCant=Double.parseDouble(canTarea);
	
				Terreno unTerreno=new Terreno(codT,direccion,formAdqui, formaRiego, tareaCant, fechaTerr, cedula);

				TerrenoDA unTerrDA=new TerrenoDA();
				estado=unTerrDA.actualizarTerreno(unTerreno);
				
		if(estado){
			FormModificarTerreno.resultado();
		}else{
			JOptionPane.showMessageDialog(null, "Error al tratar de modificar los datos. Verificar la cédula  del cliente o la fecha");
		}
		}
		catch(NumberFormatException e){	
			
		}	
		}
		
	}
	
	

}
