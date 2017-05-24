package Domain;

public class Cliente {

	 String cedula;
	 String  nombre;
	 String apellido;
	 String direccion;
	 String telefono;
	 int codEmpleado;
	 public boolean resultado;
	 
public Cliente(){}	 
public Cliente(int codEmpleado, String cedula,String nombre, String apellido,String direccion, String telefono)
{
	this.codEmpleado=codEmpleado;
	this.nombre=nombre;
	this.apellido=apellido;
	this.cedula=cedula;
	this.direccion=direccion;
	this.telefono=telefono;

}
	
	public void setCedula(String cedula){
		this.cedula=cedula;	
		}
	
		public void setNombre(String nombre){
			this.nombre=nombre;	
		}
	
		public void setApellido(String apellido){
			this.apellido=apellido;	
			}
		public void setDireccion(String direccion){
		this.direccion=direccion;
		
	}
		public void setTelefono(String telefono){
			this.telefono=telefono;
			
		}
		public void setCodEmpleado(int codEmpleado){
		this.codEmpleado=codEmpleado;
			
	}
		public String getNombre() {
		    return nombre;
		    }
		 public  String getCedula() {
			    return cedula;
			    }

		
		public String getApellido() {
		    return apellido;
		    }

		
		public String getDireccion(){
			return direccion;
		}
		
		public String getTelefono(){
			return telefono;
		}
		
		public int getCodEmpleado(){
			return codEmpleado;
		}

		
}
