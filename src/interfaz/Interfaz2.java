package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mySQL.SQLMetodos;
import tablas.producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Interfaz2 extends JFrame implements ActionListener {

	private JPanel contentPane, pCategorias, pProductos;
	private JButton bRegresar, bMinimizar, bCerrar, bRegistrar, bBorrar, bModificar, bCategorias, bProductos, bRegistrarC;
	private JComboBox cClasificacion, cProveedor;
	private JTextField fNomPro, fCantidadPro, fIdPro;
	private JTextArea textArea;
	private JTextArea aDesPro;
	private SQLMetodos sql = new SQLMetodos();
	private TextPrompt tp;
	private JTable tProductos, tProveedores, tCategorias;
	private JTextField fIdCategoria;
	private JTextField fDesCategoria;
	private JTable tCategoriasP;
	private JTextField fPrecioPro;
	private JLabel eTitulo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz2 frame = new Interfaz2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz2() {
		setBackground(Color.GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 765);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 170, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 0, 27));
		panel.setBounds(0, 0, 902, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Icono del negocio");
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1.setForeground(new Color(195,195,195));
		lblNewLabel_1.setBounds(10, 11, 183, 113);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 122, 880, 2);
		panel.add(separator);
		
		bRegresar = new JButton("\u2190");
		bRegresar.setForeground(Color.BLACK);
		bRegresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		bRegresar.setFocusPainted(false);
		bRegresar.setBorder(null);
		bRegresar.setBackground(Color.WHITE);
		bRegresar.setBounds(759, 11, 41, 25);
		bRegresar.addActionListener(this);
		panel.add(bRegresar);
		
		bMinimizar = new JButton("-");
		bMinimizar.setForeground(Color.BLACK);
		bMinimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		bMinimizar.setFocusPainted(false);
		bMinimizar.setBorderPainted(false);
		bMinimizar.setBackground(Color.WHITE);
		bMinimizar.setBounds(801, 11, 43, 25);
		bMinimizar.addActionListener(this);
		panel.add(bMinimizar);
		
		bCerrar = new JButton("X");
		bCerrar.setForeground(Color.BLACK);
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBackground(Color.WHITE);
		bCerrar.setBounds(845, 11, 45, 25);
		bCerrar.addActionListener(this);
		panel.add(bCerrar);
		
		JLabel lblNewLabel = new JLabel("Nombre del local");
		lblNewLabel.setForeground(new Color(195,195,195));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 46));
		lblNewLabel.setBounds(200, 11, 690, 113);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 146, 283, 608);
		panel_1.setBackground(new Color(210,210,210));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 263, 70);
		panel_3.setBackground(new Color(100,0,27));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Menu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(195, 195, 195));
		lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1_1.setBounds(10, 11, 243, 48);
		panel_3.add(lblNewLabel_1_1);
		
		bCategorias = new JButton("Categorias");
		bCategorias.setFocusPainted(false);
		bCategorias.setBackground(Color.WHITE);
		bCategorias.setForeground(Color.BLACK);
		bCategorias.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bCategorias.setBounds(10, 92, 263, 30);
		bCategorias.addActionListener(this);
		panel_1.add(bCategorias);
		
		bProductos = new JButton("Productos");
		bProductos.setFocusPainted(false);
		bProductos.setForeground(Color.BLACK);
		bProductos.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bProductos.setBackground(Color.WHITE);
		bProductos.setBounds(10, 133, 263, 30);
		bProductos.addActionListener(this);
		panel_1.add(bProductos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(303, 146, 10, 608);
		contentPane.add(panel_2);
		
		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(new Color(210, 210, 210));
		pPrincipal.setBounds(323, 146, 567, 608);
		contentPane.add(pPrincipal);
		pPrincipal.setLayout(null);
		
		pProductos = new JPanel();
		pProductos.setBounds(0, 81, 567, 527);
		pProductos.setBackground(new Color(210,210,210));
		pPrincipal.add(pProductos);
		pProductos.setVisible(false);
		pProductos.setLayout(null);
		
		fIdPro = new JTextField();
		fIdPro.setForeground(Color.BLACK);
		fIdPro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fIdPro.setColumns(10);
		fIdPro.setBorder(null);
		fIdPro.setBackground(new Color(210, 210, 210));
		fIdPro.setBounds(10, 11, 190, 30);
		tp = new TextPrompt("ID del Producto", fIdPro);
		pProductos.add(fIdPro);
		
		fNomPro = new JTextField();
		fNomPro.setForeground(Color.BLACK);
		fNomPro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fNomPro.setColumns(10);
		fNomPro.setBorder(null);
		fNomPro.setBackground(new Color(210, 210, 210));
		fNomPro.setBounds(10, 52, 190, 30);
		tp = new TextPrompt("Nombre del producto", fNomPro);
		pProductos.add(fNomPro);
		
		fCantidadPro = new JTextField();
		fCantidadPro.setForeground(Color.BLACK);
		fCantidadPro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fCantidadPro.setColumns(10);
		fCantidadPro.setBorder(null);
		fCantidadPro.setBackground(new Color(210, 210, 210));
		fCantidadPro.setBounds(10, 195, 190, 30);
		tp = new TextPrompt("Unidades disponibles", fCantidadPro);
		pProductos.add(fCantidadPro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 93, 240, 89);
		pProductos.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(new Color(210,210,210));
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		tp = new TextPrompt("Descripcion del producto", textArea);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 41, 240, 2);
		pProductos.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(10, 225, 240, 2);
		pProductos.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(10, 82, 240, 2);
		pProductos.add(separator_1_1_1);
		
		cProveedor = new JComboBox();
		cProveedor.setForeground(Color.BLACK);
		cProveedor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cProveedor.setBounds(10, 321, 240, 30);
		cProveedor.addItem("Proveedor...");
		pProductos.add(cProveedor);
		
		cClasificacion = new JComboBox();
		cClasificacion.setForeground(Color.BLACK);
		cClasificacion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cClasificacion.setBounds(10, 279, 240, 30);
		cClasificacion.addItem("Clasificacion...");
		pProductos.add(cClasificacion);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 362, 547, 154);
		pProductos.add(panel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
		);
		
		tProductos = new JTable();
		scrollPane_1.setViewportView(tProductos);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(270, 41, 287, 114);
		pProductos.add(panel_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
		);
		
		tCategorias = new JTable();
		scrollPane_2.setViewportView(tCategorias);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(270, 196, 287, 114);
		pProductos.add(panel_5_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_5_1 = new GroupLayout(panel_5_1);
		gl_panel_5_1.setHorizontalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		gl_panel_5_1.setVerticalGroup(
			gl_panel_5_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
		);
		
		tProveedores = new JTable();
		scrollPane_3.setViewportView(tProveedores);
		panel_5_1.setLayout(gl_panel_5_1);
		
		bRegistrar = new JButton("Registrar");
		bRegistrar.setForeground(Color.BLACK);
		bRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		bRegistrar.setFocusPainted(false);
		bRegistrar.setBackground(Color.WHITE);
		bRegistrar.setBounds(270, 321, 93, 30);
		bRegistrar.addActionListener(this);
		pProductos.add(bRegistrar);
		
		bModificar = new JButton("Modificar\r\n");
		bModificar.setForeground(Color.BLACK);
		bModificar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		bModificar.setFocusPainted(false);
		bModificar.setBackground(Color.WHITE);
		bModificar.setBounds(370, 320, 93, 30);
		pProductos.add(bModificar);
		
		bBorrar = new JButton("Borrar");
		bBorrar.setForeground(Color.BLACK);
		bBorrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		bBorrar.setFocusPainted(false);
		bBorrar.setBackground(Color.WHITE);
		bBorrar.setBounds(470, 321, 93, 30);
		pProductos.add(bBorrar);
		
		JLabel lblNewLabel_2 = new JLabel("Categorias");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(270, 11, 93, 30);
		pProductos.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Proveedores");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(270, 166, 93, 30);
		pProductos.add(lblNewLabel_2_1);
		tp.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.getHeight();
		
		diseñoTabla(tCategorias);
		diseñoTabla(tProductos);
		diseñoTabla(tProveedores);
		
		sql.mostrarProducto(tProductos);
		sql.mostrarCategoria(tCategorias);
		sql.mostrarProveedor2(tProveedores, cProveedor);
		
		pCategorias = new JPanel();
		pCategorias.setBounds(0, 81, 567, 527);
		pCategorias.setBackground(new Color(210,210,210));
		pPrincipal.add(pCategorias);
		pCategorias.setVisible(false);
		pCategorias.setLayout(null);
		
		fIdCategoria = new JTextField();
		fIdCategoria.setForeground(Color.BLACK);
		fIdCategoria.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fIdCategoria.setColumns(10);
		fIdCategoria.setBorder(null);
		fIdCategoria.setBackground(new Color(210, 210, 210));
		fIdCategoria.setBounds(10, 11, 190, 30);
		tp = new TextPrompt("ID de Categoria", fIdCategoria);
		pCategorias.add(fIdCategoria);
		
		fDesCategoria = new JTextField();
		fDesCategoria.setForeground(Color.BLACK);
		fDesCategoria.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fDesCategoria.setColumns(10);
		fDesCategoria.setBorder(null);
		fDesCategoria.setBackground(new Color(210, 210, 210));
		fDesCategoria.setBounds(10, 60, 190, 30);
		tp = new TextPrompt("Tipo de producto", fDesCategoria);
		pCategorias.add(fDesCategoria);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 41, 190, 2);
		pCategorias.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBackground(Color.BLACK);
		separator_2_1.setBounds(10, 90, 190, 2);
		pCategorias.add(separator_2_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(219, 11, 338, 299);
		pCategorias.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 338, 299);
		panel_6.add(scrollPane_4);
		
		tCategoriasP = new JTable();
		scrollPane_4.setViewportView(tCategoriasP);
		
		bRegistrarC = new JButton("Registrar");
		bRegistrarC.setForeground(Color.BLACK);
		bRegistrarC.setFont(new Font("Times New Roman", Font.BOLD, 12));
		bRegistrarC.setFocusPainted(false);
		bRegistrarC.setBackground(Color.WHITE);
		bRegistrarC.setBounds(10, 101, 190, 30);
		pCategorias.add(bRegistrarC);
		bRegistrarC.addActionListener(this);
		diseñoTabla(tCategoriasP);
		sql.mostrarCategoria(tCategoriasP);	
		
		fPrecioPro = new JTextField();
		fPrecioPro.setForeground(Color.BLACK);
		fPrecioPro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fPrecioPro.setColumns(10);
		fPrecioPro.setBorder(null);
		fPrecioPro.setBackground(new Color(210, 210, 210));
		fPrecioPro.setBounds(10, 236, 190, 30);
		tp = new TextPrompt("Precio del producto", fPrecioPro);
		pProductos.add(fPrecioPro);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setForeground(Color.BLACK);
		separator_1_1_2.setBackground(Color.BLACK);
		separator_1_1_2.setBounds(10, 266, 240, 2);
		pProductos.add(separator_1_1_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(100,0,27));
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 11, 547, 70);
		pPrincipal.add(panel_3_1);
		
		eTitulo = new JLabel("Titulo del formulario");
		eTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		eTitulo.setForeground(new Color(195, 195, 195));
		eTitulo.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		eTitulo.setBounds(10, 11, 527, 48);
		panel_3_1.add(eTitulo);
		
		//sql.mostrarCategorias(cClasificacion);
		setLocationRelativeTo(null);
	}

	public void diseñoTabla(JTable tabla) {
		tabla.setShowGrid(false);
		tabla.setDefaultEditor(Object.class, null);
		tabla.getTableHeader().setBackground(new Color(100,0,27));
		tabla.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		tabla.getTableHeader().setForeground(new Color(255,255,255));
		tabla.setBackground(Color.WHITE);
		tabla.setSelectionBackground(new Color(200,200,200));		
		tabla.setFont(new Font("Times New Roman", Font.BOLD, 14));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bCerrar)
			System.exit(0);
		if(arg0.getSource() == bMinimizar)
			setExtendedState(ICONIFIED);
		if(arg0.getSource() == bCategorias) {
			pProductos.setVisible(false);
			pCategorias.setVisible(true);
			
			eTitulo.setText("Categorias");
			
		}
		if(arg0.getSource() == bProductos) {
			pProductos.setVisible(true);
			pCategorias.setVisible(false);			
			cClasificacion.removeAllItems();
			cClasificacion.addItem("Clasificacion...");
			sql.mostrarCategorias(cClasificacion);
			
			eTitulo.setText("Productos");
			
		}
		if(arg0.getSource() == bRegistrarC) {
			sql.agregarCategoria(Integer.parseInt(fIdCategoria.getText()), fDesCategoria.getText());
			sql.mostrarCategoria(tCategoriasP);		
			sql.mostrarCategoria(tCategorias);
			fIdCategoria.setText(null);
			fDesCategoria.setText(null);
			
		}
		if(arg0.getSource() == bRegistrar) {
			sql.agregarProducto(new producto(Integer.parseInt(fIdPro.getText()), fNomPro.getText(), textArea.getText(), Integer.parseInt(fCantidadPro.getText()), Float.parseFloat(fPrecioPro.getText()), Integer.parseInt(cClasificacion.getSelectedItem().toString()), Integer.parseInt(cProveedor.getSelectedItem().toString())));
			sql.mostrarProducto(tProductos);
			fIdPro.setText(null);
			fNomPro.setText(null);
			textArea.setText(null);
			fCantidadPro.setText(null);
			fPrecioPro.setText(null);
			cClasificacion.setSelectedIndex(0);
			cProveedor.setSelectedIndex(0);
		
		}
		if(arg0.getSource() == bRegresar)
		{
			Interfaz4 in = new Interfaz4();
			in.setVisible(true);
			this.setVisible(false);
		}
	}
}
