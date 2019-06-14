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
		<form action="CharacterDetailsEdit">
			<table class="paleBlueRows">
				<tr>
					<td class="bold">Level</td>
					<td><input name="level" type="text" size="1" value="${pc.level }"/></td>
					<td class="bold">Exp</td>
					<td><input name="exp" type="text" size="1" value="${pc.exp }"/></td>
					<td class="bold">Hit Die</td>
					<td><input name="hitDice" type="text" size="1" value="${pc.hitDice }"/></td>
				</tr>
				<tr>
					<td class="bold">Armor Class</td>
					<td><input name="armorClass" type="text" size="1" value="${pc.armorClass }"/></td>
					<td class="bold">Initiative</td>
					<td><input name="initiative" type="text" size="1" value="${pc.initiative }"/></td>
					<td class="bold">Speed</td>
					<td><input name="speed" type="text" size="1" value="${pc.speed }"/></td>
				</tr>
				<tr>
					<td class="bold">Max HP</td>
					<td><input name="maxHP" type="text" size="1" value="${pc.maxHp}"/></td>
					<td class="bold">Current HP</td>
					<td><input name="hp" type="text" size="1" value="${pc.hp}"/></td>
					<td class="bold">Temp HP</td>
					<td><input name="tempHP" type="text" size="1" value="${pc.tempHP}"/></td>
					
				</tr>
				<tr>
					<td class="bold">Copper Pieces</td>
					<td><input name="copper" type="text" size="1" value="${pc.currency.copperPieces}"/></td>
					<td class="bold">Silver Pieces</td>
					<td><input name="silver" type="text" size="1" value="${pc.currency.silverPieces}"/></td>
					<td class="bold">Gold Pieces</td>
					<td><input name="gold" type="text" size="1" value="${pc.currency.goldPieces}"/></td>
				</tr>
				<tr>
					<td class="bold">Electrum Pieces</td>
					<td><input name="electrum" type="text" size="1" value="${pc.currency.electrumPieces}"/></td>
					<td class="bold">Platinum Pieces</td>
					<td><input name="platinum" type="text" size="1" value="${pc.currency.platinumPieces}"/></td>
				</tr>
				<tr><td><input type="submit" value="submit"/>
				<input type="hidden" name="action" value="update"/>
				<input type="hidden" name="characterID" value="${pc.characterID}"/>
				</td></tr>
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
		</form>

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
				<tr>
					<td colspan="2"><button class="button" type="button" onclick="changeWeapons'${pc.characterID}')">Change Weapons</button></td>
				</tr>
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
				<tr>
					<td colspan="2"><button class="button" type="button" onclick="editArmor'${pc.characterID}')">Change Weapons</button></td>
				</tr>
			</table>
			
		</article>

	</section>

	<footer>
		<nav>
			<ul>
				<li><a href="CharacterDetails?characterID=${pc.characterID}">Back</a></li>
			</ul>
		</nav>
	</footer>
<script>
function abilitiesScoreDetailsNav(characterID){
	window.location="AbilitiesScoreDetails?characterID="+characterID;
}
function changeArmor(characterID){
	window.location="ChangeEquipment?type=armor&characterID="+characterID;
}
function changeWeapons(characterID){
	window.location="ChangeEquipment?type=weapon&characterID="+characterID;
}
</script>
</body>
</html>