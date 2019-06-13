<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="main/css/battle-styles.css">
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
		<td class="initiative_${pc.encounterDetails.initiative.initiative }"><a href="CharacterDetails?characterID=${pc.characterID}">${pc.characterName}</a></td>
		<td><input size="3" type="text" id="${pc.characterID}_hp" value="${pc.hp}"> / ${pc.maxHp }</td>
		<td>${pc.armorClass}</td>
		
		
		<td><button onclick="updatePlayer(${pc.characterID})" type="button">Update</button></td>
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
	<c:forEach var="monster" items="${monsterList}">
		<table border=1>
			<tr>
				<td class="enemy_${monster.typeColor }"></td>
				<td class="initiative_${monster.initiative.initiative }" id="${monster.encounterMonsterID }_name">${monster.name }</td>
				<td>${monster.initiative.initiative }</td>
				<td>HP: <input size="4" type="text" id="${monster.encounterMonsterID }_hp" value="${monster.hp }"> / ${monster.maxHP }</td>
				<td>Status: <input size="4" type="text" id="${monster.encounterMonsterID }_status" value="${monster.status }"></td>
				<td><button type="button" onclick="updateEnemyHP(${monster.encounterMonsterID })">Update</button>
			</tr>
			<tr>
				<td colspan="2">armor class: ${monster.armorClass}</td>
				<td>speed: ${monster.speed}</td>
			</tr>
			<tr>
				<td colspan="2">skills: ${monster.skills }</td>
				<td colspan="2">damage immunities: ${monster.damageImmunities }</td>
				<td colspan="2">senses: ${monster.senses }</td>
				<td colspan="1">languages: ${monster.languages }</td>
				<td>challenge: ${monster.challenge }</td>
			</tr>
			<tr>
				<c:forEach var="mSkills" items="${monster.monsterSkills}">
					<td>${mSkills.skillName }</td><td colspan="2">${mSkills.skillDescription }</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="mAction" items="${monster.monsterActions}">
					<td>${mAction.actionName }</td><td colspan="2">${mAction.actionDescription }</td><td>${mAction.type }</td>
				</c:forEach>
			</tr>
		</table>			
	</c:forEach>
	
</body>
<script>
function updatePlayer(characterID){
	var id = characterID;
	var hp = $("#"+id+"_hp").val();
	var encounterID = ${encounter.encounterID};
	console.log(":" + encounterID + ":");
	if(encounterID ===null  || encounterID===""){
		encounterID = 0;
	}
	$.ajax({
		url: "BattleTrackerAPI",
        type: 'GET',
        data: { 
            characterID: id, 
            action: 'updatePlayerHP',
            hp: hp,
            encounterID: encounterID
          },
          'success' : function(data) {              
        	  window.location.reload(1);
          },
    })
}

function updateEnemyHP(monsterID){
	var id = monsterID;
	var hp = $("#"+id+"_hp").val();
	var encounterID = ${encounter.encounterID};
	$.ajax({
		url: "BattleTrackerAPI",
        type: 'GET',
        data: { 
        	monsterID: id, 
            action: 'updateMonsterHP',
            hp: hp,
            encounterID: encounterID
          },
          'success' : function(data) {              
        	  window.location.reload(1);
          },
    })
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
	$.get( "BattleTrackerDmAPI",{action:'updateHP', encounterID:'${encounter.encounterID}',adventureID:'${adventureID}', encounterMonsterID:hp}, function( data ) {
		console.log(data);
	});
}

</script>


<c:forEach var="monster" items="${monsterList}">
	<c:if test="${monster.hp eq 0}">
		<script>
			$("#" + ${monster.encounterMonsterID} +"_name").css("textDecoration","line-through");
		</script>
	</c:if>
</c:forEach>
<c:if test="${not empty encounter }">
<script>
var turn = ${initiativesList[encounter.turn-1]};
var highlightElement = ".initiative_" + turn;
$(highlightElement).addClass("highlight");
</script>
</c:if>

</html>