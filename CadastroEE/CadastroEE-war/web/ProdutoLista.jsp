<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h1 class="mt-4 mb-4">Lista de Produtos</h1>
    <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary mb-3">Novo Produto</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr><th>ID</th><th>Nome</th><th>Qtd</th><th>Preço</th><th>Ações</th></tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="p">
                <tr>
                    <td>${p.idProduto}</td>
                    <td>${p.nome}</td>
                    <td>${p.quantidade}</td>
                    <td>${p.precoVenda}</td>
                    <td>
                        <a href="ServletProdutoFC?acao=formAlterar&id=${p.idProduto}" class="btn btn-warning btn-sm">Alterar</a>
                        <a href="ServletProdutoFC?acao=excluir&id=${p.idProduto}" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>