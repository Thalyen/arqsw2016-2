<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%
    Projeto projeto = (Projeto) session.getAttribute("projeto");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto</title>
    </head>

    <body>
        <h1>Visão Geral de Projeto <c:out value="${projeto.titulo}" /></h1>

        <h3>Descrição</h3>

        <p><c:out value="${projeto.descricao}" /></p>

        <h2>Notícias</h2>

        <c:forEach var="noticia" items="${projeto.noticias}" varStatus="id">
            <h3>${noticia.titulo}</h3>
            <p>${noticia.descricao}</p>
            <p>${noticia.data}</p>
        </c:forEach>

        <h2>Metas</h2>

        <c:forEach var="meta" items="${projeto.metas}" varStatus="id">

            <h3>${meta.titulo}</h3>
            <%--<td>${meta.dataInicio}</td>
            <td>${meta.dataInicio}</td>--%>

            <h3>Atividades</h3>

            <c:forEach var="atividade" items="${meta.atividades}" varStatus="status" >
                <h4>${atividade.titulo}</h4>
                <p>${atividade.descricao}</p>
                <p>${atividade.dataInicio}</p>
                <p>${atividade.dataInicio}</p>

            </c:forEach>
        </c:forEach>


        <h2>Equipe</h2>
        <c:forEach var="equipe" items="${projeto.equipe}" varStatus="id">
            <p>${equipe.nome}</p>
        </c:forEach>

    </body>
</html>
<!--http://localhost:8080/SisNPIFRN/projeto?idProjeto=1-->