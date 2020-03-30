package co.edu.unbosque.model;

public class Jugar {

	private Humano humano;
	private Personajes personajes;

	public Jugar() {
		humano= new Humano();
		personajes= new Personajes();
	}
	
	public Humano getHumano() {
		return humano;
	}
	public void setHumano(Humano humano) {
		this.humano = humano;
	}

	public Personajes getPersonajes() {
		return personajes;
	}
	public void setPersonajes(Personajes personajes) {
		this.personajes = personajes;
	}
	
	
}
