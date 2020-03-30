package co.edu.unbosque.model;

public class Personajes extends Movimientos{
	
	public String validarLetraIngresada(String dato) {
		String a= "X";
		if (dato != a) {
			return null;
		}if (dato== "x") {
			return a;
		}
		return a;
	}
}
