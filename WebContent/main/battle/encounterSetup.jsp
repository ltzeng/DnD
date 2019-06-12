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
		<tr>
			<td>description</td>
			<td>
				<textarea rows="4" cols="30" name="description"></textarea>
			</td>
		</tr>
	</table>
	<table border=2 style="float: left" id="monsterTable">
		<tbody></tbody>
	</table>
	</div>
	<table id="addingTable">
		<tr>
			<td>Add Enemy</td>
			<td><select id="monsters" name="monsters">
				<option value=""></option>
				<c:forEach items="${monList}" var="mon">
					<option value="${mon.monsterID}">${mon.name} - ${mon.hitPoints }</option>
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
	<input type="hidden" name="adventureID" value="${adventureID }">
</form>

</body>
<script>
var count=0;
function addMonsterToList(characterID){
	var monID = $("#monsters").children("option:selected").val();
	var monName = $("#monsters").children("option:selected").text().trim();

	var colorOptions = "<option value='blue'>blue</option><option value='red'>red</option><option value='green'>green</option><option value='purple'>purple</option>";
	var colorDropDown = "<td>color: <select id='color_monster-"+monID+"-"+count+"' name='monster_color_"+count+"'>"+colorOptions+"</select></td>";
	var hpField = "<td>hp: <input type='text' size='3' name='monster_hp_"+count+"'</td>"
	var appendField = "<tr><td>"+monName+"</td><td>initiative: <input type='text' size='3' name='initiative_monster-"+monID+"-"+count+"'></td>"+hpField+colorDropDown+"</tr>";
	$('#monsterTable > tbody:last-child').append(appendField);
	count++;
}
</script>
<style>

table#addingTable{
	clear: left;
	position: absolute;
	top: 300px;
} 
</style>
</html>