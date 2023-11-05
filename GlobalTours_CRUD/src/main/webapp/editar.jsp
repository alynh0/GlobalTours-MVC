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
<title>Editar Informações | GlobalTours</title>
<link rel="shortcut icon" href="assets/logo.png" type="image/x-icon" />
<link rel="stylesheet" href="css/cadastro.css" />
</head>
<body>
	<nav>
		<div class="logo">
			<a href="index.html"> <img src="assets/logo.png" alt="Logo" />
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
	<main>
		<h1>Editar Informações</h1>
		<form action="EditClienteController" method="post">
			<input type="hidden" name="id_cliente" value="${cliente.id_cliente}">

			<label for="nome_cliente">Nome:</label> <input type="text"
				id="nome_cliente" name="nome_cliente" required><br> <br>
			<label for="telefone_cliente">Telefone:</label> <input type="text"
				id="telefone_cliente" name="telefone_cliente" required
				minlength="11" maxlength="11" pattern="^[0-9]+$"><br> <br>
			<label for="dataNascimento">Data de Nascimento:</label> <input
				type="date" id="dataNascimento" name="dataNascimento" required><br>
			<br> <label for="email_cliente">Email:</label> <input
				type="email" id="email_cliente" name="email_cliente" required><br>
			<br> <label for="senha">Senha:</label> <input type="password"
				id="senha_cliente" name="senha_cliente" required><br> <br>

			<div class="botoes">
				<input type="submit" value="Salvar Alterações"> <a
					href="DeleteController?id=${cliente.id_cliente}">Excluir
					cliente</a>
			</div>
		</form>
	</main>

</body>
</html>