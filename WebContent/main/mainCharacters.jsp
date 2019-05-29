<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Your Adventurer</title>
</head>
<body>
	 <c:forEach var="pc" items="${charactersList}">
		 <table style="border:1px solid black;">
		 	<tr>
		 		<c:set var="imgUrl" value="${pc.adjective}-${pc.gender}-${pc.characterClass}" />
		 		<td rowspan=7><a href="CharacterDetails?charName=${pc.characterFileName}">
		 		<img src="image/${imgUrl}.png" alt="${imgUrl}" style="width:200px;height:300px;"></a></td>
		 	</tr>
		 	<tr>
		 		<td>${pc.characterName}</td>
		 	</tr>
		 	<tr>
		 		<td>Level : ${pc.level}</td>
		 	</tr>
		 	<tr>
		 		<td>Background : ${pc.background}</td>
		 	</tr>
		 	<tr>
		 		<td>Alignment: ${pc.alignment}</td>
		 	</tr>
		 	<tr>
		 		<td>Exp: ${pc.exp}</td>
		 	</tr>
		 	<tr>
		 		<td>HP: ${pc.hp}</td>
		 	</tr>
		 	<tr>
		 		<td align="center" colspan=2><b>STR:</b> ${pc.abilityScores.strMod }
		 		<b>DEX:</b> ${pc.abilityScores.dexMod }
		 		<b>CON:</b> ${pc.abilityScores.conMod }
		 		<b>INT:</b> ${pc.abilityScores.intelMod}
		 		<b>WIS:</b> ${pc.abilityScores.wisMod }
		 		<b>CHA:</b> ${pc.abilityScores.chaMod }</td>
		 	</tr>
		 </table>
	 </c:forEach>
	
</body>
</html>