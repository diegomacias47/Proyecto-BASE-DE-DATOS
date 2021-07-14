package tablas;

public class producto {
	
	public int id_pro;
	public String nom_pro;
	public String des_pro;
	public int cant_pro;
	public float pre_pro;
	public int id_cat;
	public int id_prov;
	
	public producto(int id_pro, String nom_pro, String des_pro, int cant_pro, float pre_pro, int id_cat, int id_prov ) {
		this.id_pro = id_pro;
		this.nom_pro = nom_pro;
		this.des_pro = des_pro;
		this.cant_pro = cant_pro;
		this.pre_pro = pre_pro;
		this.id_cat = id_cat;
		this.id_prov = id_prov;
		
	}
	
}
