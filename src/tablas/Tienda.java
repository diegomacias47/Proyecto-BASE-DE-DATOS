package tablas;

import java.util.ArrayList;
import java.util.Scanner;

import mySQL.SQLMetodos;



public class Tienda {
	
	Scanner di = new Scanner(System.in);
	
	SQLMetodos me = new SQLMetodos();
	
	public static void main(String[] args)
	{
		Tienda ti = new Tienda();
		ti.menu();
		
	

	}
	
	public void menu() {
		int op;
		
		do 
		{
			System.out.println("******************************************************************");
			
			System.out.println("       MENU \n");
			System.out.println("1-.Agregar empleado");
			System.out.println("2-.Salir"); 
			
			System.out.println("¿Que opcion desea?: "); 
			
			op = Integer.parseInt(di.nextLine());
			
			System.out.println("*******************************************************************");	
			
		
		switch(op) {
			case 1:
			addEmploye();
			break;
		
		
		}
		
		
		}while(op != 2);
		
		
	}
	
	public void addEmploye() {
		
		
		System.out.println("Nombre del empleado: ");
		String nom = di.nextLine();
		System.out.println("Direccion del empleado: ");
		String dir = di.nextLine();
		System.out.println("Edad del empleado: ");
		String edad = di.nextLine();
		System.out.println("Telefono del empleado: ");
		String tel = di.nextLine();
		
		//me.AddEmploye(new empleado(nom, dir, edad, tel));
		
	}
	
}
