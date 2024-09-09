<%-- 
    Document   : studentInfo
    Created on : 7/09/2024, 05:46:24 PM
    Author     : JUAN  CARLOS RIOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PROJECTS INFO</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>PROJECTS INFO</h1>
<form action="./ProyectosServlet" method="POST">
<table>
<tr>
<td>PROYECTOID</td>
<td><input type="text" name="PROYECTOID" value="${Proyectos.PROYECTOID}" /></td>
</tr>
<tr>
<td>NOMBRE</td>
<td><input type="text" name="NOMBRE" value="${Proyectos.NOMBRE}" /></td>
</tr>
<tr>
<td>DESCRIPCION</td>
<td><input type="text" name="DESCRIPCION" value="${Proyectos.DESCRIPCION}" /></td>
</tr>
<tr>
<td>LOCALIDAD</td>
<td><input type="text" name="LOCALIDAD" value="${Proyectos.LOCALIDAD}" /></td>
</tr>
<tr>
<td>PRESUPUESTO</td>
<td><input type="text" name="PRESUPUESTO" value="${Proyectos.PRESUPUESTO}" /></td>
</tr>
<tr>
<td>NUMERO HABITANTES</td>
<td><input type="text" name="NUMERO_HABITANTES" value="${Proyectos.NUMERO_HABITANTES}" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="action" value="Add" />
<input type="submit" name="action" value="Edit" />
<input type="submit" name="action" value="Delete" />
<input type="submit" name="action" value="Search" />
<input type="submit" name="action" value="See Table" />
</td>
</tr>
</table>
</form>
<br>
<table border="1">
<th>ID PROYECTO</th>
<th>NOMBRE DEL PROYECTO</th>
<th>DESCRIPCION</th>
<th>LOCALIDAD</th>
<th>PRESUPUESTO</th>
<th>NUMERO DE HABITANTES</th>
<c:forEach items="${allProyectos}" var="proyectos">
<tr>
<td>${proyectos.proyectoid}</td>
<td>${proyectos.nombre}</td>
<td>${proyectos.descripcion}</td>
<td>${proyectos.localidad}</td>
<td>${proyectos.presupuesto}</td>
<td>${proyectos.numeroHabitantes}</td>
</tr>
</c:forEach> 
</table>
</body>
</html>
