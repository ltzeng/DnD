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
		<td><button onclick="startEncounter()" type="button">Start Encounter</button></td>
	</tr>
	<tr>
		<td><button onclick="endEncounter()" type="button">End Encounter</button></td>
	</tr>
	<tr>
		<td><button onclick="nextTurn()" type="button">Next Turn</button></td>
	</tr>
</table>
<c:if test="${not empty encounter} ">
	
		<c:forEach var="monster" items="${monsterList}">
			<table border=1>
				<tr>
					<td class="enemy_${monster.typeColor }">${monster.name }</td>
					<td>${monster.initiative.initiative }</td>
					<td><input size="4" type="text" id="${monster.encounterMonsterID }_hp" value="${monster.hp }"> / ${monster.maxHP }</td>
					<td><input size="4" type="text" id="${monster.encounterMonsterID }_status" value="${monster.status }">
				</tr>
				<tr>
					<td>armor class: ${monster.armorClass}</td>
					<td>speed: ${monster.speed}</td>
				</tr>
				</tr>
					<td>skills: ${monster.skills }</td>
					<td>damage immunities: ${monster.damageImmunities }</td>
					<td>senses: ${monster.senses }</td>
					<td>languages: ${monster.languages }</td>
					<td>challenge: ${monster.challenge }</td>
				</tr>
				<tr>
					<c:forEach var="mSkills" items="${monster.monsterSkills}">
						<td>${mSkills.skillName }</td><td>${mSkills.skillDescription }</td>
					</c:forEach>
				</tr>
				<tr>
					<c:forEach var="mAction" items="${monster.monsterActions}">
						<td>${mAction.actionName }</td><td>${mAction.actionDescription }</td><td>${mAction.type }</td>
					</c:forEach>
				</tr>
			</table>			
		</c:forEach>
	
</c:if>
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
function nextTurn(){
	$.get( "BattleTrackerDmAPI",{action:'nextTurn', encounterID:'${encounter.encounterID}',adventureID:'${adventureID}'}, function( data ) {
		console.log(data);
	});
}
function updateMonsterHP(encounterMonsterID, hp){
	$.get( "BattleTrackerDmAPI",{action:'updateHP', encounterID:'${encounter.encounterID}',adventureID:'${adventureID}'}, encounterMonsterID:hp, function( data ) {
		console.log(data);
	});
}

</script>
<style>
.enemy_blue {
  background-color: #0b61d0;
}
.enemy_red {
  background-color: #c3011a;
}
.enemy_purple {
  background-color: #7d00af;
}
.enemy_green {
  background-color: #169c07;
}
.enemy_grey {
  background-color: #9c9b97;
}
</style>
</html>