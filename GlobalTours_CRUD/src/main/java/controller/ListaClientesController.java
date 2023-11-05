package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import dao.ClienteDAO;
import database.DBConnection;


@WebServlet("/ListaClientes")
public class ListaClientesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Connection connection = DBConnection.createConnection();
	ClienteDAO clienteDAO = new ClienteDAO(connection);

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém a lista de clientes
        List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = clienteDAO.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request, response);
    }
}
