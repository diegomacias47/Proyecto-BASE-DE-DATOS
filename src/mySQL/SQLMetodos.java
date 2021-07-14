package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tablas.empleado;
import tablas.producto;
import tablas.proveedor;

public class SQLMetodos {
	Statement st;
	ResultSet rs;
	Connection cn;
	PreparedStatement pps;
	
	
	
	
	public Connection Conectar() 
	{
		
		try {
			
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_verano?serverTimezone=UTC","root","8VdFxva6"); 
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return cn;
	
	}
	
    public Connection Desconectar(){
        try{
        	
            cn.close();
            
        }catch(SQLException ex){
            
        }return cn;
    }
	
    
    public void agregarEmpleado(empleado emp) {
    	
    	Conectar();
    	String sql = "INSERT INTO empleado(id_emp, nom_emp, dir_emp, edad_emp, tel_emp, id_trabajo) VALUES(?,?,?,?,?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setInt(1, emp.id_emp);
			pps.setString(2, emp.nom_emp);
			pps.setString(3, emp.dir_emp);
			pps.setString(4, emp.edad_emp);
			pps.setString(5, emp.tel_emp);
			pps.setInt(6, emp.id_tra);
			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    }
    
    public void mostrarTrabajos(JTable tabla, JComboBox<String> combo) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Trabajo");    	
    	
    	
    	Conectar();
    	
    	String[] datos = new String[2];
    	
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM trabajo");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				combo.addItem(rs.getString(1));
				datos[1] = rs.getString(2);
				modelo.addRow(datos);
				
			}
			
			tabla.setModel(modelo);	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
    	
    	Desconectar();
    	
    }
    
    public void mostrarEmpleados(JTable tabla) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Nombre");  
    	modelo.addColumn("Edad");
    	modelo.addColumn("Trabajo");
    	
    	Conectar();
    	
    	String[] datos = new String[4];
    	
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM empleado");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(6);
				modelo.addRow(datos);
				
			}
			
			tabla.setModel(modelo);	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
    	
    	Desconectar();
    }
    
    public void mostrarProveedores(JTable tabla) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Nombre");  
    	modelo.addColumn("Telefono");
    	Conectar();
    	
    	String[] datos = new String[3];
    	
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM proveedor");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(4);

				modelo.addRow(datos);
				
			}
			
			tabla.setModel(modelo);	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
    	
    	Desconectar();
    	
    }
    
    public void agregarProveedor(proveedor prov) {
    	Conectar();
    	String sql = "INSERT INTO proveedor(id_prov, nom_prov, dir_prov, tel_prov, correo_prov) VALUES(?,?,?,?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setInt(1, prov.id_prov);
			pps.setString(2, prov.nom_prov);
			pps.setString(3, prov.dir_prov);
			pps.setString(4, prov.tel_prov);
			pps.setString(5, prov.correo_prov);
			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    }
    
    public void agregarCategoria(int id, String des) {
    	Conectar();
    	String sql = "INSERT INTO tipo_producto(id_tipo, des_tipo) VALUES(?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setInt(1, id);
			pps.setString(2, des);

			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    }
    
    public void agregarProducto(producto pro) {
    	Conectar();
    	String sql = "INSERT INTO producto(id_pro, nom_pro, des_pro, cant_pro, pre_pro, id_tipo, id_prov) VALUES(?,?,?,?,?,?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setInt(1, pro.id_pro);
			pps.setString(2, pro.nom_pro);
			pps.setString(3, pro.des_pro);
			pps.setInt(4, pro.cant_pro);
			pps.setFloat(5, pro.pre_pro);
			pps.setInt(6, pro.id_cat);
			pps.setInt(7, pro.id_prov);

			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    }
    
    public void mostrarCategoria(JTable tabla) {
    	
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Descripcion");
    	
    	Conectar();
    	String[] datos = new String[2];
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM tipo_producto");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				modelo.addRow(datos);
			}
			
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    	
    }
    
    public void mostrarProveedor2(JTable tabla, JComboBox<String> combo) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Nombre");  
    	
    	Conectar();
    	
    	String[] datos = new String[2];
    	
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM proveedor");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				combo.addItem(rs.getString(1));
				datos[1] = rs.getString(2);
				

				modelo.addRow(datos);
				
			}
			
			tabla.setModel(modelo);	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
    	
    	Desconectar();
    }
    
    public void mostrarProducto(JTable tabla) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Nombre");  
    	modelo.addColumn("Cantidad");
    	modelo.addColumn("Precio");  
    	modelo.addColumn("Tipo");
    	modelo.addColumn("Proveedor");
    	Conectar();
    	
    	String[] datos = new String[6];
    	
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM producto");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(4);
				datos[3] = rs.getString(5);
				datos[4] = rs.getString(6);
				datos[5] = rs.getString(7);

				
				modelo.addRow(datos);
				
			}
			
			tabla.setModel(modelo);	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
    	
    	Desconectar();
    }
    
    public void mostrarCategorias(JComboBox<String> combo) {
    	Conectar();
    	
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM tipo_producto");
			while(rs.next()) {
				
				combo.addItem(rs.getString(1));
				
			}
		
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    }

    public int agregarCliente(String nom, String correo) {
    	Conectar();
    	String sql = "INSERT INTO cliente(nom_cli, correo_cli) VALUES(?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setString(1, nom);
			pps.setString(2, correo);
			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	int id=0;
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente ORDER BY id_cli DESC");  
			
			
			while(rs.next()) {
				if(rs.isFirst())
				id = rs.getInt(1);
			}
		
		
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	Desconectar();
    	
    	
    	return id;
    }

    public  void aProductos(ArrayList<producto> pro) {
    	
    	
    	Conectar();
    	try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM producto");
			while(rs.next()) {
				
				pro.add(new producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getInt(7)));
			}
	    	st.close();
	    	rs.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		Desconectar();
		
    	
    }
    	
    public void actualizarProductos(int id, int deseada , int cantidadt, boolean estatus) {
    	if(estatus == true) {
    		cantidadt = cantidadt - deseada;
    		
    	}else {
    		cantidadt += deseada;
    		
    	}
    	
    	String sql = " UPDATE producto SET CANT_pro ='" + cantidadt +"'WHERE id_pro='"+ id +"';";
    	Conectar();
    	try {
			pps = cn.prepareStatement(sql);
			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	Desconectar();

    	
    }
    
    public int agregarFactura(int id_cli, float total, float efectivo, float cambio) {
    	Conectar();
    	String sql = "INSERT INTO factura(id_cli, total_fac, efec_fac, cam_fac) VALUES(?,?,?,?)";
    	try {
			pps = cn.prepareStatement(sql);
			pps.setInt(1, id_cli);
			pps.setFloat(2, total);
			pps.setFloat(3, efectivo);
			pps.setFloat(4, cambio);
			pps.executeUpdate();
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	int id=0;
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM factura ORDER BY id_fac DESC");  
			
			
			while(rs.next()) {
				if(rs.isFirst())
				id = rs.getInt(1);
			}
		
		
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	return id;
    }

    public void agregarDetalles(int id_fac, int id_pro, int cant_pro, float pre_pro, float tot_pro) {
    	Conectar();
		try {
			pps = cn.prepareStatement("INSERT INTO detalle(id_fac, id_pro, cant_pro , pre_pro, tot_pro)  VALUES(?,?,?,?,?)");
																								
			pps.setString(1, String.valueOf(id_fac));
			pps.setString(2, String.valueOf(id_pro));
			pps.setString(3, String.valueOf(cant_pro));
			pps.setString(4, String.valueOf(pre_pro));
			pps.setString(5, String.valueOf(tot_pro));
		

			pps.executeUpdate();
			pps.close();
			

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}		
		Desconectar();	
    	
    }

    public void mostrarFacturas(JTable tabla) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID Factura");
    	modelo.addColumn("ID Cliente");
    	modelo.addColumn("Total $");
    	modelo.addColumn("Efectivo $");
    	modelo.addColumn("Cambio $");
    	
    	
    	Conectar();
    	
    	String[] datos = new String[5];
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM factura");
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				
				modelo.addRow(datos);
				
				
				
			}
		
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    	
    }

    public void mostrarDetalle(JTable tabla, int id_fac) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	//modelo.addColumn("Factura");
    	modelo.addColumn("Producto");
    	modelo.addColumn("Cantidad");
    	modelo.addColumn("Precio");
    	modelo.addColumn("Subtotal");
    	    	
    	Conectar();
    	
    	String[] datos = new String[4];
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM detalle WHERE id_fac = '" + id_fac + "'"); 
			while(rs.next()) {
				
				//datos[0] = rs.getString(2);
				datos[0] = rs.getString(3);
				datos[1] = rs.getString(4);
				datos[2] = rs.getString(5);
				datos[3] = rs.getString(6);
				
				modelo.addRow(datos);
				
				
				
			}
		
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    }

    public int verificarSesion(int id, String nom) {
    	Conectar();
    	int empleo=0;
    	
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM empleado WHERE id_emp ='" + id + "' AND nom_emp = '" + nom + "'"); 
			while(rs.next()) {
				//if(rs.getInt(1) == id && rs.getString(2).equals(nom)) {
					empleo = rs.getInt(6);
											
				//}
				
			}
		
			
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    	return empleo;
    	
    	
    }
    
    public String trabajo() {
    	Conectar();
    	String dato = null;
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM empleado "); 
			while(rs.next()) {
				
				
			}	
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    	return dato;
    }


    public void mostrarCliente(JTable tabla) {
    	DefaultTableModel modelo = new DefaultTableModel();
    	modelo.addColumn("ID");
    	modelo.addColumn("Nombre");
    	modelo.addColumn("Correo electronico");

    	String[] datos = new String[3];
    	
    	Conectar();    	
    	
    	try {
    		st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente "); 
			while(rs.next()) {
								
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				;		
				
				modelo.addRow(datos);			
			}
		
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	Desconectar();
    	
    	
    }
}
