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

<form action="EncounterSetup">
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
			<td><input maxlength="3" size="4" type="text" name="initiative_player-${pc.characterID}"></td>
		</tr>
	</c:forEach>
	</table>
	<table style="float: left" id="monsterTable">
		<tbody></tbody>
	</table>
	</div>
	<table id="addingTable">
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
		<tr>
			<td>
				<input type="submit" value="submit"/>
			</td>
		</tr>
	</table>
	<input type="hidden" name="action" value="create">
	<input type="submit" value="submit"/>
</form>

</body>
<script>
var count=0;
function addMonsterToList(characterID){
	var monID = $("#monsters").children("option:selected").val();
	var monName = $("#monsters").children("option:selected").text().trim();

	var colorOptions = "<option value='blue'>blue</option><option value='red'>red</option><option value='green'>green</option><option value='purple'>purple</option>";
	var colorDropDown = "<td><select id='color_monster-"+monID+"-"+count+"' name='color_monster-"+monID+"-"+count+"'>"+colorOptions+"</select></td>";
	var appendField = "<tr><td>"+monName+"</td><td><input type='text' name='initiative_monster-"+monID+"'></td>"+colorDropDown+"</tr>";
	$('#monsterTable > tbody:last-child').append(appendField);
}
</script>
<style>

table#addingTable{
	clear: left;
	position: absolute;
	top: 200px;
} 
</style>
</html>