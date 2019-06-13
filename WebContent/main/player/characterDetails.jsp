<!DOCTYPE HTML>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="main/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width">
<title>${pc.characterName}</title>

<head>
<style>
#mainHeader {
	background-image: url("image/backgrounds/forest-bg.png");
	background-repeat: no-repeat;
	background-size: cover;
	
	overflow: auto;
}
</style>
</head>
<body>

	<header id='mainHeader'>

		<div id='responsiveLogo'>
			<img src='image/character/${pc.avatarPicture }-mobile.png' />
		</div>

	</header>

	<section id='mainSection'>

		<article>
			<header>
				<h2>${pc.characterName}</h2>
			</header>
			<table class="paleBlueRows">
				<thead>
					<tr>
						<th>${pc.race}</th>
						<th>${pc.characterClass}</th>
						<th>${pc.background}</th>
						<th>${pc.alignment}</th>
					</tr>
			</table>
			<table class="paleBlueRows">
				<tr>
					<td class="bold">Level</td>
					<td>${pc.level }</td>
					<td class="bold">Exp</td>
					<td>${pc.exp }</td>
					<td class="bold">Hit Die</td>
					<td>${pc.hitDice }</td>
				</tr>
				<tr>
					<td class="bold">Armor Class</td>
					<td>${pc.armorClass }</td>
					<td class="bold">Initiative</td>
					<td>${pc.initiative }</td>
					<td class="bold">Speed</td>
					<td>${pc.speed }</td>
				</tr>
				<tr>
					<td class="bold">Max HP</td>
					<td>${pc.maxHp }</td>
					<td class="bold">Current HP</td>
					<td>${pc.hp }</td>
					
				</tr>
				<tr>
					<td class="bold">Wealth</td>
					<td colspan="2">${pc.currency.currencyDisplay }</td>
				</tr>
				<c:if test="${pc.tempHP ne 0 }">
					<tr>
						<td class="bold">Temp HP</td>
						<td></td>
					</tr>
				</c:if>
			</table>
			<table class="paleBlueRows">
				<thead>
					<tr>
						<th>STR</th>
						<th>DEX</th>
						<th>CON</th>
						<th>INT</th>
						<th>WIS</th>
						<th>CHA</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${pc.abilityScores.strMod }</td>
						<td>${pc.abilityScores.dexMod }</td>
						<td>${pc.abilityScores.conMod }</td>
						<td>${pc.abilityScores.intelMod }</td>
						<td>${pc.abilityScores.wisMod }</td>
						<td>${pc.abilityScores.chaMod }</td>
					</tr>
					<tr>
						<td colspan="2"><button class="button" type="button" onclick="abilitiesScoreDetailsNav('${pc.characterID}')">Details</button></td>
					</tr>
				</tbody>
			</table>

			<table class="paleBlueRows">
				<thead>
					<tr>
						<th colspan="3">Weapons</th>
					</tr>
					<tr>
						<th>Name</th>
						<th>ATK Bonus</th>
						<th>DMG/Type</th>
					<tr>
				</thead>
				<c:forEach var="w" items="${pc.weapons}">
					<tr>
						<td>${w.name }</td>
						<td></td>
						<td>${w.damage }</td>
					</tr>
				</c:forEach>
			</table>
			
			<table class="paleBlueRows">
				<thead>
					<tr>
						<th colspan="4">Armor</th>
					</tr>
					<tr>
						<th>Name</th>
						<th>Armor Class</th>
						<th>Strength</th>
						<th>Stealth</th>
					<tr>
				</thead>
				<c:forEach var="a" items="${pc.armors}">
					<tr>
						<td>${a.name }</td>
						<td>${a.armorClass }</td>
						<td>${a.strength }</td>
						<td>${a.stealth }</td>
					</tr>
				</c:forEach>
			</table>
			
			<p>Info</p>
			<p>info</p>
			<p>info</p>
		</article>

	</section>

	<footer>
		<nav>
			<ul>
				<li><a href="CharacterDetailsEdit?characterID=${pc.characterID}">Edit</a></li>
				<li><a href="#home">Notes</a></li>
				<li><a href="CharacterSelect?adventureID=${pc.adventureID}">Back</a></li>
			</ul>
		</nav>
	</footer>
<script>
function abilitiesScoreDetailsNav(characterID){
	window.location="AbilitiesScoreDetails?characterID="+characterID;
}
</script>
</body>
</html>