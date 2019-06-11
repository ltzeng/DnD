<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- <link rel="stylesheet" href="main/css/battle-styles.css"> -->
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
							<td><div class="status" id="actor_1_status"></div>
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

div.spellSlotDiv{
	text-align: left;
}
div.status{
	height: 25px;
}
.enemy_img {
      width:auto; 
      height:200px;
      text-align: center;
}

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

table.cinereousTable .player tbody td {
  border: none;

  text-align: center;
}

.player img {
	max-height: 80%;
	max-width: 80%;
}
table.cinereousTable2 {
  border: 6px solid #948473;
  background-color: #FFE3C6;
  text-align: center;
  margin-left:auto; 
  margin-right:auto;
}
table.cinereousTable2 td, table.cinereousTable th {
  border: 1px solid #948473;
  padding: 4px 4px;
}
table.cinereousTable2 td, table.cinereousTable th {
  border: 1px solid #948473;
  padding: 4px 4px;
}
table.cinereousTable2 thead {
  background: #948473;
  background: -moz-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: -webkit-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: linear-gradient(to bottom, #afa396 0%, #9e9081 66%, #948473 100%);
}
table.cinereousTable2 thead th {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  border-left: 2px solid #948473;
}
table.cinereousTable {
  border: 6px solid #948473;
  background-color: #FFE3C6;
  width: 100%;
  text-align: center;
  table-layout: fixed;
}

td.highlight {
	background-color: #fbffc6;
}
td.highlightDark {
	background-color: #86531f;
}
table.cinereousTable td, table.cinereousTable th {
  border: 1px solid #948473;
  padding: 4px 4px;
}
table.cinereousTable tbody td {
  font-size: 15px;
  color: #123622;
  height: 150px;
  vertical-align: top;
}
table.cinereousTable thead {
  background: #948473;
  background: -moz-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: -webkit-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: linear-gradient(to bottom, #afa396 0%, #9e9081 66%, #948473 100%);
}
table.cinereousTable thead th {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  border-left: 2px solid #948473;
}

th.enemy {
	color: #800000;
}

th.ally {
	color: #000000;
}

table.cinereousTable thead th:first-child {
  border-left: none;
}

table.cinereousTable tfoot {
  font-size: 16px;
  font-weight: bold;
  color: #F0F0F0;
  background: #948473;
  background: -moz-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: -webkit-linear-gradient(top, #afa396 0%, #9e9081 66%, #948473 100%);
  background: linear-gradient(to bottom, #afa396 0%, #9e9081 66%, #948473 100%);
}
table.cinereousTable tfoot td {
  font-size: 10px;
}

div {
	width: 90%;
	margin: auto;
}

.content-top{
    position: relative;
    top: 0px;
}
.death img{
	position: relative;
	top: 0;
	left: 0;
}


</style>
<button onclick="addSkull('1')">add skull</button>
<button onclick="addImage()">add X</button>

<c:if test="${not empty encounter }">
	<script>
	var turn = ${initiativesList[encounter.turn]};
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
function addImage(){
	
	$("#initiative_7").addClass("highlightDark");
}

</script>

<c:forEach var="pc" items="${pcList}">
	<c:if test="${pc.hp eq 0 }">
		<script>
			var turn = ${pc.encounterDetails.initiative.initiative};
			var highlightElement = "#initiative_" + turn;
			$(highlightElement).addClass("highlightDark");
		</script>
	</c:if>
</c:forEach>
</html>