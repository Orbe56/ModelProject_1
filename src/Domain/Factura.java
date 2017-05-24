package Domain;

import Domain.Terreno;

public class Factura {
	
int yearApagar;
double monto;
String fechaRegPago;
int codEmpleado;
int codigo;
public boolean estado;
public Terreno unTerreno=new Terreno();

public int getYearApagar(){
	return yearApagar;	
}
public void setYearApagar(int yearApagar){
	this.yearApagar=yearApagar;
}
public double getMonto(){
	return monto;
}
public void setMonto(double monto){
	this.monto=monto;
}

public String getFechaRegPago(){
	return fechaRegPago;
}
public void setFechaRegPago(String fechaRegPago){
	this.fechaRegPago=fechaRegPago;
	
}
public int getCodEmpleado(){
return codEmpleado;
}
public void setCodEmpleado(int codEmpleado){
	this.codEmpleado=codEmpleado;
}
public int getCodigo(){
	return codigo;	
}
public void setCodigo(int codigo){
	this.codigo=codigo;
}

public void setDireccion(String direccion){
	unTerreno.setdireccion(direccion);
		
}

public String getDirreccion(){
	return unTerreno.getdireccion();
		
}


}
