<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Visão Geral de Projeto <%= projeto.getTitulo() %></h1>
        <h3>Descrição</h3>
        <p><%= projeto.getDescricao() %></p>
    </body>
</html>
