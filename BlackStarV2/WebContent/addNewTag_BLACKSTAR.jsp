<%@include file="includes/header.jsp"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<center>
	<form action="create_tag" method="post">
	<input type="hidden" id="isOwner" value="${isOwner}"/>
	<input type="hidden" id="isAdmin" value="${isAdmin}" }/>

		<table>
			<tr>
				<td>
					<center style="font-size: 16px; margin: 20px 10px 60px 10px">
						<b>Ajout d'une nouvelle fiche</b>
					</center>
				</td>
			</tr>
		</table>
		<table cellpadding="10">
			<tr>
				<td>Nom*:</td>
				<td><input name="tag_name" value="" /></td>
			</tr>
			<tr>
				<td>Images*:</td>
			</tr>
			<tr>
				<td colspan="4"><input type="file" accept=".png"
					name="image_chooser"/></td>
			</tr>
			<tr>
				<td>Date de prise*:</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${now}"></fmt:formatDate></td>
				<td>Identifiant responsable:</td>
				<td><input disabled="disabled" name=tag_responsible
					value=${responsbaleLogin } /></td>

			</tr>
			<tr>
				<td>Support:</td>
				<td><input name="tag_support" value="" /></td>
				<td>Spécificité du support:</td>
				<td><input name="tag_support_specificity" value="" /></td>
			</tr>
			<tr>
				<td>Lieu:</td>
				<td><input name="tag_place" value="" /></td>
				<td>Taille:</td>
				<td><input name="tag_size" value="" /></td>
			</tr>
			<tr>
				<td>Technique utilisée:</td>
				<td><input name="tag_technique" value="" /></td>
				<td>Résidus / déchets:</td>
				<td><input name="tag_trash" value="" /></td>
			</tr>
			<tr>
				<td>Auteur (Nom):</td>
				<td><input name="tag_author_firstname" value="" /></td>
				<td>Auteur (Prénom):</td>
				<td><input name="tag_author_lastname" value="" /></td>
			</tr>
			<tr>
				<td>Identitée vérifiée?:</td>
				<td><input type="checkbox" id="isVerifiedId" name="tag_isVerified" value="" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Commentaire et signes identifiants:</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="commentsTextBox" cols="50"
						rows="5">
					</textarea> <br /></td>
			</tr>

		</table>
		<table>
			<tr>
				<td><button style="margin: 30px" type="submit">Valider</button>
				</td>
				<td>
					<form style="margin: 30px" action="Go_back">
						<button style="margin: 30px" type="submit">Retour</button>
					</form>
				</td>
			</tr>
		</table>
	</form>

</center>

<script>
if (document.getElementById("isAdmin").value === "true") {
	var idVerif = document.getElementById("isVerifiedId");
	idVerif.disabled = false;
}
</script>

<%@include file="includes/footer.jsp"%>
