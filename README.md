Resource aggiunta in server/context.xml

<Context>
...
	<Resource name = "jdbc/mariosdb" auth = "Container"
		  type = "javax.sql.DataSource" username = "root"
		  password = "root" driverClassName = "com.mysql.cj.jdbc.Driver"
		  url = "jdbc:mysql://localhost:3306/mariosdb)servertimezone= UTC" />
...
</Context>
