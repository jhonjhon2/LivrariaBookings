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
<link rel="stylesheet" href="../../resources/css/estilo.css">
</head>
<body>
	<div class="container" style="margin-top: 5%">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<fieldset>
					<legend class="text-center">Gerenciamento de Produto</legend>
					<form class="form" action="save" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label for="id_nome">Nome</label> <input type="text"
								class="form-control" name="nome" id="id_nome"
								value="${produto.nmProduto}" required>
						</div>
						<div class="form-group">
							<label for="id_quantidade">Quantidade</label> <input
								type="number" class="form-control" name="quantidade"
								id="id_quantidade" value="${produto.quantidade}" required>
						</div>
						<div class="form-group">
							<label for="id_preco">Preço</label> <input type="number"
								class="form-control" step="0.10" name="preco" id="id_preco"
								value="${produto.preco}" required>
						</div>
						<div class="form-group">
							<label class="col-md-12" for="id_foto">Imagem</label>

							<div class="col-md-6">
								<div class="col-md-offset-2">
									<div class="col-sm-8 col-md-10">
										<div class="thumbnail">
											<img id="img_preview" />
											<div class="caption">
												<h3 class="text-center" id="img_title">Imagem do
													produto</h3>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<input type="file" class="form-control" name="foto" id="id_foto">
							</div>
						</div>
						<div class="form-group">
							<input type="hidden" name="imagem" id="id_imagem"
								value="${produto.imagem}" readonly>

						</div>
						<button name="id" value="${produto.id}"
							class="btn btn-success btn-block">Salvar</button>
					</form>
				</fieldset>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script src="../../resources/js/main.js"></script>
</body>
</html>