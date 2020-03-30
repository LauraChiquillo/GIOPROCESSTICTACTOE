package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.Jugar;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View ventana;
	private Jugar jugar;
	private String letra;

	public Controller() throws ParseException {
		ventana = new View();
		jugar = new Jugar();
		ventana.getJuego().addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand().equals("Juego")) {
			if (ventana.getTablero().asignarValorJugador(letra)) {
				ventana.getTablero().turnosComputador();
				ventana.getTablero().verifica();
				if (ventana.getTablero().verificarGanoComputador()) {
					ventana.mensaje("¡ Ja, ja te gane humano !");
				} else if (ventana.getTablero().verificarGanoJugador()) {
					ventana.mensaje("Hmm, me ganates, ¡ qué aburrido !");
				} else if (ventana.getTablero().verificarEmpate()) {
					ventana.mensaje("Empate. No pudimos");
				}
			}else {
				ventana.mensaje("Es su turno, ¡ reacciona humano !");
			}
		}
	}
}
