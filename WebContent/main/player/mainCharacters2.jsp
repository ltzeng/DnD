<!DOCTYPE HTML>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="main/css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width">
<title>${pc.characterName}</title>

<head>
</head>
<body>


	<section id='mainSection'>

		<article>
			<header>
				<h2>${pc.characterName}</h2>
			</header>
			<c:forEach var="pc" items="${charactersList}">
		 <table style="border:1px solid black;">
		 	<tr>
		 		<td rowspan=7><a href="CharacterDetails?characterID=${pc.characterID}">
		 		<img src="image/character/${pc.avatarPicture }.png" alt="${imgUrl}" style="width:200px;height:300px;"></a></td>
		 	</tr>
		 	<tr>
		 		<td>${pc.characterName}</td>
		 	</tr>
		 	<tr>
		 		<td>Level : ${pc.level}</td>
		 	</tr>
		 	<tr>
		 		<td>Background : ${pc.background}</td>
		 	</tr>
		 	<tr>
		 		<td>Alignment: ${pc.alignment}</td>
		 	</tr>
		 	<tr>
		 		<td>Exp: ${pc.exp}</td>
		 	</tr>
		 	<tr>
		 		<td>HP: ${pc.hp}</td>
		 	</tr>
		 	<tr>
		 		<td align="center" colspan=2><b>STR:</b> ${pc.abilityScores.strMod }
		 		<b>DEX:</b> ${pc.abilityScores.dexMod }
		 		<b>CON:</b> ${pc.abilityScores.conMod }
		 		<b>INT:</b> ${pc.abilityScores.intelMod}
		 		<b>WIS:</b> ${pc.abilityScores.wisMod }
		 		<b>CHA:</b> ${pc.abilityScores.chaMod }</td>
		 	</tr>
		 </table>
	 </c:forEach>
		</article>

	</section>

</body>
<style>
textarea {
	width: 300px;
	display:block;
	background-image: url("image/backgrounds/paper-bg.jpg");
	font-family: Garamond;
	border: none;
}
label {
	display:block;
	background-image: url("image/backgrounds/paper-bg.jpg");
	font-weight: bold;
	
}
p{
	width: 300px;
	display: inline-block;
	background-image: url("image/backgrounds/paper-bg.jpg");
	font-family: Garamond;
}
input{
	background-image: url("image/backgrounds/paper-bg.jpg");
}

</style>
</html>