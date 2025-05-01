package utils;

import javax.swing.JPanel;

import cl.ufro.listas.Principal;

import javax.swing.JFrame;

public abstract class VistaUsuario extends JPanel {

	protected Principal principal;
	
	public VistaUsuario() {
		setBounds(0, 0, 350, 700);//Principal.WIDTH, Principal.HEIGHT);//principal.getWidth(), principal.getHeight());
		setLayout(null);
		build();
	}

	public void mostrar() {
		init();
		setVisible(true);		
	}
	public void ocultar() {
		setVisible(false);		
	}
	// Para inicializar la vista de usuario
	public abstract void init();
	// Para entorno gráfico
	protected abstract void build();
}