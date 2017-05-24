package Domain;

public class Terreno {
	int codTerreno;
	String direccion;
	String formAdquisicion;
	String formaRiego;
	double cantidadTarea;
	String fechaTerreno;
	String cedCliente;
	public boolean resultado;
	
	
	public Terreno(){
		
	}
	public Terreno(int codTerreno, String direccion, String formAdqui, String formRiego,double canTarea,String fechaTerr, String cedCliente ){
		this.codTerreno=codTerreno;
		this.direccion=direccion;
		this.formAdquisicion=formAdqui;
		this.formaRiego=formRiego;
		this.cantidadTarea=canTarea;
		this.fechaTerreno=fechaTerr;
		this.cedCliente=cedCliente;
		
	}
	 public  int getcodTerreno() {
		    return codTerreno;
		    }

	public void setcodTerreno(int codTerreno){
			this.codTerreno=codTerreno;	
			}
	public  String getdireccion() {
			    return direccion;
			    }

	public void setdireccion(String direccion){
				this.direccion=direccion;	
				}
	 public  String getformAdquisicion() {
		    return formAdquisicion;
		    }

	public void setformAdquisicion(String formAdquisicion){
			this.formAdquisicion=formAdquisicion;	
			}
	public  String getformaRiego() {
			    return formaRiego;
			    }

	public void setformaRiego(String formaRiego){
				this.formaRiego=formaRiego;	
				}
	 public  double getcantidadTarea() {
		    return cantidadTarea;
		    }

	public void setcantidadTarea(double cantidadTarea){
			this.cantidadTarea=cantidadTarea;	
			}
	
	public  String getfechaTerreno() {
	    return fechaTerreno;
	    }

	public void setfechaTerreno(String fechaTerreno){
		this.fechaTerreno=fechaTerreno;	
		}
	public  String getcedCliente() {
	    return cedCliente;
	    }

	public void setcedCliente(String cedCliente){
		this.cedCliente=cedCliente;	
		}


}
