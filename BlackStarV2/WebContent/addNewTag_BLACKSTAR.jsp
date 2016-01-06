<%@include file="includes/header.jsp"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<center>
	<form id="create_tag" action="create_tag" method="post" enctype="multipart/form-data">
		<input type="hidden" id="isOwner" value="${isOwner}"/>
		<input type="hidden" id="isAdmin" value="${isAdmin}"/>

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
				<td><input type="text" name="tag_name" value="" /></td>
			</tr>
			<tr>
				<td>Images:</td>
			</tr>
			<tr>
				<td colspan="4"><input type="file" accept=".png"
					name="image_chooser" /></td>
			</tr>
			<tr>
				<td>Date de prise*:</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${now}"></fmt:formatDate></td>
				<td>Identifiant responsable*:</td>
				<td><input disabled="disabled" name="tag_responsible"
					value="${userConnected}"/></td>
			</tr>
			<tr>
				<td>Support*:</td>
				<td><input type="text" name="tag_support" value="" /></td>
				<td>Spécificité du support:</td>
				<td><input type="text" name="tag_support_specificity" value="" /></td>
			</tr>
			<tr>
				<td>Lieu*:</td>
				<td><input type="text" name="tag_place" value="" /></td>
				<td>Taille:</td>
				<td><input type="text" name="tag_size" value="" /></td>
			</tr>
			<tr>
				<td>Technique utilisée:</td>
				<td><input type="text" name="tag_technique" value="" /></td>
				<td>Résidus / déchets:</td>
				<td><input type="text" name="tag_trash" value="" /></td>
			</tr>
			<tr>
				<td>Auteur (Nom):</td>
				<td><input type="text" name="tag_author_lastname" value="" /></td>
				<td>Auteur (Prénom):</td>
				<td><input type="text" name="tag_author_firstname" value="" /></td>
			</tr>
			<tr>
				<td>Identitée vérifiée?:</td>
				<td><input type="checkbox" id="isVerifiedId"
					name="tag_isVerified" value="" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Commentaire et signes identifiants:</td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea form="create_tag" name="tag_comment" cols="50" rows="5"></textarea>
					<br />
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
				<input type="submit" value="Valider"/>
				<span>  </span>
				</td>
				<td><a href="/BlackStarV2/tags">Retour</a></td>
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
