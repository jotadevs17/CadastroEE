<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
    <h1 class="mt-4">Dados do Produto</h1>
    <form action="ServletProdutoFC" method="POST" class="mt-3">
        <input type="hidden" name="acao" value="${produto == null ? 'incluir' : 'alterar'}">
        <c:if test="${produto != null}"><input type="hidden" name="id" value="${produto.idProduto}"></c:if>

        <div class="mb-3">
            <label class="form-label">Nome</label>
            <input type="text" name="nome" value="${produto.nome}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Quantidade</label>
            <input type="number" name="quantidade" value="${produto.quantidade}" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Preço</label>
            <input type="text" name="preco" value="${produto.precoVenda}" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
        <a href="ServletProdutoFC?acao=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</body>
</html>