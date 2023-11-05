package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//import database.DBConnection;
import model.Cliente;

public class ClienteDAO {

    private Connection connection;
    
    public ClienteDAO(Connection connection) {
    	this.connection = connection;
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome_cliente, telefone_cliente, email_cliente, dataNascimento, senha_cliente) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome_cliente());
            statement.setString(2, cliente.getTelefone_cliente());
            statement.setString(3, cliente.getEmail_cliente());
            statement.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
            statement.setString(5, cliente.getSenha_cliente());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();

        String sql = "SELECT * FROM cliente";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();

                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome_cliente(resultSet.getString("nome_cliente"));
                cliente.setEmail_cliente(resultSet.getString("email_cliente"));
                cliente.setTelefone_cliente(resultSet.getString("telefone_cliente"));
                try {
                    String dataNascimentoStr = resultSet.getString("dataNascimento");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

                    cliente.setDataNascimento(dataNascimento);
                } catch (SQLException e) {
                	e.printStackTrace();
                }

                clientes.add(cliente);
            }
        }

        return clientes;
    }
    
    public Cliente encontrarPorID(int id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int clienteID = resultSet.getInt("id_cliente");
                String nome = resultSet.getString("nome_cliente");
                String telefone = resultSet.getString("telefone_cliente");
                String email = resultSet.getString("email_cliente");

                Cliente cliente = new Cliente();
                cliente.setId_cliente(clienteID);
                cliente.setNome_cliente(nome);
                cliente.setTelefone_cliente(telefone);
                cliente.setEmail_cliente(email);

                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deletarPorID(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(int id, String novoNome, String novoTelefone, String novoEmail, LocalDate novaDataNascimento,
            String novaSenha) {
        String sql = "UPDATE cliente SET nome_cliente = ?, telefone_cliente = ?, email_cliente = ?, dataNascimento = ?, senha_cliente = ? WHERE id_cliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, novoNome);
            statement.setString(2, novoTelefone);
            statement.setString(3, novoEmail);
            statement.setDate(4, java.sql.Date.valueOf(novaDataNascimento));
            statement.setString(5, novaSenha);
            statement.setInt(6, id);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("O cadastro do cliente foi atualizado com sucesso!");
            } else {
                System.out.println("Nenhum cliente foi atualizado. Verifique o ID informado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
