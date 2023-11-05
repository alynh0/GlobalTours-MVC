package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import database.DBConnection;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		Connection connection = DBConnection.createConnection();
		
		ClienteDAO clienteDAO = new ClienteDAO(connection);

		try {
			System.out.println(id);
			clienteDAO.deletarPorID(id);
			response.sendRedirect("ListaClientes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
