<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seja Bem vindo ao loveFood | Área do Administrador</title>
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
					<legend class="text-center">Gerenciamento de Produto</legend>
					<form class="form" action="save" method="post">
						<div class="form-group">
							<label for="id_nome">Nome</label>
							<input type="text"
								class="form-control" name="nome" id="id_nome" value="${produto.nmProduto}" required>
						</div>
						<div class="form-group">
							<label for="id_quantidade">Quantidade</label>
							<input type="number"
								class="form-control" name="quantidade" id="id_quantidade" value="${produto.quantidade}" required>
						</div>
						<div class="form-group">
							<label for="id_preco">Preço</label> <input type="number"
								class="form-control" step="0.10" name="preco" id="id_preco" value="${produto.preco}" required>
						</div>
						<div class="form-group">
							<label for="id_foto">Imagem</label> <input type="file"
								class="form-control" name="foto" id="id_foto">
						</div>
						<div class="form-group">
							<input type="hidden" name="imagem" id="id_imagem" value="${produto.imagem}" readonly>
						</div>
						<button name="id" value="${produto.id}" class="btn btn-success btn-block">Salvar</button>
					</form>
				</fieldset>
			</div>
		</div>
		<!-- /.row -->
	</div>
</body>
</html>