package Negocio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.TextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class Interfaz {

	private JFrame frame;
	private JPanel CatalogoVistaAdministrador;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockmin;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		CatalogoVistaAdministrador = new JPanel();
		frame.getContentPane().add(CatalogoVistaAdministrador, "name_246207476657600");
		
		codigo = new JTextField();
		codigo.setBounds(31, 38, 86, 20);
		codigo.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(124, 38, 86, 20);
		descripcion.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(216, 36, 86, 20);
		precio.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(311, 36, 86, 20);
		stock.setColumns(10);
		
		stockmin = new JTextField();
		stockmin.setBounds(403, 35, 86, 20);
		stockmin.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 102, 411, 177);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Decripcion", "Precio", "Stock", "Stock Minimo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAgregarPaC = new JButton("Agregar");
		btnAgregarPaC.setBounds(524, 22, 89, 23);
		btnAgregarPaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.addRow(new Object [] {Integer.parseInt(codigo.getText()), descripcion.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText()), Integer.parseInt(stockmin.getText())});
				
			}
		});
		
		JButton btnEliminarPaC = new JButton("Eliminar");
		btnEliminarPaC.setBounds(527, 56, 89, 23);
		btnEliminarPaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.removeRow(table.getSelectedRow());
			}
		});
		
		
		
		CatalogoVistaAdministrador.setLayout(null);
		CatalogoVistaAdministrador.add(codigo);
		CatalogoVistaAdministrador.add(descripcion);
		CatalogoVistaAdministrador.add(precio);
		CatalogoVistaAdministrador.add(stock);
		CatalogoVistaAdministrador.add(stockmin);
		CatalogoVistaAdministrador.add(scrollPane);
		CatalogoVistaAdministrador.add(btnAgregarPaC);
		CatalogoVistaAdministrador.add(btnEliminarPaC);
	
		
		
	}
}
