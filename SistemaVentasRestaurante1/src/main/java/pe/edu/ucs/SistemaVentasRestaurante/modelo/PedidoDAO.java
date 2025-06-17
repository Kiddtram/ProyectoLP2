package pe.edu.ucs.SistemaVentasRestaurante.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PedidoDAO {
	
	
	private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3309/bdRestaurant", "root", "root");
    }


	public void insertarPedido(String nombreCliente, String plato, int cantidad) throws SQLException {
		
		
		try (Connection conn = getConnection()){
			conn.setAutoCommit(false);

			int clienteId = obtenerOInsertarCliente(conn,nombreCliente);
			int pedidoId = insertarPedido(conn,plato, cantidad);
			insertarRegistroPedido(conn,clienteId, pedidoId);

			conn.commit();
		} catch (SQLException e) {
			try (Connection conn = getConnection()) {
	            conn.rollback(); // <- Evita inconsistencias si falla algo
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
			throw e;
		}
	}

	private int obtenerOInsertarCliente(Connection conn,String nombre) throws SQLException {
		String queryBuscar = "SELECT cliente_id FROM Clientes WHERE nombre = ?";
		try (PreparedStatement stmt = conn.prepareStatement(queryBuscar)) {
			stmt.setString(1, nombre);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cliente_id");
			}
		}

		// Insertar cliente si no existe
		String insertCliente = "INSERT INTO Clientes (nombre) VALUES (?)";
		try (PreparedStatement stmt = conn.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, nombre);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new SQLException("Error al insertar cliente.");
			}
		}
	}

	private int insertarPedido(Connection conn,String plato, int cantidad) throws SQLException {
		String insertPedido = "INSERT INTO Pedido (plato, cantidad) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(insertPedido, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, plato);
			stmt.setInt(2, cantidad);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new SQLException("Error al insertar pedido.");
			}
		}
	}

	private void insertarRegistroPedido(Connection conn,int clienteId, int pedidoId) throws SQLException {
		String insertRegistro = "INSERT INTO Registro_pedido (cliente_id, pedido_id) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(insertRegistro)) {
			stmt.setInt(1, clienteId);
			stmt.setInt(2, pedidoId);
			stmt.executeUpdate();
		}
	}
}
