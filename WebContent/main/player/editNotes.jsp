<!DOCTYPE HTML>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="main/css/styles.css">
<script src="main/js/autosize.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width">
<title>${pc.characterName}</title>
<head>
</head>
<body>


	<section id='mainSection'>

		<form action="CharacterNotes">
		<table>
			<tr>
				<td>
				<input type="text" name="title" placeholder="title"></input>
				<textarea id="test" name="note" rows="4" cols="50" placeholder="new note"></textarea></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="submit" /> 
				<input type="hidden" name="action" value="update" /> 
				<input type="hidden" name="characterID" value="${characterID}" />
				<input type="hidden" name="noteID" value="${note.noteID}" />
				</td>
			</tr>
		</table>
		</form>

		<c:forEach var="note" items="${notes}">
		
		<div class="editDiv" id="${note.noteID }">
		<form action="CharacterNotes">
			<table>
				<tr>
					<td colspan="2">
					<label for="title">${note.title}</label><label><fmt:formatDate type = "both" value = "${note.date }" /></label>
					<textarea name="note" rows="4" cols="50">${note.note}</textarea></td>
				</tr>
				<tr>
					<td>
					<input class="submitButton" type="submit" value="submit" /> 
					<input type="hidden" name="action" value="update" /> 
					<input type="hidden" name="characterID" value="${characterID}" />
					<input type="hidden" name="noteID" value="${note.noteID}" />
					</td>
				</tr>
			</table>
		</form>
		</div>
		</c:forEach>


	</section>

	<footer>
		<nav>
			<ul>
				<li><a href="CharacterDetails?characterID=${characterID}">Back</a></li>
			</ul>
		</nav>
	</footer>
</body>
<style type="text/css">
#mainHeader {
	background-image: url("image/backgrounds/forest-bg.png");
	background-repeat: no-repeat;
	background-size: cover;
	overflow: auto;
}
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
<script>
$('.displayDiv').click(function(event) {
	$('.submitButton').hide();
    var id = $(this).attr('id');
    $("#"+id).hide();
    $("#edit_"+id).show();
    autosize($('textarea'));
});
</script>
</html>