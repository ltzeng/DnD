<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="main/css/battle-styles.css">
</head>

<body background="paper-bg.jpg">

<div id="battleTracker">
	<table class="cinereousTable">
		<thead>
			<tr>
				<th class="ally">JinYang</th>
				<th class="enemy">Goblin</th>
				<th class="enemy">Goblin</th>
				<th class="ally">Joylusion</th>
				<th>head5</th>
				<th>head6</th>
				<th>head7</th>
				<th>head8</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="highlight"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<div id="content-top">
					   <img src="skull.png" class="ribbon"/>
					</div>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
				<td>DS</td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
<script>
setTimeout(function(){
   window.location.reload(1);
}, 30000);
</script>
</html>