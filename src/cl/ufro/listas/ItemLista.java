package cl.ufro.listas;

/**
 * Nombre de la Clase: ItemLista
 * 
 * Descripción: Este es el item a mostrarse en VistaLista. 
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

import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class ItemLista extends JPanel {
	
	private Principal principal;
	
	// Hago la referencoa
	public ItemLista (Principal referencia, int n_lista) {
		this.principal=referencia;
		// Declaro medidas del item
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		setSize(300, 45);
		
		//Creo el label dentro del item
		JLabel lblItem = new JLabel("Item "+ n_lista); //Aquí le establezco el texto del label
		lblItem.setBounds(86, 18, 70, 15);
		add(lblItem);
		
	}
	
}
