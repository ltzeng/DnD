<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dungeon Master Info Screen</title>
</head>
<body>

<table border=1>
	<thead>
		<tr>
			<th>Name</th>
			<th>HP</th>
			<th>Armor Class</th>
			
			
			<th>Edit</th>
		</tr>
	</thead>
<c:forEach var="pc" items="${pcList}">
	
	<tr>
		<td>${pc.characterName}</td>
		<td>${pc.hp}</td>
		<td>${pc.armorClass}</td>
		
		
		<td><button onclick="navToEdit(${pc.characterID})" type="button">Edit</button></td>
	</tr>
</c:forEach>
</table>

<table border=1>
	<tr>
		<td><button onclick="startEncounter(${adventureID})" type="button">Edit</button></td>
	</tr>
	<tr>
		<td><button onclick="startEncounter()" type="button">Start Encounter</button></td>
	</tr>
	<tr>
		<td><button onclick="endEncounter()" type="button">End Encounter</button></td>
	</tr>
</table>
</body>
<script>
function navToEdit(characterID){
	window.location="EditCharacter?characterID="+characterID;
}
function startEncounter(){
	window.location="EncounterSetup?adventureID="+${adventureID};
}
function endEncounter(){
	$.get( "BattleTrackerDmAPI",{action:'endEncounter', encounterID:'${encounter.encounterID}',adventureID:'${adventureID}'}, function( data ) {
		console.log(data);
	});
}
</script>
</html>