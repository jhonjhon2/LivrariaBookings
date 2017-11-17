<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seja Bem vindo ao loveFood | Área do cliente</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 5%">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<fieldset>
					<legend class="text-center">Editação do Perfil</legend>
					<form class="form" action="salvar" method="post">
						<div class="form-group">
							<label for="id_login">Login</label>
							<input type="text"
								class="form-control" name="login" id="id_login" value="${cliente.login}" readonly>
						</div>
						<div class="form-group">
							<label for="id_nome">Nome</label>
							<input type="text"
								class="form-control" name="nome" id="id_nome" value="${cliente.nome}" required>
						</div>
						<div class="form-group">
							<label for="id_cpf">CPF</label> <input type="text"
								class="form-control" name="cpf" id="id_cpf" value="${cliente.cpf}" required>
						</div>
						<div class="form-group">
							<label for="id_telefone">Telefone</label> <input type="tel"
								class="form-control" name="telefone" id="id_telefone" value="${cliente.telefone}" required>
						</div>
						<div class="form-group">
							<label for="id_endereco">Endereço</label> <input type="text"
								class="form-control" name="endereco" id="id_endereco" value="${cliente.endereco}" required>
						</div>
						<button name="id" value="${cliente.id}" class="btn btn-success btn-block">Salvar</button>
					</form>
				</fieldset>
			</div>
		</div>
		<!-- /.row -->
	</div>
</body>
</html>