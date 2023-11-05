<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="model.Cliente"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="css/cadastro.css" />
    <link rel="stylesheet" href="css/tabelas.css" />
    <link rel="shortcut icon" href="assets/logo.png" type="image/x-icon" />
</head>
<body>
    <nav>
      <div class="logo">
        <a href="index.html">
          <img src="assets/logo.png" alt="Logo" />
          <p>GlobalTours</p>
        </a>
      </div>
      <div class="menu">
        <ul>
          <li><a href="index.html">Home</a></li>
          <li><a href="index.html#sectionDestinos">Destinos</a></li>
          <li><a href="contact.html">Contato</a></li>
          <li><a href="login.html">Login</a></li>
          <li><a href="Cadastro.jsp">Cadastro</a></li>
        </ul>
      </div>
    </nav>
    <h1>Lista de Clientes</h1>

	<div class="table-container">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Data de Nascimento</th>
				<th>E-mail</th>
				<th>Editar</th>
			</tr>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.id_cliente}</td>
					<td>${cliente.nome_cliente}</td>
					<td>${cliente.telefone_cliente}</td>
					<td>${cliente.dataNascimento}</td>
					<td>${cliente.email_cliente}</td>
					<td><a href="EditClienteController?id=${cliente.id_cliente}">Editar</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
