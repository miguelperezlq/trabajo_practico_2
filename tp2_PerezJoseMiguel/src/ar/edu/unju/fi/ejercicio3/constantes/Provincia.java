package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(1500000,20000), 
	SALTA(2000000,30000), 
	TUCUMAN(12500000,25000), 
	CATAMARCA(700000,17000), 
	LA_RIOJA(600000,15000), 
	SANTIAGO_DEL_ESTERO(250000,35000);
	
	private int cantidadPoblacion;
	private int superficie;
	
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional() {
		return (double) cantidadPoblacion/superficie;
	}
	
	
	

}
