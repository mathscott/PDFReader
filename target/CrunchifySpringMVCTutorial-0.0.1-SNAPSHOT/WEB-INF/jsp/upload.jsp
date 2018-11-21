<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form action="adicionaConta" method="POST">
            <p><input type="text" name="texto" /></p>
            <p>
            
            </p>
        </form>
        
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
		<input type="file" name="file"><br />
		<input type="submit" value="Upload">
	</form>	
    </body>
</html>