package co.edu.unbosque.view;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class View extends JFrame{
	 
		
	private PanelTablero tablero;
	private JButton juego;
	public View() throws ParseException {
		setTitle("tIctActoe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,320);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		tablero= new PanelTablero();
		tablero.setBounds(20,30,300,200);
		add(tablero);
		
		juego= new JButton("Juego");
		juego.setBounds(130,240,80,30);
		add(juego);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void mensaje(String dato) {
		JOptionPane.showMessageDialog(null,dato);
	}

	public PanelTablero getTablero() {
		return tablero;
	}

	public void setTablero(PanelTablero tablero) {
		this.tablero = tablero;
	}

	public JButton getJuego() {
		return juego;
	}

	public void setJuego(JButton juego) {
		this.juego = juego;
	}
}
