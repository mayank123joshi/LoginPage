<html>
<head>
	<title>Login Page Web App</title>
	<link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<div id="header">
		<H2>
			<img src="resources/img/logo.png" height="37" width="236" border="0px" src="" align="left"/></a> Login Page Sample
		</H2>
	</div>
	
	<div id="content">
	  <fieldset>
	  	<legend>Please Login</legend>
  		<form name="login" action="/LoginPage/success.html" method="post">
   			UserName: <input type="text" name="username" id:"username" />	<br/>
  			Password: <input type="password" name="password" id:"password" />	<br/>
  			<input type="submit" value="  Login  " />
  		</form>
  		<#if error??>
			<p class="login_error">${error}</p>
	  </#if>
	  </fieldset>
	</div>  
</body>
</html>