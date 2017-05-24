package Domain;

public class Usuario {

	String id;
	String clave;
	boolean resultado;

	public Usuario(){}
	public Usuario(String id,String contrasena){
		this.id=id;
		this.clave=contrasena;
		
	}
	public String getId() {
	    return id;
	    }

	public void setId(String id){
		this.id=id;	
		}

	public String getClave(){
		return clave;
		}

	public void setClave(String contrasena){
		this.clave=contrasena;	
		}


}
