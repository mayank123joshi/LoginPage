<#import "/spring.ftl" as spring/>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>Login Page Web App</title>
	<link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
	<!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="header clearfix">
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li role="presentation" class="active"><a href="?lang=en_US">English</a></li>
	            <li role="presentation"><a href="?lang=de_DE">German</a></li>
	          </ul>
	        </nav>
	        <h3 class="text-muted"><@spring.message "label.pageheading"/></h3>
      	</div>
      	<form class="form-signin" action="/LoginPage/success.html" method="post">
        	<h2 class="form-signin-heading"><@spring.message "label.sectionheading"/></h2>
			<#if error??>
				<p class="login_error"><@spring.message "label.errormsg"/></p>
	  		</#if>
        	<label for="inputEmail" class="sr-only"><@spring.message "label.emailadd"/></label>
        	<input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder=<@spring.message "label.emailadd"/> required autofocus>
        	<label for="inputPassword" class="sr-only"><@spring.message "label.password"/></label>
        	<input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder=<@spring.message "label.password"/> required>
        	<div class="checkbox">
          		<label>
            	<input type="checkbox" value="remember-me"> <@spring.message "label.remember"/>
          		</label>
        	</div>
        	<button class="btn btn-lg btn-primary btn-block" type="submit"><@spring.message "label.submitButton"/></button>
      	</form>
		The current locale is: ${.locale} 
		<#include "*/footer.ftl">
	</div> <!-- /container -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src=”js/bootstrap.js”></script>
	 	
</body>
</html>