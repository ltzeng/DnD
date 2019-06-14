<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Select Your Adventure</title>
</head>
<body>
	<p>Pick your adventure</p>
	<select onChange="goToAdventure()" id="adventure">
		<option value=""></option>
		<c:forEach items="${adventures}" var="adv">
			<option value="${adv.adventureID}">${adv.adventureID}) ${adv.description}</option>
		</c:forEach>
	</select>
</body>
<script>
function goToAdventure(){
	var adventureID = $("#adventure").children("option:selected").val();
	if(adventureID!=""){
		window.location="CharacterSelect?adventureID="+adventureID;
	}
}
</script>
</html>