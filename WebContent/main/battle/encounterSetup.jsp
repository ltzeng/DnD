<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Create Encounter</title>
</head>
<body>

<form action="Encounter">
	<div>
	<table style="float: left" border=1>
	<thead>
		<tr>
			<th>Name</th>
			<th>Initiative</th>			
		</tr>
	</thead>
	<c:forEach var="pc" items="${pcList}">
	
	<tr>
		<td>${pc.characterName}</td>
		<td><input type="text" name="player_initiative_${pc.characterID}"></td>
		
	</tr>
	</c:forEach>
	</table>
	<table style="float: left" id="monsterTable">
		<tbody></tbody>
	</table>
	</div>
	<table>
		<tr>
			<td>Add Enemy</td>
			
			<td><select id="monsters" name="monsters">
				<option value=""></option>
				<c:forEach items="${monList}" var="mon">
					<option value="${mon.monster_id}">${mon.name}</option>
				</c:forEach>
			</select></td>
			<td><button onclick="addMonsterToList()" type="button">add</button></td>
		</tr>
	</table>
</form>

</body>
<script>
function addMonsterToList(characterID){
	var monID = $("#monsters").val();
	var monName = $("#monsters").text();
	$('#monsterTable > tbody:last-child').append('<tr><td>'+monName+'</td></tr>');
}
</script>
</html>