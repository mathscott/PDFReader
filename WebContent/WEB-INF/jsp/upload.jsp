<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PDF Reader</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <style>
        .upload-form{
            text-align: center;
        }
        .btn-upload{
            background-color: rgb(255, 92, 103);
            color: #fff;
        }
        .btn-upload:hover{
            background-color: rgb(216, 78, 87);
            transition-duration: .5s;
        }
        .pdf-title{
            color: rgb(85, 85, 85);
            opacity: 0.75;
            font-weight: 600;
        }
        .form-image{
            opacity: 0.6;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <form class="upload-form" method="POST" action="/showXmlFile" enctype="multipart/form-data">
        <h3 class="pdf-title">Escolha o arquivo .pdf aqui</h3>
        <input class="d-block mt-3" type="number" name="x" />
        <input class="d-block mt-3" type="number" name="y" />
        <input class="d-block mt-3" type="number" name="largura" />
        <input class="d-block mt-3" type="number" name="altura" />
        <input class="d-block mt-3" type="text" name="nomeRegiao" />
        <input  class="mt-3  btn-file " type="file" name="file">
        <input class="mt-3 btn btn-upload" type="submit" value="Upload">
    </form>


</div>
</body>
</html>