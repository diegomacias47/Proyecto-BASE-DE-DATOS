package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import mySQL.SQLMetodos;
import tablas.empleado;
import tablas.proveedor;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class Interfaz extends JFrame implements ActionListener, MouseListener{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pEmpleado, pPrincipal, pClientes;
	private JButton bRegresar, bMinimizar, bCerrar, bEmpleado, bProveedor, bFactura, bRegistrarEmp, bClientes;
	private TextPrompt tp;
	private JTextField fId, fNombre, fDireccion, fEdad, fTelefono;
	private JComboBox cTrabajo;
	private JTable tEmpleado;
	private JTable tTrabajos;
	private SQLMetodos sql = new SQLMetodos();
	private JPanel pProveedor;
	private JTextField fIdProv;
	private JTextField fNomProv;
	private JTextField fDirProv;
	private JTextField fTelProv;
	private JTextField fCorreoProv;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JPanel panel_7;
	private JScrollPane scrollPane_3;
	private JButton bRegistrarProv;
	private JScrollPane scrollPane_2;
	private JTable tProveedor;
	private JPanel pFacturas;
	private JPanel panel_6;
	private JTable tFacturas;
	private JTable tDetalle;
	private JLabel eTitulo;
	private JTable tClientes;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Interfaz() {
		setBackground(Color.GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 170, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100,0,27));
		panel.setBounds(0, 0, 900, 135);
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
		panel_1.setBounds(10, 146, 283, 550);
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
		
		bEmpleado = new JButton("Empleados");
		bEmpleado.setFocusPainted(false);
		bEmpleado.setBackground(Color.WHITE);
		bEmpleado.setForeground(Color.BLACK);
		bEmpleado.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bEmpleado.setBounds(10, 92, 263, 30);
		bEmpleado.addActionListener(this);
		panel_1.add(bEmpleado);
		
		bProveedor = new JButton("Proveedores");
		bProveedor.setFocusPainted(false);
		bProveedor.setForeground(Color.BLACK);
		bProveedor.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bProveedor.setBackground(Color.WHITE);
		bProveedor.setBounds(10, 127, 263, 30);
		bProveedor.addActionListener(this);
		panel_1.add(bProveedor);
		
		bFactura = new JButton("Facturas");
		bFactura.setFocusPainted(false);
		bFactura.setForeground(Color.BLACK);
		bFactura.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bFactura.setBackground(Color.WHITE);
		bFactura.setBounds(10, 197, 263, 30);
		bFactura.addActionListener(this);
		panel_1.add(bFactura);
		
		bClientes = new JButton("Clientes");
		bClientes.setForeground(Color.BLACK);
		bClientes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bClientes.setFocusPainted(false);
		bClientes.setBackground(Color.WHITE);
		bClientes.setBounds(10, 162, 263, 30);
		bClientes.addActionListener(this);
		panel_1.add(bClientes);
		
		pPrincipal = new JPanel();
		pPrincipal.setBorder(null);
		pPrincipal.setBackground(new Color(210, 210, 210));
		pPrincipal.setBounds(323, 146, 567, 550);
		contentPane.add(pPrincipal);
		pPrincipal.setLayout(null);
		
		pClientes = new JPanel();
		pClientes.setBounds(0, 81, 567, 469);
		pPrincipal.add(pClientes);
		pClientes.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 40, 547, 171);
		pClientes.add(panel_9);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
		);
		
		tClientes = new JTable();
		scrollPane_6.setViewportView(tClientes);
		diseñoTabla(tClientes);
		panel_9.setLayout(gl_panel_9);
		
		pFacturas = new JPanel();
		pFacturas.setBounds(0, 81, 567, 469);
		pFacturas.setBackground(new Color(210,210,210));
		pPrincipal.add(pFacturas);
		pFacturas.setVisible(false);
		pFacturas.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBounds(10, 40, 547, 172);
		pFacturas.add(panel_6);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
		);
		
		tFacturas = new JTable();
		scrollPane_4.setViewportView(tFacturas);
		diseñoTabla(tFacturas);
		sql.mostrarFacturas(tFacturas);
		tFacturas.addMouseListener(this);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 286, 547, 172);
		pFacturas.add(panel_8);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
		);
		
		tDetalle = new JTable();
		scrollPane_5.setViewportView(tDetalle);
		diseñoTabla(tDetalle);
		//tDetalle.setVisible(false);
		panel_8.setLayout(gl_panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket de compra");
		lblNewLabel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 259, 547, 27);
		pFacturas.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Facturas");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_2_1.setBounds(10, 11, 547, 27);
		pFacturas.add(lblNewLabel_2_1);
		
		pProveedor = new JPanel();
		pProveedor.setBounds(0, 81, 567, 469);
		pProveedor.setBackground(new Color(210,210,210));
		pPrincipal.add(pProveedor);
		pProveedor.setVisible(false);
		pProveedor.setLayout(null);
		
		fIdProv = new JTextField();
		fIdProv.setForeground(Color.BLACK);
		fIdProv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fIdProv.setColumns(10);
		fIdProv.setBorder(null);
		fIdProv.setBackground(new Color(210, 210, 210));
		fIdProv.setBounds(10, 11, 190, 30);
		tp = new TextPrompt("ID del Proveedor:", fIdProv);
		pProveedor.add(fIdProv);
		
		fNomProv = new JTextField();
		fNomProv.setForeground(Color.BLACK);
		fNomProv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fNomProv.setColumns(10);
		fNomProv.setBorder(null);
		fNomProv.setBackground(new Color(210, 210, 210));
		fNomProv.setBounds(10, 52, 190, 30);
		tp = new TextPrompt("Nombre del Proveedor:", fNomProv);
		pProveedor.add(fNomProv);
		
		fDirProv = new JTextField();
		fDirProv.setForeground(Color.BLACK);
		fDirProv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fDirProv.setColumns(10);
		fDirProv.setBorder(null);
		fDirProv.setBackground(new Color(210, 210, 210));
		fDirProv.setBounds(10, 93, 190, 30);
		tp = new TextPrompt("Direccion del Proveedor:", fDirProv);
		pProveedor.add(fDirProv);
		
		fTelProv = new JTextField();
		fTelProv.setForeground(Color.BLACK);
		fTelProv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fTelProv.setColumns(10);
		fTelProv.setBorder(null);
		fTelProv.setBackground(new Color(210, 210, 210));
		fTelProv.setBounds(10, 134, 190, 30);
		tp = new TextPrompt("Telefono del Proveedor:",fTelProv);
		pProveedor.add(fTelProv);
		
		fCorreoProv = new JTextField();
		fCorreoProv.setForeground(Color.BLACK);
		fCorreoProv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fCorreoProv.setColumns(10);
		fCorreoProv.setBorder(null);
		fCorreoProv.setBackground(new Color(210, 210, 210));
		fCorreoProv.setBounds(10, 175, 190, 30);
		tp = new TextPrompt("Correo del Proveedor:",fCorreoProv);
		pProveedor.add(fCorreoProv);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(10, 205, 190, 2);
		pProveedor.add(separator_7);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(10, 164, 190, 2);
		pProveedor.add(separator_8);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(Color.BLACK);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(10, 123, 190, 2);
		pProveedor.add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.BLACK);
		separator_10.setBounds(10, 82, 190, 2);
		pProveedor.add(separator_10);
		
		separator_11 = new JSeparator();
		separator_11.setForeground(Color.BLACK);
		separator_11.setBackground(Color.BLACK);
		separator_11.setBounds(10, 41, 190, 2);
		pProveedor.add(separator_11);
		
		panel_7 = new JPanel();
		panel_7.setBounds(10, 258, 547, 200);
		pProveedor.add(panel_7);
		
		scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
		);
		
		tProveedor = new JTable();
		diseñoTabla(tProveedor);
		scrollPane_2.setViewportView(tProveedor);
		sql.mostrarProveedores(tProveedor);
		panel_7.setLayout(gl_panel_7);
		
		bRegistrarProv = new JButton("Registrar Proveedor");
		bRegistrarProv.setForeground(Color.BLACK);
		bRegistrarProv.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bRegistrarProv.setFocusPainted(false);
		bRegistrarProv.setBackground(Color.WHITE);
		bRegistrarProv.setBounds(10, 217, 190, 30);
		bRegistrarProv.addActionListener(this);
		pProveedor.add(bRegistrarProv);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 258, 547, 200);
		pProveedor.add(scrollPane_3);
		
		pEmpleado = new JPanel();
		pEmpleado.setBorder(null);
		pEmpleado.setBounds(0, 81, 567, 469);
		pEmpleado.setBackground(new Color(210,210,210));
		pPrincipal.add(pEmpleado);
		pEmpleado.setLayout(null);
		pEmpleado.setVisible(false);
		

		
		fId = new JTextField();
		fId.setBorder(null);
		fId.setBounds(10, 11, 190, 30);
		fId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tp = new TextPrompt("ID del empleado:", fId);
		fId.setBackground(new Color(210,210,210));
		fId.setForeground(Color.BLACK);
		pEmpleado.add(fId);
		fId.setColumns(10);
		
		fNombre = new JTextField();
		fNombre.setForeground(Color.BLACK);
		fNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fNombre.setColumns(10);
		fNombre.setBorder(null);
		tp = new TextPrompt("Nombre del empleado", fNombre);
		fNombre.setBackground(new Color(210, 210, 210));
		fNombre.setBounds(10, 52, 190, 30);
		pEmpleado.add(fNombre);
		
		fDireccion = new JTextField();
		fDireccion.setForeground(Color.BLACK);
		fDireccion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fDireccion.setColumns(10);
		fDireccion.setBorder(null);
		tp = new TextPrompt("Direccion del empleado: ", fDireccion);
		fDireccion.setBackground(new Color(210, 210, 210));
		fDireccion.setBounds(10, 93, 190, 30);
		pEmpleado.add(fDireccion);
		
		fEdad = new JTextField();
		fEdad.setForeground(Color.BLACK);
		fEdad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fEdad.setColumns(10);
		fEdad.setBorder(null);
		tp = new TextPrompt("Edad del empleado: ", fEdad);
		fEdad.setBackground(new Color(210, 210, 210));
		fEdad.setBounds(10, 134, 190, 30);
		pEmpleado.add(fEdad);
		
		fTelefono = new JTextField();
		fTelefono.setForeground(Color.BLACK);
		fTelefono.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fTelefono.setColumns(10);
		fTelefono.setBorder(null);
		tp = new TextPrompt("Telefono del empleado: ", fTelefono);
		fTelefono.setBackground(new Color(210, 210, 210));
		fTelefono.setBounds(10, 175, 190, 30);
		pEmpleado.add(fTelefono);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 41, 190, 2);
		pEmpleado.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(10, 82, 190, 2);
		pEmpleado.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(10, 123, 190, 2);
		pEmpleado.add(separator_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1_1.setBounds(10, 164, 190, 2);
		pEmpleado.add(separator_1_1_1_1);
		
		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1_1_1.setBounds(10, 205, 190, 2);
		pEmpleado.add(separator_1_1_1_1_1);
		
		cTrabajo = new JComboBox();
		cTrabajo.setForeground(Color.BLACK);
		cTrabajo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cTrabajo.setBounds(10, 216, 190, 30);
		cTrabajo.addItem("Seleccionar...");
		pEmpleado.add(cTrabajo);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(234, 11, 323, 153);
		pEmpleado.add(panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
		);
		
		tTrabajos = new JTable();
		tTrabajos.setBorder(null);
		scrollPane_1.setViewportView(tTrabajos);
		diseñoTabla(tTrabajos);
		sql.mostrarTrabajos(tTrabajos, cTrabajo);
		scrollPane_1.setViewportView(tTrabajos);
		
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBounds(10, 257, 547, 201);
		pEmpleado.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
		);
		
		tEmpleado = new JTable();
		diseñoTabla(tEmpleado);
		scrollPane.setViewportView(tEmpleado);
		sql.mostrarEmpleados(tEmpleado);
		panel_4.setLayout(gl_panel_4);
		
		bRegistrarEmp = new JButton("Dar de alta");
		bRegistrarEmp.setFocusPainted(false);
		bRegistrarEmp.setForeground(Color.BLACK);
		bRegistrarEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bRegistrarEmp.setBackground(Color.WHITE);
		bRegistrarEmp.setBounds(234, 175, 151, 30);
		bRegistrarEmp.addActionListener(this);
		pEmpleado.add(bRegistrarEmp);
		
		JPanel pTitulo = new JPanel();
		pTitulo.setBackground(new Color(100,0,27));
		pTitulo.setLayout(null);
		pTitulo.setBounds(10, 11, 547, 70);
		pPrincipal.add(pTitulo);
		
		eTitulo = new JLabel("Titulo del formulario");
		eTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		eTitulo.setForeground(new Color(195, 195, 195));
		eTitulo.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		eTitulo.setBounds(10, 11, 527, 48);
		pTitulo.add(eTitulo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(303, 146, 10, 550);
		contentPane.add(panel_2);
		
		
		pClientes.setVisible(false);
		sql.mostrarCliente(tClientes);
		
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
		if(arg0.getSource() == bEmpleado) {
			pEmpleado.setVisible(true);
			pProveedor.setVisible(false);
			pFacturas.setVisible(false);
			pClientes.setVisible(false);
			
			eTitulo.setText("Empleados");
		}
		
		if(arg0.getSource() == bRegistrarEmp) {
			
			sql.agregarEmpleado(new empleado(Integer.parseInt(fId.getText()), fNombre.getText(), fDireccion.getText(), fEdad.getText(), fTelefono.getText(), Integer.parseInt(cTrabajo.getSelectedItem().toString())));
			sql.mostrarEmpleados(tEmpleado);
			fId.setText(null);
			fNombre.setText(null);
			fDireccion.setText(null);
			fEdad.setText(null);
			fTelefono.setText(null);
			cTrabajo.setSelectedIndex(0);
			
		}
		if(arg0.getSource() == bProveedor) {
			pEmpleado.setVisible(false);
			pProveedor.setVisible(true);
			pFacturas.setVisible(false);
			pClientes.setVisible(false);
			
			eTitulo.setText("Proveedores");
			//pEmpleado.setVisible(false);
			
		}
		
		if(arg0.getSource() == bRegistrarProv) {
			
			sql.agregarProveedor(new proveedor(Integer.parseInt(fIdProv.getText()), fNomProv.getText(), fDirProv.getText(), fTelProv.getText(), fCorreoProv.getText()));
			fIdProv.setText(null);
			fNomProv.setText(null);
			fDirProv.setText(null);
			fTelProv.setText(null);
			fCorreoProv.setText(null);
			sql.mostrarProveedores(tProveedor);
			
		}
		
		if(arg0.getSource() == bFactura) {
			pEmpleado.setVisible(false);
			pProveedor.setVisible(false);
			pFacturas.setVisible(true);
			pClientes.setVisible(false);
			eTitulo.setText("Facturas");
			
		}
		if(arg0.getSource() == bClientes) {
			pEmpleado.setVisible(false);
			pProveedor.setVisible(false);
			pFacturas.setVisible(false);
			pClientes.setVisible(true);
			
			eTitulo.setText("Clientes");
		}
		
		if(arg0.getSource() == bRegresar) {
			Interfaz4 in = new Interfaz4();
			in.setVisible(true);
			this.setVisible(false);
			
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() == tFacturas) {
			if(arg0.getClickCount() == 2) {
				
				int fila = tFacturas.getSelectedRow();
				
					
					tDetalle.setVisible(true);
					sql.mostrarDetalle(tDetalle, Integer.parseInt(tFacturas.getValueAt(fila, 0).toString()));
					
					
				
			
				
				
				
			}else {
				
				int row1 ;
				row1 = tFacturas.getSelectedRow();
				tFacturas.getSelectionModel().removeSelectionInterval(row1, row1);
				tDetalle.setVisible(false);
				
				
			}
				
			
			
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
}
