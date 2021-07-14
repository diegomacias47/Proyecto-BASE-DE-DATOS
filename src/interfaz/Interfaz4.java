
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import mySQL.SQLMetodos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Interfaz4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField fId;
	private JTextField fNombre;
	private JButton bCerrar, bMinimizar, bIngresar;
	 SQLMetodos metodos = new SQLMetodos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz4 frame = new Interfaz4();
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
	public Interfaz4() {
		setBackground(Color.GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 170, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 0, 27));
		panel.setBounds(0, 0, 347, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 327, 2);
		panel.add(separator);
		
		bMinimizar = new JButton("-");
		bMinimizar.setForeground(Color.BLACK);
		bMinimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		bMinimizar.setFocusPainted(false);
		bMinimizar.setBorderPainted(false);
		bMinimizar.setBackground(Color.WHITE);
		bMinimizar.setBounds(245, 11, 43, 25);
		bMinimizar.addActionListener(this);
		panel.add(bMinimizar);
		
		bCerrar = new JButton("X");
		bCerrar.setForeground(Color.BLACK);
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBackground(Color.WHITE);
		bCerrar.setBounds(290, 11, 45, 25);
		bCerrar.addActionListener(this);
		panel.add(bCerrar);
		
		JLabel lblNewLabel = new JLabel("Nombre del local");
		lblNewLabel.setForeground(new Color(195,195,195));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 30));
		lblNewLabel.setBounds(10, 11, 219, 77);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 121, 327, 251);
		panel_1.setBackground(new Color(210,210,210));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		bIngresar = new JButton("Ingresar");
		bIngresar.setForeground(Color.BLACK);
		bIngresar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bIngresar.setBackground(Color.WHITE);
		bIngresar.setBounds(29, 193, 263, 30);
		bIngresar.addActionListener(this);
		panel_1.add(bIngresar);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("ID del empleado:");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(29, 11, 263, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2);
		
		fId = new JTextField();
		fId.setForeground(Color.BLACK);
		fId.setHorizontalAlignment(SwingConstants.CENTER);
		fId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fId.setColumns(10);
		fId.setBounds(29, 52, 263, 30);
		panel_1.add(fId);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1 = new JLabel("Nombre del empleado:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setBounds(29, 94, 263, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2_1);
		
		fNombre = new JTextField();
		fNombre.setForeground(Color.BLACK);
		fNombre.setHorizontalAlignment(SwingConstants.CENTER);
		fNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fNombre.setColumns(10);
		fNombre.setBounds(29, 135, 263, 30);
		panel_1.add(fNombre);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bCerrar)
			System.exit(0);

		if(e.getSource() == bMinimizar)
			setExtendedState(ICONIFIED);
		
		if(e.getSource() == bIngresar) {
			int empleo = metodos.verificarSesion(Integer.parseInt(fId.getText()), fNombre.getText());
			if(empleo == 21) {
				Interfaz in = new Interfaz();
				in.setVisible(true);
				this.setVisible(false);
				
			}else if(empleo == 50) {
				Interfaz2 in = new Interfaz2();
				in.setVisible(true);
				this.setVisible(false);
				
			}else if(empleo == 215) {
				Interfaz3 in = new Interfaz3();
				in.setVisible(true);
				this.setVisible(false);
				
			}
		
		}
		
	}

}
