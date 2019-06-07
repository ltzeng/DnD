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
					<th class="ally">${pc.characterName }</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="pc" items="${pcList}">
					<td id="actor_${pc.encounterDetails.initiative }">
					<table class="player">
						<tbody>
						<tr>
							<td><div id="actor_1_status"></div>
							<img src='image/character/${pc.avatarPicture}-mobile.png' />
							</td>
						</tr>
						<tr>
							<td></td>
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
					<td>DS</td>
				</c:forEach>
			</tr>
		</tfoot>
	</table>
	
	<table class="cinereousTable">
		<thead>
			<tr>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="actor_3"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="actor_4"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="actor_5"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_4"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_5"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_6"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_7"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_8"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_9"><img class="enemy_img" src="image/enemies/goblin.png"></td>
				<td id="enemy_10"><img class="enemy_img" src="image/enemies/goblin.png"></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td class="enemy_blue"></td>
				<td class="enemy_red"></td>
				<td class="enemy_purple"></td>
				<td class="enemy_green"></td>
				<td class="enemy_grey"></td>
				<td class="enemy_blue"></td>
				<td class="enemy_red"></td>
				<td class="enemy_purple"></td>
				<td class="enemy_green"></td>
				<td class="enemy_grey"></td>

			</tr>
		</tfoot>

	</table>
</div>
</body>
<style>

.enemy_img {
      display:block; width:100%; height:auto;
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
	max-height: 75%;
	max-width: 75%;
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



</style>
<button onclick="addSkull('1')">add skull</button>
<button onclick="addHighlight()">add highlight</button>

<script>
// setInterval(function(){
	 $.get( "BattleTrackerAPI",{action:'updateCheck', adventureID:1}, function( data ) {
//		  console.log(data.birthday);
//		  console.log(data.name);
//		  console.log(data.married);
		  console.log(data);
		});
    //window.location.reload(1);
// }, 5000);

var turn = ${encounter.turn};
$("#actor_"+turn).addClass("highlight");
function addSkull(player_id){
	player_id = player_id + "_status";
	$("#actor_"+player_id).prepend('<img class="status-img" src="image/status/skull.png"/>');
}

var i =0;
function addHighlight(){
	i=i+1;
	$("#actor_"+i).addClass("highlight");
}

</script>
</html>