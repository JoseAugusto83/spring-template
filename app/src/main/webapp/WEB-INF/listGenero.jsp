<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
    <div class="cotainer">
        <h1>Genero</h1>
        <a href="/insertGenero" class="btn btn-primary">Novo genero</a>
        <table class="table">
            <tr>
                <th>Genero</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="item" items="${generos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nome}</td>
                    <td>
                        <a href="/updateGenero?id=${item.id}" class="btn btn-warning">Editar</a>
                        <a href="/deleteGenero?id=${item.id}" class="btn btn-danger">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>