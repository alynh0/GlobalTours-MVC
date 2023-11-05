package controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import dao.ClienteDAO;
import database.DBConnection;

@WebServlet("/EditClienteController")
public class EditClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        String nomeCliente = request.getParameter("nome_cliente");
        String telefoneCliente = request.getParameter("telefone_cliente");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
        String emailCliente = request.getParameter("email_cliente");
        String senhaCliente = request.getParameter("senha_cliente");

        Connection connection = DBConnection.createConnection();
        ClienteDAO clienteDAO = new ClienteDAO(connection);

        Cliente cliente = new Cliente();
        cliente.setId_cliente(idCliente);
        cliente.setNome_cliente(nomeCliente);
        cliente.setTelefone_cliente(telefoneCliente);
        cliente.setDataNascimento(dataNascimento);
        cliente.setEmail_cliente(emailCliente);
        cliente.setSenha_cliente(senhaCliente);
        
        System.out.println(cliente);
        clienteDAO.atualizar(idCliente, nomeCliente, telefoneCliente, emailCliente, dataNascimento, senhaCliente);
        
        response.sendRedirect("ListaClientes");

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = DBConnection.createConnection();
		ClienteDAO clienteDAO = new ClienteDAO(conn);
		Cliente cliente = clienteDAO.encontrarPorID(id);
		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

    }


}
