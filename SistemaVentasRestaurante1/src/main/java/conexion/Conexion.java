package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3309/bdRestaurant";
		String user = "root";
		String password = "root";
		
		try {
			Connection cx = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado a la base de datos");
			
			Statement st = cx.createStatement();
			ResultSet res = st.executeQuery("SELECT cliente_id, nombre FROM clientes");
			
			while(res.next()) {
				int id = res.getInt("cliente_id");
				String nom = res.getString("nombre");
				System.out.println("ID: "+ id + ", Nombre: "+ nom);
			}
			
			cx.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
