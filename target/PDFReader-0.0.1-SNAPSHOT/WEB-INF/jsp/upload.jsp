<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>PDF Reader</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <h3 class="text-center">Bem-vindo, selecione o arquivo desejado!</h3>
    <hr class="my-3">

    <form method="POST" action="uploadFile" enctype="multipart/form-data">
        <input class="d-block mt-3" type="text" name="texto" />
        <input  class="d-block mt-3" type="file" name="file">
        <input class="d-block mt-3"type="submit" value="Upload">
    </form>

</div>
</body>

Message Input

Message Matheus Aprigio
</html>