<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Plataformas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Lista de Plataformas</h2>
        <a href="${pageContext.request.contextPath}/plataformas/novo" class="btn btn-primary mb-3">Nova Plataforma</a>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${plataformas}" var="plataforma">
                    <tr>
                        <td>${plataforma.id}</td>
                        <td>${plataforma.descricao}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/plataformas/editar/${plataforma.id}" class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/plataformas/excluir/${plataforma.id}" class="btn btn-sm btn-danger" onclick="return confirm('Tem certeza que deseja excluir esta plataforma?')">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 