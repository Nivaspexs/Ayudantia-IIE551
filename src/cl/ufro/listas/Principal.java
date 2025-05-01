package cl.ufro.listas;

/**
 * Nombre del Programa: Principal
 * 
 * Descripción: JFrame base para la GUI del programa de demostración para trabajar con listas en interfaz gráfica. 
 * 				Ayudantía IIE551 2025-1
 * 				
 * 
 * Autor: Nicolás Vásquez Peña
 * 
 * Referencias: Paquete "utils" y código base desarrollado por Ramiro Donoso.
 * 
 * Fecha: 01-05-2025
 *
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;
import utils.VistaUsuario;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	private List<VistaUsuario> vistas = new ArrayList<VistaUsuario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 350, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Aquí se agregan las vistas 
		
		vistas.add(new VistaLista(this));
		
		//----------------------------
		
		for(int i=0;i<vistas.size();i++)
			contentPane.add(vistas.get(i));
		
		// Vamos a la vista VistaLista.
		verVistaUsuario(VistaLista.class);
		
	}

	public void verVistaUsuario(Class<?> tipoVistaUsuario) {
		for(int i=0;i<vistas.size();i++) {
			VistaUsuario vistaUsuario = vistas.get(i);
			if(tipoVistaUsuario == vistaUsuario.getClass())
				vistaUsuario.mostrar();
			else
				vistaUsuario.ocultar();
		}
	}
}
