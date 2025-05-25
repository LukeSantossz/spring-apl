<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Jogos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Lista de Jogos</h2>
        <a href="${pageContext.request.contextPath}/jogos/novo" class="btn btn-primary mb-3">Novo Jogo</a>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Gêneros</th>
                    <th>Plataformas</th>
                    <th>Modo de Jogo</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${jogos}" var="jogo">
                    <tr>
                        <td>${jogo.id}</td>
                        <td>${jogo.titulo}</td>
                        <td>
                            <c:forEach items="${jogo.generos}" var="genero" varStatus="status">
                                ${genero.nome}${!status.last ? ', ' : ''}
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${jogo.plataformas}" var="plataforma" varStatus="status">
                                ${plataforma.descricao}${!status.last ? ', ' : ''}
                            </c:forEach>
                        </td>
                        <td>${jogo.modoJogo.descricao}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/jogos/editar/${jogo.id}" class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/jogos/excluir/${jogo.id}" class="btn btn-sm btn-danger" onclick="return confirm('Tem certeza que deseja excluir este jogo?')">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 