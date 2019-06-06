<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="main/css/battle-styles.css">
</head>

<style>
table.test {
  border: none;
  background-color: #FFE3C6;
  width: 100%;
  text-align: left;
}

.test img {
	max-height: 75%;
	max-width: 75%;
}
</style>

<body background="image/backgrounds/paper-bg.jpg">

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
					<td>
						<table class="test">
							<tr>
								<!-- td><div class="content-top" id="${pc.characterID }-death"><img id="status-img" src="image/status/skull.png"/></div></td-->
								<td>
								<img  src='image/character/${pc.avatarPicture }-mobile.png' />
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
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
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="highlight"></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<div id="content-top">
					   <img src="image/status/skull.png" class="ribbon"/>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script>
setTimeout(function(){
   window.location.reload(1);
}, 30000);
</script>
</html>