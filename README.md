# jsfPrimefaces
This project is a basic example of how to implement a JSF application that communicate with a mySQL database.
We used:
- Java 8 (1.8.0_241)
- JSF 2.2 (2.2.16)
- PrimeFaces 6.2
- Spring Framework 5.2.4
- Maven 3.8
- Connector/J 8.0.19 

Program's logic is simple: it receives a string in input that will be used for a search by name on the local database.
Values in return are stored in a list that will be shown in a second page after the occurrences counting.
This application uses JSF ManagedBean annotation and classic Spring Context annotations for classes and properties binding, a mySQL connection defined in context.xml file defined in the local instance Tomcat 8 (see below), Facelets files for the frontend with PrimeFaces components and Maven for the project (and dependencies) management.

It's fully replicable in your environment with a quick configuration of your tomcat resource:
```
<Resource name="jdbc/{schemaName}" auth="Container"
		type="javax.sql.DataSource" driverClassName="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:{port}/{schemaName}?serverTimezone=UTC" maxTotal="15"
		username="{dbUserame}" password="{dbPassword}" maxIdle="3" />
```
It works, but suggestions are very appreciated.

For infos, help and suggestions email-us at: dario20m@gmail.com or simone.l1996@hotmail.it

Hope we've helped you.
