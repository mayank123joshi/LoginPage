# FreeMarkerApp : Basic Maven + Log4j + Spring MVC + CSS Web Project
ReadMe

1. Copy JDK Maven and Tomcat to expwebdevtools or clone it with git<br>
	I) Pulling the changes from git<br>
			a) Create a folder with RemoteName <br>
			b) git init <br>
			c) git remote add origin https://github.com/mayank123joshi/FreeMarkerApp.git<br>
			d) git pull origin HEAD <br>
	II) Pushing the changes forcefully into git <br>
			a) git init<br>
			b) git add src<br>
			c) git add README.md<br>
			d) git remote add origin https://github.com/mayank123joshi/FreeMarkerApp.git<br>
			e) git commit -m "first commit"<br>
			f) git push --force origin master<br>
			g) Enter username and password for the repository
	III) Commit the changes from git<br>
			a) git status -s<br>
			b) git commit -m "new changes"<br>
			c) git remote add origin https://github.com/mayank123joshi/FreeMarkerApp.git<br>
			d) git push -u origin master<br>
	IV) cloning a git repository<br>
			a) git clone https://github.com/mayank123joshi/FreeMarkerApp.git<br>
<br>
2. Create a web project <br>
     expwebdevtools/apache-maven-3.2.5/bin/mvn archetype:generate -DgroupId=com.trunk -DartifactId=CounterFreeMarkerApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false<br>
<br>
3. Project Directory Layout<br>
	.<br>
	|____FreeMarkerApp<br>
	| |____pom.xml<br>
	| |____src<br>
	| | |____main<br>
	| | | |____resources<br>
	| | | |____webapp<br>
	| | | | |____index.jsp<br>
	| | | | |____WEB-INF<br>
	| | | | | |____web.xml<br>
<br>
4. To compile, test and package the project into a WAR file<br>
       mvn clean package<br>
5. Maven plugin is declared you can use the below command for deployment assembly<br>
       mvn tomcat:run<br>