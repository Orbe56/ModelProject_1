package Domain;

import javax.swing.JOptionPane;

import DataAccess.ClienteDA;
import Domain.Cliente;
import View.FormModificarCliente;

public class ClienteCont {

	
		 public boolean crearCliente(String cedula, String nombre, String apellido,
					String direccion, String telefono, String codEmp) {
			 boolean estado=false;
			 if (cedula.contains("_")){
				 JOptionPane.showMessageDialog(null, "Debe llenar todos los campos ");
				 }
				else if((cedula.contains("_"))||(nombre.isEmpty())||(apellido.isEmpty())||(direccion.isEmpty())||(telefono.contains("_"))){
				 JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");}
				else{
					try{ int cod=Integer.parseInt(codEmp);
					
				Cliente unCliente=new Cliente(cod,cedula,nombre,apellido,direccion,telefono);

					 ClienteDA unClientDA=new ClienteDA();
					 estado=unClientDA.RegistrarCliente(unCliente); 
					 if (estado){
					JOptionPane.showMessageDialog(null, "El cliente fue registrado exitosamente");
				 }
				 else{
				 JOptionPane.showMessageDialog(null, "Error número de cédula ya existente o código de empleado incorrecto");	
			 }
			}		
		 catch( NumberFormatException e){
			 JOptionPane.showMessageDialog(null, "Debe llenar todos los campos"); 
		 }
		 }
			 return estado;
			 }
		 
		 
		 //
		 public Cliente BuscarCliente(String cedula)  {
			 Cliente unCliente =new Cliente();
			if (cedula.contains("_")==true){
			JOptionPane.showMessageDialog(null, "Debe ingresar  el número de cédula del cliente");
			}else{
			
			ClienteDA clienteDA=new ClienteDA();
			unCliente = clienteDA.ConsultarCliente(cedula);
				if((unCliente.resultado==true)){
					return unCliente;
				}
				else if(unCliente.resultado==false){
					JOptionPane.showMessageDialog(null, "No existe ningun cliente con ese número de cédula " );
				} 	
			}
			return  unCliente;
	}
		


		
	//
		public void ModificarCliente(String cedula, String nombre, String apellido,
				String direccion, String telefono, String codEmp) {
			
			if (cedula.contains("_")){
			 JOptionPane.showMessageDialog(null, "Debe ingresar primero el número de cédula del cliente y darle al boton buscar ");}
			
			else if((cedula.contains("_")==false)&&(nombre.isEmpty())&&(apellido.isEmpty())&&(direccion.isEmpty())&&(telefono.contains("_")==true))
			 {
				  JOptionPane.showMessageDialog(null, "Debe darle clic al boton buscar ");}
			else if((nombre.isEmpty())||(apellido.isEmpty())||(direccion.isEmpty())||(codEmp.isEmpty())){
			 JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");}
			else{
			ClienteDA unClienteDA= new ClienteDA();
				int cod=Integer.parseInt(codEmp);
				Cliente unCliente=new Cliente(cod,cedula,nombre,apellido,direccion,telefono);
				
			boolean estado=unClienteDA.ActualizarCliente(unCliente);	
			if(estado){
				FormModificarCliente.resultado();
			}
			else{
				JOptionPane.showMessageDialog(null, "Error. Verificar código Empleado  . ");
				}
			}
			}

		
}
