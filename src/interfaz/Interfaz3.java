package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mySQL.SQLMetodos;
import tablas.producto;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Interfaz3 extends JFrame implements ActionListener, MouseListener, KeyListener {

	//private ArrayList<producto> almacen = new ArrayList<producto>();
	private ArrayList<producto> almacen = new ArrayList<producto>();
	private SQLMetodos sql = new SQLMetodos();
	private JPanel contentPane;
	private JTextField fCantidad;
	private JTextField nom_cli;
	private JTextField mail_cli;
	private JTextField fTotal;
	private JTextField fEfectivo;
	private JTextField fCambio;
	private JButton bPagar, bQuitar, bAñadir, bMinimizar, bCerrar, bRegresar;
	private TextPrompt tp;
	private TextPrompt tp_2;
	private TextPrompt tp_1;
	private JTable tProductos;
	private JTable tTicket;
	private JLabel eDisponible;
	private float fEfec;
	
	private float fTot;
	private int iDisponible, iDiferencia, iFila;;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz3 frame = new Interfaz3();
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
	public Interfaz3() {
		setBackground(Color.GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 170, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 0, 27));
		panel.setBounds(0, 0, 997, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Icono del negocio");
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1.setForeground(new Color(195,195,195));
		lblNewLabel_1.setBounds(10, 11, 183, 113);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 122, 980, 2);
		panel.add(separator);
		
		bRegresar = new JButton("\u2190");
		bRegresar.setForeground(Color.BLACK);
		bRegresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		bRegresar.setFocusPainted(false);
		bRegresar.setBorder(null);
		bRegresar.setBackground(Color.WHITE);
		bRegresar.setBounds(837, 11, 41, 25);
		bRegresar.addActionListener(this);
		panel.add(bRegresar);
		
		bMinimizar = new JButton("-");
		bMinimizar.setForeground(Color.BLACK);
		bMinimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		bMinimizar.setFocusPainted(false);
		bMinimizar.setBorderPainted(false);
		bMinimizar.setBackground(Color.WHITE);
		bMinimizar.setBounds(880, 11, 43, 25);
		bMinimizar.addActionListener(this);
		panel.add(bMinimizar);
		
		bCerrar = new JButton("X");
		bCerrar.setForeground(Color.BLACK);
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBackground(Color.WHITE);
		bCerrar.setBounds(925, 11, 45, 25);
		bCerrar.addActionListener(this);
		panel.add(bCerrar);
		
		JLabel lblNewLabel = new JLabel("Nombre del local");
		lblNewLabel.setForeground(new Color(195,195,195));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 46));
		lblNewLabel.setBounds(200, 11, 690, 113);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 146, 472, 503);
		panel_1.setBackground(new Color(210,210,210));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 452, 70);
		panel_3.setBackground(new Color(100,0,27));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos del cliente");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(195, 195, 195));
		lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1_1.setBounds(10, 11, 335, 48);
		panel_3.add(lblNewLabel_1_1);
		
		bAñadir = new JButton("A\u00F1adir a la lista de compra");
		bAñadir.setForeground(Color.BLACK);
		bAñadir.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bAñadir.setBackground(Color.WHITE);
		bAñadir.setBounds(212, 451, 250, 30);
		bAñadir.addActionListener(this);
		panel_1.add(bAñadir);
		
		nom_cli = new JTextField();
		nom_cli.setBorder(null);
		nom_cli.setForeground(Color.BLACK);
		nom_cli.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nom_cli.setBounds(10, 88, 362, 30);
		panel_1.add(nom_cli);
		tp = new TextPrompt("Nombre del cliente", nom_cli);
		tp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nom_cli.setBackground(new Color(210,210,210));
		nom_cli.setColumns(10);
		
		mail_cli = new JTextField();
		mail_cli.setBorder(null);
		mail_cli.setForeground(Color.BLACK);
		mail_cli.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mail_cli.setBounds(10, 128, 362, 30);
		panel_1.add(mail_cli);
		mail_cli.setBackground(new Color(210,210,210));
		tp_1 = new TextPrompt("Correo electronico del cliente (opcional)", mail_cli);
		tp_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mail_cli.setColumns(10);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(100, 0, 27));
		panel_3_2.setBounds(13, 170, 449, 70);
		panel_1.add(panel_3_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Productos");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(195, 195, 195));
		lblNewLabel_1_1_2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1_1_2.setBounds(10, 12, 335, 48);
		panel_3_2.add(lblNewLabel_1_1_2);
		
		fCantidad = new JTextField();
		fCantidad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fCantidad.setForeground(Color.BLACK);
		fCantidad.setBackground(new Color(210,210,210));
		fCantidad.setBorder(null);
		tp_2 = new TextPrompt("Cantidad deseada", fCantidad);
		tp_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fCantidad.setBounds(212, 410, 250, 30);
		panel_1.add(fCantidad);
		fCantidad.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 251, 452, 148);
		panel_1.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
		);
		
		tProductos = new JTable();
		tProductos.addMouseListener(this);
		scrollPane.setViewportView(tProductos);
		panel_4.setLayout(gl_panel_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 118, 360, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(10, 158, 360, 2);
		panel_1.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(212, 440, 250, 2);
		panel_1.add(separator_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(492, 146, 10, 503);
		contentPane.add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(210, 210, 210));
		panel_1_1.setBounds(512, 146, 472, 503);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 92, 452, 154);
		panel_1_1.add(panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
		);
		
		tTicket = new JTable();
		scrollPane_1.setViewportView(tTicket);
		tTicket.addMouseListener(this);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(100,0,27));
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 11, 452, 70);
		panel_1_1.add(panel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lista de compra");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(195, 195, 195));
		lblNewLabel_1_1_1.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 26));
		lblNewLabel_1_1_1.setBounds(10, 11, 430, 48);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		bQuitar = new JButton("Quitar de la lista de compra");
		bQuitar.setBounds(10, 257, 224, 30);
		bQuitar.addActionListener(this);
		panel_1_1.add(bQuitar);
		
		bQuitar.setBackground(Color.WHITE);
		bQuitar.setForeground(Color.BLACK);
		bQuitar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		fTotal = new JTextField();
		fTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fTotal.setColumns(10);
		fTotal.setEditable(false);
		fTotal.setBounds(343, 298, 117, 30);
		panel_1_1.add(fTotal);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("Total: ");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(160, 298, 173, 30);
		panel_1_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2);
		
		fEfectivo = new JTextField();
		fEfectivo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fEfectivo.setForeground(Color.BLACK);
		fEfectivo.setBorder(null);
		fEfectivo.setColumns(10);		
		fEfectivo.setBounds(343, 337, 117, 30);
		fEfectivo.addKeyListener(this);
		panel_1_1.add(fEfectivo);
		
		fCambio = new JTextField();
		fCambio.setBorder(null);
		fCambio.setForeground(Color.BLACK);
		fCambio.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fCambio.setColumns(10);		
		fCambio.setBounds(343, 378, 117, 30);
		panel_1_1.add(fCambio);
		
		bPagar = new JButton("Realizar venta");
		bPagar.setForeground(Color.BLACK);
		bPagar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bPagar.setBackground(Color.WHITE);
		bPagar.setBounds(275, 443, 185, 30);
		bPagar.addActionListener(this);
		bPagar.setEnabled(false);
		panel_1_1.add(bPagar);
		
		diseñoTablaProductos(tProductos);
		diseñoTabla(tProductos);
		
		eDisponible = new JLabel("Disponible:");
		eDisponible.setForeground(Color.BLACK);
		eDisponible.setFont(new Font("Times New Roman", Font.BOLD, 14));
		eDisponible.setBounds(20, 409, 125, 30);
		panel_1.add(eDisponible);
		diseñoTabla(tTicket);
		diseñoTablaTicket(tTicket);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1 = new JLabel("Efectivo:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setBounds(160, 339, 173, 30);
		panel_1_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1_1 = new JLabel("Cambio:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setBounds(160, 378, 173, 30);
		panel_1_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2_1_1);
		
		fCantidad.setEditable(false);
		setLocationRelativeTo(null);
	}
	
	
	public void diseñoTablaProductos(JTable tabla) {
		
		sql.aProductos(almacen);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Unidades");
		modelo.addColumn("Precio");
		
		
		for(int i=0; i<almacen.size(); i++) {
								
			modelo.addRow(new Object[] {almacen.get(i).id_pro, almacen.get(i).nom_pro, almacen.get(i).cant_pro, almacen.get(i).pre_pro });
			
			
		}
		
		tabla.setModel(modelo);
		
	}
	
	public void diseñoTablaTicket(JTable tabla) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Unidades");
		modelo.addColumn("Precio");
		modelo.addColumn("Total");
		
		tabla.setModel(modelo);
		
		
		
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
		if(arg0.getSource() == bAñadir) {
			
			DecimalFormat df = new DecimalFormat("#.00");
			fTot = 0;
			iFila = tProductos.getSelectedRow();
			float total = Integer.parseInt(fCantidad.getText()) * almacen.get(iFila).pre_pro;
			iDiferencia = iDisponible - Integer.parseInt(fCantidad.getText());
			DefaultTableModel modelo = (DefaultTableModel) tTicket.getModel();				
			modelo.addRow(new Object[] {almacen.get(iFila).id_pro, fCantidad.getText(), almacen.get(iFila).pre_pro, String.valueOf(df.format(total))});							
			tTicket.setModel(modelo);
			
			sql.actualizarProductos(almacen.get(iFila).id_pro,Integer.parseInt(fCantidad.getText()) , iDisponible, true);
			fCantidad.setText(null);	
			
			for(int i=0; i<tTicket.getRowCount(); i++) {
				fTot = fTot + Float.parseFloat(tTicket.getValueAt(i, 3).toString());
				
				
				
			}
			
			fTotal.setText(""+ fTot);
			
			DefaultTableModel modelo2 = (DefaultTableModel) tProductos.getModel();	
			modelo2.setValueAt(iDiferencia, iFila, 2 );	
			tProductos.setModel(modelo2);
			eDisponible.setText("Disponible: " + iDiferencia);
			fCantidad.setEditable(false);
			iDiferencia = 0;
			
		}
		
		if(arg0.getSource() == bQuitar) {
			DefaultTableModel modelo2 = (DefaultTableModel) tProductos.getModel();	
			
			int fila = tTicket.getSelectedRow();
			int disp=0;
			for(int i=0; i<tProductos.getRowCount();i++) {
				if(almacen.get(i).id_pro == Integer.parseInt(tTicket.getValueAt(fila, 0).toString()) ) {
					disp =Integer.parseInt(tProductos.getValueAt(i, 2).toString()); 
					modelo2.setValueAt(disp + Integer.parseInt(tTicket.getValueAt(fila, 1).toString()), i, 2 );	
				}
					
					
				
			}
			
			float tot = Float.parseFloat(tTicket.getValueAt(fila, 3).toString());
			sql.actualizarProductos(Integer.parseInt(tTicket.getValueAt(fila, 0).toString()), Integer.parseInt(tTicket.getValueAt(fila, 1).toString()), disp, false);
			DefaultTableModel modelo = (DefaultTableModel) tTicket.getModel();	

			fTot = fTot - tot;
			modelo.removeRow(fila);
			fTotal.setText("" + fTot);
			

			

			
		}
		
		if(arg0.getSource() == bPagar) {
		
			int id = sql.agregarCliente(nom_cli.getText(), mail_cli.getText());
			int id_fac = sql.agregarFactura(id, Float.parseFloat(fTotal.getText()), Float.parseFloat(fEfectivo.getText()), Float.parseFloat(fCambio.getText()));
			
			for(int i=0;i<tTicket.getRowCount(); i++) {
				
				sql.agregarDetalles(id_fac, Integer.parseInt(tTicket.getValueAt(i, 0).toString()), Integer.parseInt(tTicket.getValueAt(i, 1).toString()), Float.parseFloat(tTicket.getValueAt(i, 2).toString()), Float.parseFloat(tTicket.getValueAt(i,3).toString()));
			}
			
			DefaultTableModel mod = (DefaultTableModel) tTicket.getModel();
			mod.setRowCount(0);
			
			fTotal.setText(null);
			fEfectivo.setText(null);
			fCambio.setText(null);
			
			JOptionPane.showMessageDialog(null, "Venta generada");
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
		if(arg0.getSource() == tProductos) {
			if(arg0.getClickCount() == 2) {								
				iFila = tProductos.getSelectedRow();				
				if(iFila >= 0) {
					fCantidad.setEditable(true);
					iDisponible = almacen.get(iFila).cant_pro;
					eDisponible.setText("Disponible: " + iDisponible);
					
				}

			}else {
					int row1 ;
					row1 = tProductos.getSelectedRow();
					tProductos.getSelectionModel().removeSelectionInterval(row1, row1);
					eDisponible.setText("Disponible: ");
				}
		}
		
		if(arg0.getSource() == tTicket) {
			
			
		}
			
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == fEfectivo) {
			
			float efectivo = Float.parseFloat(fEfectivo.getText());
			float total = Float.parseFloat(fTotal.getText());
			if(fEfectivo.getText().equals(null))
				efectivo = 0;
			
			if(efectivo < total) {
				
				fEfectivo.setForeground(new Color(200,0,0));
				bPagar.setEnabled(false);
				
			}else if(efectivo >= total){
				DecimalFormat df = new DecimalFormat("#.00");
				fEfectivo.setForeground(new Color(0,200,0));
				bPagar.setEnabled(true);
				float cambio =  efectivo - total;
				fCambio.setText("" + df.format(cambio));
			}
			
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		if(arg0.getSource() == fEfectivo) {
		char validar = arg0.getKeyChar();
		if(Character.isLetter(validar) ) {
			getToolkit().beep();
			arg0.consume();
			
			
			
		}
			
			
		}

		
	}
}
