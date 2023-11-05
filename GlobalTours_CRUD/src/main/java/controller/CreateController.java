package controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import database.DBConnection;
import model.Cliente;

@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente cliente = new Cliente();

		cliente.setNome_cliente(request.getParameter("nome"));
		cliente.setTelefone_cliente(request.getParameter("telefone"));
		cliente.setEmail_cliente(request.getParameter("email"));
		cliente.setSenha_cliente(request.getParameter("senha"));
		cliente.setDataNascimento(LocalDate.parse(request.getParameter("dataNascimento")));

		
		Connection connection = DBConnection.createConnection();
		ClienteDAO cDAO = new ClienteDAO(connection);
		cDAO.criarCliente(cliente);
		
		response.sendRedirect("ListaClientes");
	}

}
