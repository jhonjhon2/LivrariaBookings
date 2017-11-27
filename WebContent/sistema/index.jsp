<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>loveFood | Área administrativa</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
	<header>
		<figure>
			<img class="logo" alt="loveFood | Restaurantes Delivery"
				src="resources/img/logo.png" width="380">
		</figure>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="pr-wrap">
					<div class="pass-reset">
						<label> Informe o email para recuperar a senha</label> <input
							type="email" placeholder="Email" />
						<button type="submit"
							class="pass-reset-submit btn btn-success btn-block">Recuperar</button>
					</div>
				</div>
				<div class="wrap"> <!-- not equals(ne) | equals(eq) -->
					<c:if test="${msg ne null}">
						<p class="form-title" style="color: red">${msg}</p>
					</c:if>
					<p class="form-title">Entrar</p>
					<form id="formLogin" class="login" action="login" method="post">
						<div>
							<div>
								<label for="idLogin"></label>
								<input type="text" id="idLogin" name="txtLogin" placeholder="Login" />
							</div>
							<div>
								<label for="idSenha"></label>
								<input type="password" id="idSenha" name="txtSenha" placeholder="Senha" />
							</div>
						</div>
						<button type="submit" class="btn btn-success btn-block">Sign
							In</button>

						<div class="remember-forgot">
							<div class="row">
								<div class="col-md-6">
									<div class="checkbox">
										<label> <input value="1" type="checkbox" />
											Lembrar-se
										</label>
									</div>
								</div>
								<div class="col-md-6 forgot-pass-content">
									<a href="javascription:void(0)" class="forgot-pass">Esqueceu
										a senha</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="allright">
				Todos os direitos reservados: <a href="http://bit.ly/2AcS05e">Turma
					2016.5</a>
			</div>
		</div>
	</div>

	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

	<script src="resources/js/login.js"></script>
</body>
</html>