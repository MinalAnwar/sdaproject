<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>Hotel Dashboard Template</title>
	<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" type="text/css" href="assets/plugins/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="assets/css/feathericon.min.css">
	<link rel="stylesheet" href="assets/plugins/morris/morris.css">
	<link rel="stylesheet" href="assets/css/style.css"> </head>

<body>
	<div class="main-wrapper login-body">
		<div class="login-wrapper">
			<div class="container">
				<div class="loginbox">
					<div class="login-left">
						<b><a style="color: white; font-size: x-large;">Enterprise Resourse Planner</a></b>
						<p style="color: white;">A place to manage your whole Enterprise</p>
					</div>
					<div class="login-right">
						<div class="login-right-wrap">
							<h1>Signup</h1>
							<p class="account-subtitle">Create a New Account</p>
							<form method="post" action="signUp">
								<div class="form-group">
									<input class="form-control" name="username" type="text" placeholder="userName"> </div>
								<div class="form-group">
									<input class="form-control" name="password" type="password" placeholder="Password"> </div>
                                <div class="form-group">
                                    <input class="form-control" name="confirmPassword" type="password" placeholder="Confirm Password"> </div>
								<div class="form-group">
									<button class="btn btn-primary btn-block" type="submit">Signup</button>
									<%
										Boolean isValid = (Boolean) request.getAttribute("valid");
										if (isValid != null && !isValid) {
									%>
								</div>
								<div style="color: red;">Password Not Same</div>
									<%
							}
						%>
								</div>
							</form>
							<div class="login-or"> <span class="or-line"></span> <span class="span-or">or</span> </div>
							<div class="social-login"> <span>Signup with</span> <a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a><a href="#" class="google"><i class="fab fa-google"></i></a> </div>

						<div class="text-center dont-have">Have an account? <a href="index.jsp"
																				  style="color: red;">Login</a></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/js/script.js"></script>
</body>

</html>
