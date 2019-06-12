<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="main/css/battle-styles.css">
</head>



<body background="image/backgrounds/paper-bg.jpg">
<!-- body background="paper-bg.jpg"-->

<div id="battleTracker">
	<table class="cinereousTable">
		<thead>
			<tr>
				<c:forEach var="pc" items="${pcList}">
					<th id="name_${pc.encounterDetails.initiative.initiative }" class="ally">${pc.characterName }</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="pc" items="${pcList}">
					<td id="initiative_${pc.encounterDetails.initiative.initiative }">
					<table class="player">
						<tbody>
						<tr>
							<td><div class="status" id="actor_${pc.encounterDetails.initiative.initiative}_status"></div>
							<img src='image/character/${pc.avatarPicture}-mobile.png' />
							<div class="spellSlotDiv">${pc.spellSlots.availableSpellSlots}</div>
							</td>
							
						</tr>
						</tbody>
					</table>
					</td>
				</c:forEach>
			</tr>
		</tbody>
		<tfoot>
				<tr>
					<c:forEach var="pc" items="${pcList}">
						<c:if test="${pc.hp eq 0 }">
							<td align="left">Death Success: ${pc.encounterDetails.deathSuccess }</td>
						</c:if>
					</c:forEach>		
				</tr>
				<tr>
					<c:forEach var="pc" items="${pcList}">
						<c:if test="${pc.hp eq 0 }">
							<td align="left">Death Failure: ${pc.encounterDetails.deathFailure }</td>
						</c:if>
					</c:forEach>		
				</tr>
		</tfoot>
	</table>
</div>
	<c:if test="${encounterLive eq true }">
		<table class="cinereousTable2">
		<thead>
			<tr>
				<c:forEach var="mon" items="${monsterList}">
					<th class="enemy">${mon.name }</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="mon" items="${monsterList}">
					<td id="initiative_${mon.initiative.initiative }"><img class="enemy_img" src="image/monster/${mon.name }.png"></td>
				</c:forEach>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<c:forEach var="mon" items="${monsterList}">
					<td class="enemy_${mon.typeColor }"></td>
				</c:forEach>
			</tr>
		</tfoot>
		</table>
		
		<table class="turns">
		<tr>
			<td>${encounter.turn }</td>
		</tr>
		<tr>
			<td>Turn</td>
			<td>${encounter.overallTurn }</td>
		</tr>
		</table>
	</c:if>	
	
	

</body>
<style>

</style>
<button onclick="addSkull('1')">add skull</button>

<c:if test="${not empty encounter }">
	<script>
	var turn = ${initiativesList[encounter.turn-1]};
	var highlightElement = "#initiative_" + turn;
	$(highlightElement).addClass("highlight");
	</script>
</c:if>

<script>

 setInterval(function(){
	 $.get( "BattleTrackerAPI",{action:'updateCheck', adventureID:'${adventureID}'}, function( data ) {
		  if(data=='true'){
			  acknowledgeUpdate();
			  window.location.reload(1);
		  }
		});
    
 }, 5000);
 
function acknowledgeUpdate(){
	$.get( "BattleTrackerAPI",{action:'ackEncounterUpdate', encounterID:'${encounter.encounterID}',adventureID:'${adventureID}', updateStatus:'false'}, function( data ) {
		console.log(data);
	});
}


function addSkull(player_id){
	player_id = player_id + "_status";
	$("#actor_"+player_id).prepend('<img class="status-img" src="image/status/skull.png"/>');
}

</script>

<c:forEach var="pc" items="${pcList}">
	<c:if test="${pc.hp eq 0 }">
		<script>
			var turn = ${pc.encounterDetails.initiative.initiative};
			var highlightElement = "#initiative_" + turn;
			//$(highlightElement).addClass("highlightDark");
			
			var deathIconElement = "#actor_"+turn+"_status"
			$(deathIconElement).prepend('<img class="status-img" src="image/status/skull.png"/>');
		</script>
	</c:if>
</c:forEach>
</html>