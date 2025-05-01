package cl.ufro.listas;

/**
 * Nombre de la Clase: VistaLista
 * 
 * Descripción: "Vista" (o interfaz) en el que se encuentra el ScrollPane en el que se mostrarán los items de la
 * 				lista. 
 * 				
 * -Ayudantía IIE551 2025-1
 * 				
 * 
 * Autor: Nicolás Vásquez Peña
 * 
 * Referencias: Paquete "utils" y código base desarrollado por Ramiro Donoso.
 * 
 * Fecha: 01-05-2025
 *
 */

import cl.ufro.listas.Principal;
import utils.VistaUsuario;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class VistaLista extends VistaUsuario{
	
	
	//Se declaran los atributos de la clase 
	private JPanel listaPanel;
	private JTextField txtItems;
	private int n;
	private JLabel lblAgregaItems;
	
	
	// Traemos la referencia
	public VistaLista(Principal principal) {
		super();
		super.principal = principal;
	}

	@Override
	public void init() {
		
		// Settear el txt a "0" para evitar inconvenientes
		txtItems.setText("0");
		
		
    	// Aqui se elimina todo y se refresca IMPORTANTE PARA LISTAS DE OPCIONES DINAMICAS
        listaPanel.removeAll();
       
        //Bandera de comprobación
		System.out.println(n);


		/* En caso de obtener los datos de una lista, ustedes tienen que sacarle el tamaño, ej:
		 * 
		 *  List<Objeto> lista = new ArrayList<>();
		 *  n = lista.size();
		 * 
			*/
			for(int i=0;i<n;i++){
				ItemLista item = new ItemLista(this.principal, i+1);	// Creamos el item a medida que se avanza en el for
				item.setLocation(0, 45*i);	// Se le asigna el lugar
				//Container ContainerlistaPanel;	//Container para ordenar (En algunos casos es necesario)
				listaPanel.add(item);	// Se agrega el item al panel dentro del ScrollPane
				listaPanel.setPreferredSize(new Dimension(300, n*45));	//Le asignamos al Panel las dimensiones en base a los items
			}
			listaPanel.repaint();	//Cargamos nuevamente la imagen
		}
	

	@Override
	protected void build() {
		
		// Creamos el ScrollPane
		JScrollPane listacrll = new JScrollPane();
		listacrll.setBounds(25, 70, 300, 600);
		add(listacrll);
		
		// Creamos el JPanel en donde se van a ubicar los items
		listaPanel = new JPanel();
		//Hacemos que el panel sea visible dentro del ScrollPane
		listacrll.setViewportView(listaPanel);
		listaPanel.setLayout(null);

		
		txtItems = new JTextField();
		txtItems.setBounds(151, 39, 114, 19);
		add(txtItems);
		txtItems.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar n listas");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Lo que esté en el JTextField lo pasamos a int OJO que no puse ningún mecanismo de prevención
				n = Integer.parseInt(txtItems.getText().trim());
				//Bandera
				System.out.println("Cambio a "+ n);
				//Aquí obligo al ScrollPane que ponga la barra de desplazamiento si es necesario
				listacrll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				// Llamo al init para actualizar el panel con los items nuevos
				init();

			}
		});
		btnAgregar.setBounds(25, 36, 117, 25);
		add(btnAgregar);
		
		lblAgregaItems = new JLabel("Agrega Items");
		lblAgregaItems.setBounds(114, 12, 140, 15);
		add(lblAgregaItems);

    }
}


