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
			<div class="col-lg-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<i class="fa fa-address-card-o fa-5x"></i>
							</div>
							<div class="col-xs-6 text-right">
								<p class="announcement-heading">${cliente.nome}</p>
								<p class="announcement-text">Profile</p>
							</div>
						</div>
					</div>
					<a href="perfil.jsp">
						<div class="panel-footer announcement-bottom">
							<div class="row">
								<div class="col-xs-6">Editar</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<i class="fa fa-barcode fa-5x"></i>
							</div>
							<div class="col-xs-6 text-right">
								<p class="announcement-heading">0</p>
								<p class="announcement-text">Descontos</p>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom">
							<div class="row">
								<div class="col-xs-6">Visualizar</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<i class="fa fa-cutlery fa-5x"></i>
							</div>
							<div class="col-xs-6 text-right">
								<p class="announcement-heading">18</p>
								<p class="announcement-text">Favoritos</p>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom">
							<div class="row">
								<div class="col-xs-6">Visualizar</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<i class="fa fa-comments fa-5x"></i>
							</div>
							<div class="col-xs-6 text-right">
								<p class="announcement-heading">52</p>
								<p class="announcement-text">Compras</p>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom">
							<div class="row">
								<div class="col-xs-6">Listar</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
		<!-- /.row -->
	</div>
</body>
</html>