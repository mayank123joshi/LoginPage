<#import "/spring.ftl" as spring/>

<html>
<head>
	<title>Login Page Web App</title>
	<link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<span style="float: right">
	    <a href="?lang=en_US">en</a> 
	    | 
	    <a href="?lang=de_DE">de</a>
	</span>
	<div id="header">
		<H2>
			<img src="resources/img/logo.png" height="37" width="236" border="0px" src="" align="left"/></a> Login Page Sample
		</H2>
	</div>
	
	<div id="content">
	  <fieldset>
	  	<legend>Please Login</legend>
  		<form name="login" action="/LoginPage/success.html" method="post">
  			<#if error??>
				<p class="login_error">${error}</p>
	  		</#if>
   			UserName: <input type="text" name="username" id:"username" />	<br/>
  			Password: <input type="password" name="password" id:"password" />	<br/>
  			<input type="submit" value="  Login  " />
  		</form>
	  </fieldset>
	</div>
	<@spring.message "label.username"/>
	The current locale is: ${.locale}  
</body>
</html>