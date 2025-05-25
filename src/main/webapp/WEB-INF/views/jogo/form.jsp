<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${jogo.id == null ? 'Novo Jogo' : 'Editar Jogo'}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>${jogo.id == null ? 'Novo Jogo' : 'Editar Jogo'}</h2>
        
        <form action="${pageContext.request.contextPath}/jogos/salvar" method="post">
            <input type="hidden" name="id" value="${jogo.id}">
            
            <div class="mb-3">
                <label for="titulo" class="form-label">Título</label>
                <input type="text" class="form-control" id="titulo" name="titulo" value="${jogo.titulo}" required>
            </div>
            
            <div class="mb-3">
                <label class="form-label">Gêneros</label>
                <div class="row">
                    <c:forEach items="${generos}" var="genero">
                        <div class="col-md-4">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="generos" value="${genero.id}"
                                    id="genero${genero.id}" ${jogo.generos.contains(genero) ? 'checked' : ''}>
                                <label class="form-check-label" for="genero${genero.id}">
                                    ${genero.nome}
                                </label>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            <div class="mb-3">
                <label class="form-label">Plataformas</label>
                <div class="row">
                    <c:forEach items="${plataformas}" var="plataforma">
                        <div class="col-md-4">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="plataformas" value="${plataforma.id}"
                                    id="plataforma${plataforma.id}" ${jogo.plataformas.contains(plataforma) ? 'checked' : ''}>
                                <label class="form-check-label" for="plataforma${plataforma.id}">
                                    ${plataforma.descricao}
                                </label>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            <div class="mb-3">
                <label for="modoJogo" class="form-label">Modo de Jogo</label>
                <select class="form-select" id="modoJogo" name="modoJogo.id" required>
                    <option value="">Selecione um modo de jogo</option>
                    <c:forEach items="${modosJogo}" var="modo">
                        <option value="${modo.id}" ${jogo.modoJogo.id == modo.id ? 'selected' : ''}>
                            ${modo.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="${pageContext.request.contextPath}/jogos" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 