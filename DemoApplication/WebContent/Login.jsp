<html>
<title>LoginPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script>
    $(document).ready(function () {
        $("#login").click(function () {

            var uname= $("#uname").val();
            var pwd=$("#pwd").val();
            if(uname=="" && pwd=="")
            {
                alert("Please Provide UserName and Password");
                return false;
            }
            if(uname=="")
            {
                alert("Please provide username");
                return false;
            }
            if(pwd=="")
            {
                alert("Please provide password");
                return false;
            }
            $.ajax({
			  type: "POST",
			  url: "login",
			  data:{uname:uname,pwd:pwd},
			  success: function(data){
				  if(data=="success")
				   {
					  document.location='Success.jsp';
				   }
				  else
				   {
					  document.location='Login.jsp'
					  
					}
			  },
            });

        });
    });
</script>

<body>
	<div class="container">
		<h1 class="text-center mt-5">Login</h1>
		<div class="container pt-3">
			<div class="row justify-content-sm-center">
				<div class="col-sm-10 col-md-6">
					<div class="card border-info">
						<div class="card-header">Sign in to continue</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-12">
									<form class="form-signin">
										<input type="text" class="form-control mb-2"
											placeholder="Email" id="uname"> <input
											type="password" class="form-control mb-2"
											placeholder="Password" id="pwd">
										<button class="btn btn-lg btn-primary btn-block mb-1"
											type="button" id="login">Sign in</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<a href="#" class="float-right" style="color: aliceblue">Create
						an account </a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>