<%@include file="includes/header.jsp"%>

<center>
	<table cellpadding="10">

		<tr>
			<td>
				<form action="gestion">
					<input type="hidden" id="isAdmin" value="${isAdmin}" />
					<button type="submit" id="adminButton">Gérer les utilisateurs</button>
				</form>
			</td>
		</tr>
		<form action="search_tags">
			<tr>
				<td>Nom :</td>
				<td><input name="name_searchform" value="" /></td>
				<td>Auteur (Nom):</td>
				<td><input name="author_lastname_searchform" value="" /></td>
				<td>Auteur (Prénom):</td>
				<td><input name="author_firstname_searchform" value="" /></td>
				<td>Responsable fiche:</td>
				<td><input name="login_searchform" value="" /></td>
			</tr>
			<tr class="searchButtonTr">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td class="searchButtonTd"><button type="submit"
						class="searchbutton" name="search_button">Rechercher</button></td>
			</tr>
		</form>
		<tr>
			<td><center style="font-size: 16px">
					<b>Fiches de tag existantes</b>
				</center></td>
		</tr>
		<tr>
			<table border="1" cellpadding="10" width="60%">
				<thead bgcolor="B8D2FF">
					<tr>
						<th>Nom</th>
						<th>Auteur (Nom)</th>
						<th>Auteur (Prénom)</th>
						<th>Date</th>
						<th>Responsable fiche</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tag" items="${tagList}">
						<tr>
							<td><a href="edit?tagId=${tag.tagId}">${tag.tagName}</a></td>
							<td><a href="edit?tagId=${tag.tagId}">${tag.tagAuthorlastname}</a></td>
							<td><a href="edit?tagId=${tag.tagId}">${tag.tagAuthorfirstname}</a></td>
							<td><a href="edit?tagId=${tag.tagId}">${tag.tagRegistrationdate}</a></td>
							<td><a href="edit?tagId=${tag.tagId}">${tag.userlogin.userLogin}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</tr>
		<tr>
			<td><a href="add">Ajouter une nouvelle fiche</a> <!-- <form style="margin: 10px" action="Go_to_add_a_fiche">
					<input type="submit" value="Ajouter une fiche">
				</form> --></td>
		</tr>
	</table>
</center>
<script>
if (document.getElementById("isOwner").value === "true") {
	var adminButton = document.getElementById("adminButton");
	adminButton.disabled = false;
	adminButton.style.visibility = "hidden";
}
</script>
<%@include file="includes/footer.jsp"%>