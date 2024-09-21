package interfaz;

import Negocio.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import javax.swing.JList;

public class Interfaz {

	private JFrame frame;
	private JPanel CatalogoVistaAdministrador;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockmin;
	private JTable tableCatAdmin;
	private JPanel Carrito;
	private JScrollPane ScrollPaneCarrito;
	private JButton btnEliminarACarrito;
	private JTable tableCarrito;
	private JButton btnInicio;
	private JPanel Principal;
	private JTable tableCatUsu;
	private JPanel Venta;
	private JScrollPane ScrollPaneVenta;
	private JTable tableVenta;

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


	//Tema de las cuotas y metodo de pagoo
	int cuota;
	Metodo_pago metodo_pago;
	boolean carroconfirmado; 
	Carrito carrito;
	Catalogo catalogo;
	Venta venta;
	List <Integer> listaReponerStock = new ArrayList <Integer>();
	
	
	private JButton btnRealizarVenta;
	private Panel Ranking;
	private JButton btnIrARanking;
	private JButton btnInicioUsuCarrito;
	private JButton btnInicioUsuRan;
	private JButton btnRegresarCarrito;
	private JButton btnCancelarVenta;
	private JButton btnRegresarCarritoVenta;
	private JTextPane textPaneRanking_1;
	private JTextPane textPaneRanking_2;
	private JTextPane textPaneRanking_3;
	private JTextPane textPaneRanking_4;
	private JTextPane textPaneRanking_5;
	private JTextPane textPaneRanking_6;
	private JTextPane textPaneRanking_7;
	private JTextPane textPaneRanking_8;
	private JTextPane textPaneRanking_9;
	
	public void setCuotas(int c) {
		this.cuota = c;
	}
	
	public int getCuotas() {
		return this.cuota;
	}
	
	public void setMetodoPago(Metodo_pago metp) {
		this.metodo_pago = metp;
	}
	
	public Metodo_pago getMetodoPago() {
		return this.metodo_pago;
	}
	
	public void setCarroConfirmado(boolean cc) {
		this.carroconfirmado = cc;
	}
	
	public boolean getCarroConfirmado() {
		return this.carroconfirmado;
	}
	
	public void setCarrito(Carrito c) {
		this.carrito = c;
	}
	
	public Carrito getCarrito() {
		return this.carrito;
	}
	
	public void setCatalogo(Catalogo cat) {
		this.catalogo = cat;
	}
	
	public Catalogo getCatalogo() {
		return this.catalogo;
	}
	
	public void setListaReponerStock(List <Integer> lrp) {
		this.listaReponerStock = lrp;
	}
	
	public List <Integer> getListaReponerStock() {
		return this.listaReponerStock;
	}
	
	//public Venta InicializarVenta() {
	//	Venta v = new Venta(this.metodo_pago, this.carrito, this.catalogo);
	//	return v;
		
	//}
	
	public void setVenta(Venta v) {
		this.venta = v;
	}
	
	public Venta getVenta() {
		return this.venta;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		//PANTALLA INICIO
		Principal = new JPanel();
		Principal.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(Principal, "name_273570051046299");
		Principal.setLayout(null);
		
		
		//Botón que redirige a la pantalla del carrito
		JButton btnUsuario = new JButton("USUARIO");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				
				Object evt = e.getSource();
				if (evt.equals(btnUsuario)) {
					
					Carrito.setVisible(true);
					Principal.setVisible(false);
					
					
					//frame.getContentPane().add(Carrito);
					
					//frame.validate();
					
				}
			}
		});
		btnUsuario.setBounds(205, 141, 89, 23);
		Principal.add(btnUsuario);
		
		
		//Boton que redirige a la pantalla del administrador
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnAdmin)) {
					
					CatalogoVistaAdministrador.setVisible(true);
					Principal.setVisible(false);
					
					
					//Al entrar en la Vista del administrador se va a hacer la verificacion del stock de todos los productos
					if (getListaReponerStock().size() != 0) {
						for (Integer k : getListaReponerStock()) {
							JOptionPane.showMessageDialog(null, "El producto nro " + k + " requiere reponer stock");
							
							Producto prod = catalogo.BuscarProductoxCodigo(k);
							
							DefaultTableModel modelo = (DefaultTableModel) tableCatAdmin.getModel();
							//El indice en donde está mi producto en la lista de productos cincidiria con el de la fila enla tabla
							int StockActual = (int)modelo.getValueAt(catalogo.buscarProducto(prod), 3);
							//System.out.println(valor);
							int cantidadVendida = prod.getCant_vendidas();
							//cambio el valor de la celda del stock en el modelo de la tabla del Catalogo vista administrador
							modelo.setValueAt(StockActual-cantidadVendida, catalogo.buscarProducto(prod), 3);
							
						}
					}
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
			}
		});
		btnAdmin.setBounds(332, 141, 89, 23);
		Principal.add(btnAdmin);
		
	
		
		
		//CATALOGO
		CatalogoVistaAdministrador = new JPanel();
		frame.getContentPane().add(CatalogoVistaAdministrador, "name_246207476657600");
		
		Catalogo catalogo = new Catalogo();
		
		codigo = new JTextField();
		codigo.setBounds(29, 70, 86, 20);
		codigo.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(125, 70, 86, 20);
		descripcion.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(219, 70, 86, 20);
		precio.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(311, 70, 86, 20);
		stock.setColumns(10);
		
		stockmin = new JTextField();
		stockmin.setBounds(406, 70, 86, 20);
		stockmin.setColumns(10);
		
		//Scroll para la tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 114, 407, 177);
		
		//Tabla donde se contendran los productos
		tableCatAdmin = new JTable();
		tableCatAdmin.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion", "Precio", "Stock", "Stock Minimo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableCatAdmin);
		
		DefaultTableModel modelo = (DefaultTableModel) tableCatAdmin.getModel();
		
		//Boton para agregar lo puesto en las casillas, en una fila de la tabla, es decir un producto. 
		//Se contempla que el producto no vuelva a existir ya en el sistema.
		JButton btnAgregarPaC = new JButton("Agregar");
		btnAgregarPaC.setBounds(510, 104, 89, 23);
		btnAgregarPaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//si el producto por su codigo ya está sale una ventana emergente avisando que ya está, sino se agrega
				if (catalogo.getListaProductos().isEmpty() != true && catalogo.BuscarProductoxCodigo(Integer.parseInt(codigo.getText())).getCodigo() == Integer.parseInt(codigo.getText())) {
					JOptionPane.showMessageDialog(null, "El producto ya existe en el sistema");
				}
				else {
				
					catalogo.cargar(new Producto(Integer.parseInt(codigo.getText()), Double.parseDouble(precio.getText()), descripcion.getText(), Integer.parseInt(stock.getText()), Integer.parseInt(stockmin.getText())));
					
					setCatalogo(catalogo);
					
					DefaultTableModel modelo = (DefaultTableModel) tableCatAdmin.getModel();
					modelo.addRow(new Object [] {Integer.parseInt(codigo.getText()), descripcion.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText()), Integer.parseInt(stockmin.getText())});
				
				}
			}		
		});
		
		
		//Para eliminar un producto de la tabla, se selecciona y luego se presiona el boton de eliminar, tambien se eliminario del catalogo en vista del usuario
		JButton btnEliminarPaC = new JButton("Eliminar");
		btnEliminarPaC.setBounds(510, 166, 89, 23);
		btnEliminarPaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Al hacer click en el boton Eliminar con este listenerMouse se a eliminar el Producto del catalogo y de la tabla
				btnEliminarPaC.addMouseListener(new MouseAdapter() {
				      public void mouseClicked(MouseEvent e) 
				      {
				         int fila = tableCatAdmin.rowAtPoint(e.getPoint());
				         int columna = tableCatAdmin.columnAtPoint(e.getPoint());
				         if ((fila > -1) && (columna == 0)) {
				            System.out.println((tableCatAdmin.getValueAt(fila,columna).getClass().getSimpleName()));
				            
				            Producto p = catalogo.BuscarProductoxCodigo((int)tableCatAdmin.getValueAt(fila,columna));
				            catalogo.eliminarProducto(p);
				          }
				      }
				      
				 });
				
				DefaultTableModel modelo2 = (DefaultTableModel) tableCatUsu.getModel();
				modelo2.removeRow(tableCatAdmin.getSelectedRow());
				
				DefaultTableModel modelo = (DefaultTableModel) tableCatAdmin.getModel();
				modelo.removeRow(tableCatAdmin.getSelectedRow());

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
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(50, 45, 46, 14);
		CatalogoVistaAdministrador.add(lblNewLabel);
		
		//Boton guardar, al hacer click en él, los productos en la lista de productos van a pasarse a la tabla del catalogo en vista del usuario
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tablamodelo = (DefaultTableModel) tableCatUsu.getModel();
		        tablamodelo.setRowCount(0);
		        
				//El indice en donde está mi producto en la lista de productos cincidiria con el de la fila enla tabla
				//int StockActual = (int)modelo.getValueAt(catalogo.buscarProducto(prod), 3);
				//System.out.println(valor);
				//int cantidadVendida = prod.getCant_vendidas();
				//cambio el valor de la celda del stock en el modelo de la tabla del Catalogo vista administrador
				
				
				DefaultTableModel modelo2 = (DefaultTableModel) tableCatUsu.getModel();
				
				for (Producto p : catalogo.getListaProductos()) {
					modelo2.addRow(new Object [] {"-", p.getCodigo(), p.getDescripcion(), p.getPrecio()});
				}
			}
		});
		btnGuardar.setBounds(510, 233, 89, 23);
		CatalogoVistaAdministrador.add(btnGuardar);
		
		
		//Boton que redirige al carrito (a eliminar, poner algo como "salir" e ir a la principal")
		btnInicio = new JButton("Inicio");	
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnInicio)) {
					
					Principal.setVisible(true);
					CatalogoVistaAdministrador.setVisible(false);
				}
			}
		});
		btnInicio.setBounds(539, 24, 89, 23);
		CatalogoVistaAdministrador.add(btnInicio);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(138, 45, 73, 14);
		CatalogoVistaAdministrador.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(244, 45, 46, 14);
		CatalogoVistaAdministrador.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stock");
		lblNewLabel_3.setBounds(340, 45, 46, 14);
		CatalogoVistaAdministrador.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock Minimo");
		lblNewLabel_4.setBounds(417, 45, 86, 14);
		CatalogoVistaAdministrador.add(lblNewLabel_4);
		
		
		
		
		//CARRITO
		Carrito = new JPanel();
		Carrito.setLayout(null);
		frame.getContentPane().add(Carrito, "name_267051686817499");
		
		Carrito carrito = new Carrito();
		setCarrito(carrito);
		
		ScrollPaneCarrito = new JScrollPane();
		ScrollPaneCarrito.setBounds(291, 42, 337, 235);
		Carrito.add(ScrollPaneCarrito);
		
		//TABLA DEL CARRITO
		tableCarrito = new JTable();
		tableCarrito.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cantidad", "Codigo", "Descripcion", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ScrollPaneCarrito.setViewportView(tableCarrito);
		
		setCarroConfirmado(false);
		
		JButton btnAgregarACarrito = new JButton("Agregar");
		btnAgregarACarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelo = (DefaultTableModel) tableCatUsu.getModel();

				DefaultTableModel modelo2 = (DefaultTableModel) tableCarrito.getModel();
				
				//System.out.println((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1));
				boolean pce = getCarrito().EncontrarProductoxCodigo((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1));
	        	//si el producto por su codigo ya está sale una ventana emergente avisando que ya está, sino se agrega
					if (pce) {
						JOptionPane.showMessageDialog(null, "El producto ya ha sido agregado al carrito");
						//if ((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1) == ){
						modelo2.addRow(new Object [] {((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 0)), ((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1)), ((String) modelo.getValueAt(tableCatUsu.getSelectedRow(), 2)), ((double) modelo.getValueAt(tableCatUsu.getSelectedRow(), 3))});

						//}						
					}
					//si el carrito ya se confirmó
					else if (getCarroConfirmado() == true ){
						JOptionPane.showMessageDialog(null, "Ya ha confirmado el carrito");
					}
					else {
						
						Producto p = catalogo.BuscarProductoxCodigo((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1));
						System.out.println((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 0));
						getCarrito().cargarProducto(p, ((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 0)));
						
						modelo2.addRow(new Object [] {((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 0)), ((int) modelo.getValueAt(tableCatUsu.getSelectedRow(), 1)), ((String) modelo.getValueAt(tableCatUsu.getSelectedRow(), 2)), ((double) modelo.getValueAt(tableCatUsu.getSelectedRow(), 3))});
					}
				
			}
		});
		btnAgregarACarrito.setBounds(10, 288, 89, 23);
		Carrito.add(btnAgregarACarrito);
		
		
		btnEliminarACarrito = new JButton("Eliminar");
		btnEliminarACarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//catalogo.buscarProducto(null)
				//Al hacer click en el boton Eliminar con este listenerMouse se a eliminar el Producto del carrito y de la tabla
				btnEliminarACarrito.addMouseListener(new MouseAdapter() {
				      public void mouseClicked(MouseEvent e) 
				      {//tabeCatAdmin
				         int fila = tableCarrito.rowAtPoint(e.getPoint());
				         int columna = tableCarrito.columnAtPoint(e.getPoint());
				         if ((fila > -1) && (columna == 1)) {
				            //System.out.println((tableCatAdmin.getValueAt(fila,columna).getClass().getSimpleName()));
				            
				            //Producto p = catalogo.BuscarProductoxCodigo((int)tableCatAdmin.getValueAt(fila,columna));
				            //System.out.print(p.getDescripcion());
				        	System.out.print(getCarrito().BuscarProductoxCodigoCarr((int)tableCarrito.getValueAt(fila,columna)).getDescripcion());
				            getCarrito().EliminarProducto(getCarrito().BuscarProductoxCodigoCarr((int)tableCarrito.getValueAt(fila,columna)));
				            
				          }
				      }
				      
				 });
				
				for (Producto i : getCarrito().getListaCompra()) {
					System.out.println(i.getCodigo());
				}
				
				DefaultTableModel modelo = (DefaultTableModel) tableCarrito.getModel();
				modelo.removeRow(tableCarrito.getSelectedRow());
			}
		});
		btnEliminarACarrito.setBounds(301, 288, 89, 23);
		Carrito.add(btnEliminarACarrito);
		
		JButton btnConfirmarCarrito = new JButton("Confirmar Carrito");
		btnConfirmarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setCarroConfirmado(true);
				
				DefaultTableModel modelo = (DefaultTableModel) tableVenta.getModel();
				
				for (Producto p : getCarrito().getListaCompra()) {
					modelo.addRow(new Object [] {p.getCantidadAComprar(), p.getCodigo(), p.getDescripcion(), p.getPrecio()});
				}
				
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnConfirmarCarrito)) {
					
					Carrito.setVisible(false);
					Venta.setVisible(true);
				}
			}
		});
		btnConfirmarCarrito.setBounds(496, 288, 132, 23);
		Carrito.add(btnConfirmarCarrito);
		
		JScrollPane ScrollPaneCatalogoUsu = new JScrollPane();
		ScrollPaneCatalogoUsu.setBounds(10, 41, 271, 236);
		Carrito.add(ScrollPaneCatalogoUsu);
		
		//TABLA DEL CATALOGO PARA VISTA USUARIO
		tableCatUsu = new JTable();
		tableCatUsu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cantidad", "Codigo", "Descripcion", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ScrollPaneCatalogoUsu.setViewportView(tableCatUsu);
		
		
		
		btnIrARanking = new JButton("Ver TOP 10 productos mas vendidos");
		btnIrARanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnIrARanking)) {
					
					Carrito.setVisible(false);
					Ranking.setVisible(true);
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
				
			}
		});
		btnIrARanking.setBounds(10, 11, 271, 23);
		Carrito.add(btnIrARanking);
		
		btnInicioUsuCarrito = new JButton("Inicio");
		btnInicioUsuCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnInicioUsuCarrito)) {
					
					Carrito.setVisible(false);
					Principal.setVisible(true);
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
			}
		});
		btnInicioUsuCarrito.setBounds(554, 8, 89, 23);
		Carrito.add(btnInicioUsuCarrito);
		
		
		
		//VENTA VISTA DEL USUARIO
		Venta = new JPanel();
		frame.getContentPane().add(Venta, "name_289155427829300");
		Venta.setLayout(null);
		
		
		
		
		JComboBox ComboBoxCuotas = new JComboBox();
		ComboBoxCuotas.setModel(new DefaultComboBoxModel(new String[] {"-", "2", "3", "6"}));
		ComboBoxCuotas.setToolTipText("");
		ComboBoxCuotas.setBounds(419, 147, 105, 22);
		Venta.add(ComboBoxCuotas);
		
		ComboBoxCuotas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String opc = (String) ComboBoxCuotas.getSelectedItem();
				switch(opc) {
				case "2":
					setCuotas(2);
					break;
				case "3":
					setCuotas(3);
					break;
				case "6":
					setCuotas(6);
					break;
				}
				
			}
			
		});
		
		
		//Para selecconar el metodo de pago
		JComboBox ComboBoxMetodoPago = new JComboBox();
		ComboBoxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"-", "Efectivo", "Credito", "Debito"}));
		ComboBoxMetodoPago.setBounds(419, 89, 105, 22);
		Venta.add(ComboBoxMetodoPago);
		
		ComboBoxMetodoPago.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String opmp = (String) ComboBoxMetodoPago.getSelectedItem();
				
				switch(opmp) {
				case "Efectivo":
					ComboBoxCuotas.setEnabled(false);
					Metodo_pago mpe = new Efectivo(0, carrito.precioTotal(carrito.getListaCompra()));
					setMetodoPago(mpe);
					break;
				case "Credito":
					ComboBoxCuotas.setEnabled(true);
					Metodo_pago mpc = new Credito(getCuotas(), carrito.precioTotal(carrito.getListaCompra()));
					setMetodoPago(mpc);
					break;
				case "Debito":
					ComboBoxCuotas.setEnabled(false);
					Metodo_pago mpd = new Debito(0, carrito.precioTotal(carrito.getListaCompra()));
					setMetodoPago(mpd);
					break;
				}
			}
			
		});
		
		
		
		JTextPane textPanePrecioTotal = new JTextPane();
		textPanePrecioTotal.setEditable(false);
		textPanePrecioTotal.setBounds(82, 252, 130, 45);
		Venta.add(textPanePrecioTotal);
		
		//System.out.println(metodo_pago);
		
		
		//Venta venta = new Venta(getMetodoPago(), carrito, catalogo);
		
		JButton btnPrecioTotal = new JButton("Calcular precio total");
		btnPrecioTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.print(String.valueOf(getMetodoPago().getValorMpa()));
				//textPanePrecioTotal.setText("");
				textPanePrecioTotal.setText(String.valueOf(getMetodoPago().getValorMpa()));
			}
		});
		btnPrecioTotal.setBounds(67, 218, 154, 23);
		Venta.add(btnPrecioTotal);
		
		//Al confirmar la venta sale una ventana emergente y luego nos dirige al inicio, el carrito se vacia ya sea en ventana carro y vente y se controla el stock
		btnRealizarVenta = new JButton("Confirmar Venta");
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Venta venta = new Venta(metodo_pago, carrito, catalogo);
				setVenta(venta);
				
				Carrito carritoNuevo = new Carrito();
				setCarrito(carritoNuevo);
				
				setCarroConfirmado(false);
				
				textPanePrecioTotal.setText("");
				
				DefaultTableModel tablamodelo = (DefaultTableModel) tableCarrito.getModel();
		        tablamodelo.setRowCount(0);
		        
		        DefaultTableModel tablamodelo2 = (DefaultTableModel) tableVenta.getModel();
		        tablamodelo2.setRowCount(0);
		        
		        //me fijo si hay productos que necesitan reponer
		        setListaReponerStock(venta.cambiarStock(catalogo));
		    
				
				JOptionPane.showMessageDialog(null, "Venta realizada con éxito");
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnRealizarVenta)) {
					
					Venta.setVisible(false);
					Principal.setVisible(true);
				}
				
			}

			private int JtablegetRowCount() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnRealizarVenta.setBounds(387, 218, 169, 63);
		Venta.add(btnRealizarVenta);
		
		ScrollPaneVenta = new JScrollPane();
		ScrollPaneVenta.setBounds(28, 29, 282, 167);
		Venta.add(ScrollPaneVenta);
		
		tableVenta = new JTable();
		tableVenta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cantidad", "Codigo", "Descripcion", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ScrollPaneVenta.setViewportView(tableVenta);
		
		btnCancelarVenta = new JButton("Cancelar venta");
		btnCancelarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				
				setCarroConfirmado(false);
				
				Object evt = e.getSource();
				if (evt.equals(btnCancelarVenta)) {
					
					Venta.setVisible(false);
					Principal.setVisible(true);
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
			}
		});
		btnCancelarVenta.setBounds(489, 11, 154, 23);
		Venta.add(btnCancelarVenta);
		
		JLabel lblNewLabel_5 = new JLabel("Seleccionar Metodo de Pago");
		lblNewLabel_5.setBounds(403, 67, 169, 14);
		Venta.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Seleccionar cuotas");
		lblNewLabel_6.setBounds(403, 122, 121, 14);
		Venta.add(lblNewLabel_6);
		
		
		
		
		
		//RANKING VISTA USUARIO
		Ranking = new Panel();
		frame.getContentPane().add(Ranking, "name_296942445139900");
		Ranking.setLayout(null);
		
		JTextPane textPaneRanking = new JTextPane();
		textPaneRanking.setEditable(false);
		textPaneRanking.setBounds(25, 66, 315, 23);
		Ranking.add(textPaneRanking);
		
		JButton btnRanking = new JButton("Generar Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				catalogo.mostrarRanking();
				
				String [] Ranking = catalogo.ListaRanking();
				
				System.out.print(Ranking[0] + " " + Ranking[1]);
				
				textPaneRanking.setText("1.     " + Ranking[0]);
				textPaneRanking_1.setText("2.     " + Ranking[1]);
				textPaneRanking_2.setText("3.     " + Ranking[2]);
				textPaneRanking_3.setText("4.     " + Ranking[3]);
				textPaneRanking_4.setText("5.     " + Ranking[4]);
				textPaneRanking_5.setText("6.     " + Ranking[5]);
				textPaneRanking_6.setText("7.     " + Ranking[6]);
				textPaneRanking_7.setText("8.     " + Ranking[7]);
				textPaneRanking_8.setText("9.     " + Ranking[8]);
				textPaneRanking_9.setText("10.     " + Ranking[9]);
				
				
				
			}
		});
		btnRanking.setBounds(414, 227, 168, 38);
		Ranking.add(btnRanking);
		
		btnInicioUsuRan = new JButton("Inicio");
		btnInicioUsuRan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnInicioUsuRan)) {
					
					Ranking.setVisible(false);
					Principal.setVisible(true);
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
			}
		});
		btnInicioUsuRan.setBounds(554, 11, 89, 23);
		Ranking.add(btnInicioUsuRan);
		
		btnRegresarCarrito = new JButton("Volver a Carrito");
		btnRegresarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hago un evento, en el que se mostrará visible o no cierto panel dependiendo que boton se presinó
				Object evt = e.getSource();
				if (evt.equals(btnRegresarCarrito)) {
					
					Carrito.setVisible(true);
					Ranking.setVisible(false);
					
					//frame.getContentPane().add(CatalogoVistaAdministrador);
					
				}
			}
		});
		btnRegresarCarrito.setBounds(414, 11, 138, 23);
		Ranking.add(btnRegresarCarrito);
		
		textPaneRanking_1 = new JTextPane();
		textPaneRanking_1.setEditable(false);
		textPaneRanking_1.setBounds(25, 100, 315, 23);
		Ranking.add(textPaneRanking_1);
		
		textPaneRanking_2 = new JTextPane();
		textPaneRanking_2.setEditable(false);
		textPaneRanking_2.setBounds(25, 134, 315, 23);
		Ranking.add(textPaneRanking_2);
		
		textPaneRanking_3 = new JTextPane();
		textPaneRanking_3.setEditable(false);
		textPaneRanking_3.setBounds(25, 168, 315, 23);
		Ranking.add(textPaneRanking_3);
		
		textPaneRanking_4 = new JTextPane();
		textPaneRanking_4.setEditable(false);
		textPaneRanking_4.setBounds(25, 202, 315, 23);
		Ranking.add(textPaneRanking_4);
		
		textPaneRanking_5 = new JTextPane();
		textPaneRanking_5.setEditable(false);
		textPaneRanking_5.setBounds(25, 242, 315, 23);
		Ranking.add(textPaneRanking_5);
		
		textPaneRanking_6 = new JTextPane();
		textPaneRanking_6.setEditable(false);
		textPaneRanking_6.setBounds(350, 168, 293, 23);
		Ranking.add(textPaneRanking_6);
		
		textPaneRanking_7 = new JTextPane();
		textPaneRanking_7.setEditable(false);
		textPaneRanking_7.setBounds(350, 134, 293, 23);
		Ranking.add(textPaneRanking_7);
		
		textPaneRanking_8 = new JTextPane();
		textPaneRanking_8.setEditable(false);
		textPaneRanking_8.setBounds(350, 66, 293, 23);
		Ranking.add(textPaneRanking_8);
		
		textPaneRanking_9 = new JTextPane();
		textPaneRanking_9.setEditable(false);
		textPaneRanking_9.setBounds(350, 100, 293, 23);
		Ranking.add(textPaneRanking_9);
		
		JLabel lblNewLabel_7 = new JLabel("Ranking de los 10 Productos mas vendidos");
		lblNewLabel_7.setBounds(73, 28, 215, 14);
		Ranking.add(lblNewLabel_7);
		
		
	}
}
