package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PanelTablero extends JPanel {

	private JFormattedTextField[][] tabla;
	private int[][] gano;
	private int filas;
	private int columnas;

	public PanelTablero() throws ParseException {

		setLayout(null);

		filas = 3;
		columnas = 3;
		iniciarTablero();
		agregarTabla();
		configurarPanel();
		actualizarTablero();
	}

	public void configurarPanel() {
		this.setVisible(true);
		this.setLayout(new GridLayout(this.filas, this.columnas));
	}

	// al utilizar el MaskFormatter nos permite que el usuuario solo pueda digitar
	// una vez
	public void iniciarTablero() throws ParseException {
		tabla = new JFormattedTextField[filas][columnas];
		gano = new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tabla[i][j] = new JFormattedTextField(new MaskFormatter("?"));
				gano[i][j] = 0;
			}
		}
	}

	public void agregarTabla() {
		for (int i = 0; i < this.filas; i++) {

			for (int j = 0; j < this.columnas; j++) {

				this.add(this.tabla[i][j]);
			}
		}
	}

	public void actualizarTablero() {

		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				JTextField tab = tabla[i][j];
			}
		}
	}

	public boolean asignarValorJugador(String a) {
		boolean turno = false;
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				if ((tabla[i][j].isEditValid()) && (gano[i][j] == 0)) {
					tabla[i][j].setActionCommand(a);
					tabla[i][j].setEditable(false);
					gano[i][j] = 2;
					turno = true;
				} else {

				}
			}
		}
		return turno;

	}

	public boolean turnosComputador() {
		boolean turno = true;
		if (turnoComputador1() == true) {
			turno = false;
		} else if (turnoComputador2() == true) {
			turno = false;
		} else if (turnoComputador3() == true) {

		}
		return turno;
	}

	public boolean turnoComputador1() {
		boolean aux = false;
		if ((gano[0][1] == 1 && gano[0][2] == 1 && gano[0][0] == 0)
				|| (gano[1][0] == 1 && gano[2][0] == 1 && gano[0][0] == 0)
				|| (gano[1][1] == 1 && gano[2][2] == 1 && gano[0][0] == 0)) {
			darcomputador(0);
			gano[0][0] = 1;
			tabla[0][0].setEditable(false);
			aux = true;
		} else if ((gano[0][0] == 1 && gano[0][2] == 1 && gano[0][1] == 0)
				|| (gano[1][1] == 1 && gano[2][1] == 1 && gano[0][1] == 0)) {
			tabla[0][1].setEditable(false);
			darcomputador(1);
			gano[0][1] = 1;
			aux = true;
		} else if ((gano[0][0] == 1 && gano[0][1] == 1 && gano[0][2] == 0)
				|| (gano[1][2] == 1 && gano[2][2] == 1 && gano[0][2] == 0)
				|| (gano[1][1] == 2 && gano[2][0] == 2 && gano[0][2] == 0)) {
			darcomputador(2);
			gano[0][2] = 1;
			tabla[0][2].setEditable(false);
			aux = true;
		} else if ((gano[1][1] == 1 && gano[1][2] == 1 && gano[1][0] == 0)
				|| (gano[0][0] == 1 && gano[2][0] == 1 && gano[1][0] == 0)) {
			darcomputador(3);
			gano[1][0] = 1;
			tabla[1][0].setEditable(false);
			aux = true;
		} else if ((gano[1][0] == 1 && gano[1][2] == 1 && gano[1][1] == 0)
				|| (gano[0][1] == 1 && gano[2][1] == 1 && gano[1][1] == 0)) {
			darcomputador(4);
			gano[1][1] = 1;
			tabla[1][1].setEditable(false);
			aux = true;
		} else if ((gano[1][0] == 1 && gano[1][1] == 1 && gano[1][2] == 0)
				|| (gano[0][2] == 1 && gano[2][2] == 1 && gano[1][2] == 0)) {
			darcomputador(5);
			gano[1][2] = 1;
			tabla[1][2].setEditable(false);
			aux = true;
		} else if ((gano[2][1] == 1 && gano[2][2] == 1 && gano[2][0] == 0)
				|| (gano[0][0] == 1 && gano[1][0] == 1 && gano[2][0] == 0)
				|| (gano[1][1] == 1 && gano[0][2] == 1 && gano[2][0] == 0)) {
			darcomputador(6);
			gano[2][0] = 1;
			tabla[2][0].setEditable(false);
			aux = true;
		} else if ((gano[2][0] == 1 && gano[2][2] == 1 && gano[2][1] == 0)
				|| (gano[0][1] == 1 && gano[1][1] == 1 && gano[2][1] == 0)) {
			darcomputador(7);
			gano[2][1] = 1;
			tabla[2][1].setEditable(false);
			aux = true;
		} else if ((gano[2][0] == 1 && gano[2][1] == 1 && gano[2][2] == 0)
				|| (gano[0][2] == 1 && gano[1][2] == 1 && gano[2][2] == 0)
				|| (gano[0][0] == 1 && gano[1][1] == 1 && gano[2][2] == 0)) {
			darcomputador(8);
			gano[2][2] = 1;
			tabla[2][2].setEditable(false);
			aux = true;
		}
		return aux;

	}

	public boolean turnoComputador2() {
		boolean aux = false;
		if ((gano[1][1] == 0)) {
			darcomputador(4);
			gano[1][1] = 1;
			tabla[1][1].setEditable(false);
			aux = true;
		} else if ((gano[0][1] == 2 && gano[0][2] == 2 && gano[0][0] == 0)
				|| (gano[1][0] == 2 && gano[2][0] == 2 && gano[0][0] == 0)
				|| (gano[1][1] == 2 && gano[2][2] == 2 && gano[0][0] == 0)) {
			darcomputador(0);
			gano[0][0] = 1;
			tabla[0][0].setEditable(false);
			aux = true;
		} else if ((gano[0][0] == 2 && gano[0][2] == 2 && gano[0][1] == 0)
				|| (gano[1][1] == 2 && gano[2][1] == 2 && gano[0][1] == 0)) {
			tabla[0][1].setEditable(false);
			darcomputador(1);
			gano[0][1] = 1;
			aux = true;
		} else if ((gano[0][0] == 2 && gano[0][1] == 2 && gano[0][2] == 0)
				|| (gano[1][2] == 2 && gano[2][2] == 2 && gano[0][2] == 0)
				|| (gano[1][1] == 2 && gano[2][0] == 2 && gano[0][2] == 0)) {
			darcomputador(2);
			gano[0][2] = 1;
			tabla[0][2].setEditable(false);
			aux = true;
		} else if ((gano[1][1] == 2 && gano[1][2] == 2 && gano[1][0] == 0)
				|| (gano[0][0] == 2 && gano[2][0] == 2 && gano[1][0] == 0)) {
			darcomputador(3);
			gano[1][0] = 1;
			tabla[1][0].setEditable(false);
			aux = true;
		} else if ((gano[1][0] == 2 && gano[1][2] == 2 && gano[1][1] == 0)
				|| (gano[0][1] == 2 && gano[2][1] == 2 && gano[1][1] == 0)) {
			darcomputador(4);
			gano[1][1] = 1;
			tabla[1][1].setEditable(false);
			aux = true;
		} else if ((gano[1][0] == 2 && gano[1][1] == 2 && gano[1][2] == 0)
				|| (gano[0][2] == 2 && gano[2][2] == 2 && gano[1][2] == 0)) {
			darcomputador(5);
			gano[1][2] = 1;
			tabla[1][2].setEditable(false);
			aux = true;
		} else if ((gano[2][1] == 2 && gano[2][2] == 2 && gano[2][0] == 0)
				|| (gano[0][0] == 2 && gano[1][0] == 2 && gano[2][0] == 0)
				|| (gano[1][1] == 2 && gano[0][2] == 2 && gano[2][0] == 0)) {
			darcomputador(6);
			gano[2][0] = 1;
			tabla[2][0].setEditable(false);
			aux = true;
		} else if ((gano[2][0] == 2 && gano[2][2] == 2 && gano[2][1] == 0)
				|| (gano[0][1] == 2 && gano[1][1] == 2 && gano[2][1] == 0)) {
			darcomputador(7);
			gano[2][1] = 1;
			tabla[2][1].setEditable(false);
			aux = true;
		} else if ((gano[2][0] == 2 && gano[2][1] == 2 && gano[2][2] == 0)
				|| (gano[0][2] == 2 && gano[1][2] == 2 && gano[2][2] == 0)
				|| (gano[0][0] == 2 && gano[1][1] == 2 && gano[2][2] == 0)) {
			darcomputador(8);
			gano[2][2] = 1;
			tabla[2][2].setEditable(false);
			aux = true;
		} else if (gano[1][1] == 2) {
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					if (gano[i][j] == 0) {
						darcomputador(0);
						gano[0][0] = 1;
						tabla[0][0].setEditable(false);
						aux = true;
					}
				}
			}
		}
		return aux;

	}

	public boolean turnoComputador3() {
		boolean aux = false;
		if ((gano[0][1] == 1 && gano[1][1] == 1 && gano[2][1] == 2 && gano[1][0] == 0)
				|| gano[0][0] == 2 && gano[2][2] == 2 && gano[1][0] == 0) {
			darcomputador(3);
			gano[1][0] = 1;
			tabla[1][0].setEditable(false);
			aux = true;
		} else if (gano[0][1] == 2 && gano[1][1] == 1 && gano[2][1] == 1 && gano[0][2] == 0) {
			darcomputador(2);
			gano[0][2] = 1;
			tabla[0][2].setEditable(false);
			aux = true;
		} else if (gano[0][1] == 2 && gano[1][1] == 1 && gano[2][1] == 1 && gano[0][2] == 1 && gano[2][2] == 2
				&& gano[0][0] == 0) {
			darcomputador(0);
			gano[0][0] = 1;
			tabla[0][0].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 2 && gano[0][1] == 2 && gano[0][2] == 1 && gano[1][0] == 1 && gano[1][1] == 1
				&& gano[1][2] == 2 && gano[2][0] == 2 && gano[2][1] == 0) {

			darcomputador(7);
			gano[2][1] = 1;
			tabla[2][1].setEditable(false);
			aux = true;
		} else if (gano[2][2] == 2 && gano[1][1] == 1 && gano[0][2] == 2 && gano[1][2] == 1 && gano[1][0] == 2
				&& gano[0][0] == 0) {
			darcomputador(0);
			gano[0][0] = 1;
			tabla[0][0].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 2 && gano[1][1] == 1 && gano[0][2] == 2 && gano[0][1] == 1 && gano[2][1] == 2
				&& gano[2][0] == 1 && gano[1][0] == 2 && gano[2][2] == 0) {
			darcomputador(8);
			gano[2][2] = 1;
			tabla[2][2].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 2 && gano[1][0] == 1 && gano[2][0] == 2 && gano[1][1] == 1 && gano[1][2] == 2
				&& gano[0][1] == 0) {
			darcomputador(1);
			gano[0][1] = 1;
			tabla[0][1].setEditable(false);
			aux = true;
		} else if (gano[0][2] == 2 && gano[2][0] == 2 && gano[1][2] == 0) {
			darcomputador(5);
			gano[1][2] = 1;
			tabla[1][2].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 2 && gano[1][1] == 1 && gano[2][1] == 2 && gano[0][2] == 0) {

			darcomputador(2);
			gano[0][2] = 1;
			tabla[0][2].setEditable(false);
			aux = true;
		} else if (gano[0][1] == 2 && gano[1][1] == 1 && gano[2][1] == 2 && gano[1][0] == 0) {
			darcomputador(3);
			gano[1][0] = 1;
			tabla[1][0].setEditable(false);
			aux = true;
		} else if (gano[0][1] == 2 && gano[1][1] == 1 && gano[2][1] == 2 && gano[1][0] == 1 && gano[0][0] == 0) {
			darcomputador(0);
			gano[0][0] = 1;
			tabla[0][0].setEditable(false);
			aux = true;
		} else if (gano[1][0] == 2 && gano[1][1] == 1 && gano[1][2] == 2 && gano[0][1] == 1 && gano[2][2] == 0) {
			darcomputador(8);
			gano[2][2] = 1;
			tabla[2][2].setEditable(false);
			aux = true;
		}
		return aux;
	}

	public boolean verifica() {
		boolean aux = false;
		if (gano[0][0] == 1 && gano[1][1] == 2 && gano[2][2] == 2 && gano[2][1] == 0) {
			darcomputador(7);
			gano[2][1] = 1;
			tabla[2][1].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 1 && gano[0][1] == 2 && gano[1][1] == 2 && gano[2][1] == 1 && gano[2][2] == 2
				&& gano[0][2] == 0) {
			darcomputador(2);
			gano[0][2] = 1;
			tabla[0][2].setEditable(false);
			aux = true;
		} else if (gano[0][0] == 1 && gano[0][1] == 2 && gano[1][1] == 2 && gano[2][1] == 1 && gano[2][2] == 2
				&& gano[0][2] == 1 && gano[1][0] == 0) {
			darcomputador(3);
			gano[1][0] = 1;
			tabla[1][0].setEditable(false);
			aux = true;
		}
		return aux;
	}

	public void darcomputador(int aux) {

		switch (aux) {
		case 0:
			tabla[0][0].setText("O");
			break;
		case 1:
			tabla[0][1].setText("O");
			break;
		case 2:
			tabla[0][2].setText("O");
			break;
		case 3:
			tabla[1][0].setText("O");
			break;
		case 4:
			tabla[1][1].setText("O");
			break;
		case 5:
			tabla[1][2].setText("O");
			break;
		case 6:
			tabla[2][0].setText("O");
			break;
		case 7:
			tabla[2][1].setText("O");
			break;
		case 8:
			tabla[2][2].setText("O");
			break;
		}
	}

	public boolean verificarEmpate() {
		boolean ganar = false;
		int cont = 0;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (gano[i][j] == 1 || gano[i][j] == 2) {
					cont++;
				}
			}
			if (cont == 8) {
				ganar = true;
			}
		}
		return ganar;
	}

	public boolean verificarGanoComputador() {
		boolean ganar = false;
		if (validarDiagonalesComputador() || validarFilasComputador() || validarColumnasComputador()) {
			ganar = true;
		} else {

		}
		return ganar;
	}

	public boolean verificarGanoJugador() {
		boolean ganar = false;
		if (validarDiagonalesJugador() || validarFilasJugador() || validarColumnasJugador()) {
			ganar = true;
		} else {

		}
		return ganar;
	}

	public boolean validarDiagonalesComputador() {
		boolean rta = false;
		int cont = 0;
		for (int i = 0; i < filas; i++) {
			if (gano[i][i] == 1) {
				cont++;
			}
		}
		if (cont == 3) {
			rta = true;
		}
		if (rta == false) {
			cont = 0;
			int f = filas - 1;
			for (int i = 0; i < filas && f >= 0; i++) {
				if (gano[f][i] == 1) {
					cont++;
				}
				f--;
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}

	public boolean validarDiagonalesJugador() {
		boolean rta = false;
		int cont = 0;
		for (int i = 0; i < filas; i++) {
			if (gano[i][i] == 2) {
				cont++;
			}
		}
		if (cont == 3) {
			rta = true;
		}
		if (rta == false) {
			cont = 0;
			int f = filas - 1;
			for (int i = 0; i < filas && f >= 0; i++) {
				if (gano[f][i] == 2) {
					cont++;
				}
				f--;
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}

	public boolean validarFilasComputador() {
		boolean rta = false;
		for (int i = 0; i < filas && rta == false; i++) {
			int cont = 0;
			for (int j = 0; j < columnas; j++) {
				if (gano[i][j] == 1) {
					cont++;
				}
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}

	public boolean validarFilasJugador() {
		boolean rta = false;
		for (int i = 0; i < filas && rta == false; i++) {
			int cont = 0;
			for (int j = 0; j < columnas; j++) {
				if (gano[i][j] == 2) {
					cont++;
				}
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}

	public boolean validarColumnasComputador() {
		boolean rta = false;
		for (int j = 0; j < columnas && rta == false; j++) {
			int cont = 0;
			for (int i = 0; i < filas; i++) {
				if (gano[i][j] == 1) {
					cont++;
				}
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}

	public boolean validarColumnasJugador() {
		boolean rta = false;
		for (int j = 0; j < columnas && rta == false; j++) {
			int cont = 0;
			for (int i = 0; i < filas; i++) {
				if (gano[i][j] == 2) {
					cont++;
				}
			}
			if (cont == 3) {
				rta = true;
			}
		}
		return rta;
	}
}