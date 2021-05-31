# kmend
Instructions:
Clone the project from GitHub and either build a war file with maven and deploy it using Tomcat or any other servlet container 
or import it into an IDE and run it from there.
Once the webapp (war file) has been deployed, access the address: localhost:8080/technical-challenge. 


Technical details:

Java v15 (code compatibility: v1.8+)
Maven v3.5.3
Apache-tomcat v9.0.21

Frameworks:
SpringMVC v5.3.7
	Configuration: 
		- src/main/webapp/WEB-INF/web.xml
		- src/main/webapp/WEB-INF/spring-servlet.xml
		- src/main/webapp/WEB-INF/applicationContext.xml

Hibernate v5.4.32
	Configuration: 
		- src/main/webapp/WEB-INF/spring-servlet.xml

Database: H2database v1.4.200
	Data Load:
		- src/main/java/com/kmend/techchallenge/config/DataLoader.java

UI:
jQuery v3.5.1
Bootstrap v4.5.2
DataTables v1.10.24
Charts.js v3.3.1
JS Scripts:
	- src/main/webapp/resources/js/kmend-script.js
	- src/main/webapp/resources/js/kmend-util.js
