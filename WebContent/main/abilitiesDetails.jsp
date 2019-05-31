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
.test
{
   position:fixed;
   right:20px;
   bottom: 20px;
}
.paleBlueRow50{
	width: 50% !important;
}
.hidden{
	display: none;
}
</style>
</head>
<body>

	<section id='mainSection'>

		<article>
			<header>
				<h2>${pc.characterName}</h2>
			</header>
			<div class="test">
			   <button type="button" class="button" onclick="goBack('${pc.characterFileName}')">Back</button>
			</div>
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
				</tbody>
			</table>
			
			<table class="paleBlueRows paleBlueRow50">

				<tr><td>Acrobatics</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Animal Handling</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Arcana</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Athletics</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Deception</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>History</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Insight</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Intimidation</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Investigation</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Medicine</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Nature</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Perception</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Performance</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Persuasion</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Religion</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Sleight of Hand</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Stealth</td><td>${pc.abilityScores.strMod }</td></tr>
				<tr><td>Survival</td><td>${pc.abilityScores.strMod }</td></tr>
			</table>

			
			<p>Info</p>
			<p>info</p>
			<p>info</p>
		</article>

	</section>

	<footer>
		<nav id="bottomNav">
			<ul>
				<li><a href="CharacterSelect">Back</a></li>
			</ul>
		</nav>
	</footer>
<script>

	$(document).ready(function() {
		var $window = $(window);
		var tabwrap = $('.test');
		var prefooter = $('#bottomNav');
		var prefooter_top = prefooter.offset().top;
		//var prefooter_height = prefooter.height();
		//var prefooter_bottom = prefooter_top + prefooter_height;
		//console.log(prefooter_bottom);
		$window.on('scroll', function() {
			
			var scrollTop = $window.scrollTop();
			var viewport_height = $(window).height();
			var scrollTop_bottom = scrollTop + viewport_height;
			tabwrap.toggleClass('hidden', scrollTop_bottom > prefooter_top);
			
			console.log(scrollTop_bottom + "::" + prefooter_top);
		});
	});
	
	function goBack(charName){
		window.location="CharacterDetails?charName="+charName;
	}
</script>
</body>
</html>