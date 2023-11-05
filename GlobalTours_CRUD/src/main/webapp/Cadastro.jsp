<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Cliente</title>
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
		<h1>Cadastro de Cliente</h1>
		<form action="CreateController" method="post">
			<label for="nome">Nome:</label> <input type="text" id="nome"
				name="nome" required><br>
			<br> <label for="telefone">Telefone:</label> <input type="text"
				id="telefone" name="telefone" required minlength="11" maxlength="11"
				pattern="^[0-9]+$"><br>
			<br> <label for="email">Email:</label> <input type="email"
				id="email" name="email" required><br>
			<br> <label for="senha">Senha:</label> <input type="password"
				id="senha" name="senha" required><br>
			<br> <label for="dataNascimento">Data de Nascimento:</label> <input
				type="date" id="dataNascimento" name="dataNascimento" required><br>
			<br>

			<div class="botoes">
				<input type="submit" value="Cadastrar"> <a
					href="ListaClientes">Ver clientes</a>
			</div>
		</form>
	</main>

</body>

<script>
	function validateForm() {
		// Valida o campo de telefone
		var telefone = document.getElementById("telefone").value;
		if (!telefone.match(/^[0-9]+$/)) {
			alert("O campo de telefone deve conter apenas números.");
			return false;
		}

		return true;
	}

	// Verifica a validação do formulário antes de enviá-lo
	document.querySelector("form").addEventListener("submit", validateForm);
</script>
</html>