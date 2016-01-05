<%@include file="includes/header.jsp"%>

<center>
	<form action="edit_tag">
		<input type="hidden" id="isOwner" value="${isOwner}" /> <input
			type="hidden" id="isAdmin" value="${isAdmin}" />

		<table>
			<tr>
				<td><center
						style="font-size: 16px; margin: 20px 10px 60px 10px">
						<b>${tag.name}</b>
					</center></td>
			</tr>
		</table>
		<table cellpadding="10">
			<tr>
				<td>Nom*:</td>
				<td><input name="name" value="${tag.name}" /></td>
			</tr>
			<tr>
				<td>Images*:</td>
			</tr>
			<tr>
				<td colspan="4"><input type="file" accept=".png"
					name="image_chooser"></td>
			</tr>
			<tr>
				<td>Date de prise*:</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${tag.registrationDate}"></fmt:formatDate></td>
				<td>Identifiant responsable:</td>
				<td><input disabled="disabled" name="user_login"
					value="${tag.user_login}" /></td>

			</tr>
			<tr>
				<td>Support:</td>
				<td><input name="support" value=${tag.support } /></td>
				<td>Spécificité du support:</td>
				<td><input name="supportSpecificity"
					value=${tag.supportSpecificity } /></td>
			</tr>
			<tr>
				<td>Lieu:</td>
				<td><input name="place" value=${tag.place } /></td>
				<td>Taille:</td>
				<td><input name="size" value=${tag.size } /></td>
			</tr>
			<tr>
				<td>Technique utilisée:</td>
				<td><input name="usedTechnique" value=${tag.usedTechnique } /></td>
				<td>Résidus / déchets:</td>
				<td><input name="trashLeft" value=${tag.trashLeft } /></td>
			</tr>
			<tr>
				<td>Auteur (Nom):</td>
				<td><input name="author_firstname"
					value=${tag.author_firstname } /></td>
				<td>Auteur (Prénom):</td>
				<td><input name="author_lastname" value=${tag.author_lastname } /></td>
			</tr>
			<tr>
				<td>Identitée vérifiée?:</td>
				<td><input type="checkbox" name="idVerified"
					value=${tag.idVerified } /></td>
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
				<td><button style="margin: 30px" type="submit"
						id="submitButton" disabled="disabled">Valider</button></td>
				<td>
					<a href="tags">Retour</a>
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
	if (document.getElementById("isOwner").value === "true") {
		var submitB = document.getElementById("submitButton");
		submitB.disabled = false;
	}
</script>
<%@include file="includes/footer.jsp"%>