package pe.edu.ucs.SistemaVentasRestaurante.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pe.edu.ucs.SistemaVentasRestaurante.modelo.PedidoDAO;

/**
 * Servlet implementation class pedido
 */
@WebServlet("/pedido")
public class pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PedidoDAO dao = new PedidoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String registrar = request.getParameter("btnAgre");
		if("Agregar Pedido".equals(registrar)) {
			String cliente = request.getParameter("txtcliente");
			String plato = request.getParameter("selecPlato");
			int cantidad = Integer.parseInt(request.getParameter("numcantidad"));
			
			 try {
		            dao.insertarPedido(cliente, plato, cantidad);
		            response.sendRedirect("login.html");
		        } catch (Exception e) {
		            e.printStackTrace(); // o loguea
		            response.getWriter().println("Error al registrar pedido: " + e.getMessage());
		        }
			 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
