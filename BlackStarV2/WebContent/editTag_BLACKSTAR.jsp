<%@include file="includes/header.jsp"%>

<center>
	<form id="save_modifications" action="save_modifications" method="post" enctype="multipart/form-data">
		<input type="hidden" id="isOwner" value="${isOwner}" /> <input
			type="hidden" id="isAdmin" value="${isAdmin}" />

	<table>
		<tr>
		<td>                                                                                        </td>
			<td><center style="font-size: 16px; margin: 20px 10px 60px 10px">
					<b>${tag.tagName}</b>
				</center></td>
		</tr>
	</table>
	<form action="report" method="get">
		<input type="hidden" name="tagId" id="tagId" value="${tag.tagId}" />
	<table>
		<tr>
			<td><button style="margin: 30px" type="submit"
						id="submitButton">Générer le rapport judiciaire</button></td>
		</tr>
	</table>
	</form>
	<form action="save_modifications" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="tagId" id="tagId" value="${tag.tagId}" />

		<table cellpadding="10">
			<tr>
				<td>Nom*:</td>
				<td><input name="tag_name" value="${tag.tagName}" /></td>
			</tr>
			<tr>
				<td>Images*:</td>
				<input type="hidden" id="stop_start" value="start" />
				<marquee id="marquee" onClick="stop_start()">
					<c:forEach var="image" items="${tag.images}">
						<img src="/BlackStarV2/display_img?selectedImageId=${image.imgId}" />
					</c:forEach>
				</marquee>
				</td>
			</tr>
			<tr>
				<td colspan="4"><input type="file" accept=".png"
					name="image_chooser"></td>
			</tr>
			<tr>
				<td>Date de prise*:</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${tag.tagRegistrationdate}"></fmt:formatDate></td>
				<td>Identifiant responsable:</td>
				<td><input disabled="disabled" name="user_login"
					value="${tag.userlogin.userLogin}" /></td>

			</tr>
			<tr>
				<td>Support:</td>
				<td><input name="tag_support" value="${tag.tagSupport}" /></td>
				<td>Spécificité du support:</td>
				<td><input name="tag_support_specificity"
					value="${tag.tagSupportspecificity}" /></td>
			</tr>
			<tr>
				<td>Lieu:</td>
				<td><input name="tag_place" value="${tag.tagPlace}" /></td>
				<td>Taille:</td>
				<td><input name="tag_size" value="${tag.tagSize}" /></td>
			</tr>
			<tr>
				<td>Technique utilisée:</td>
				<td><input name="tag_technique" value="${tag.tagUsedtechnique}" /></td>
				<td>Résidus / déchets:</td>
				<td><input name="tag_trash" value="${tag.tagTrashleft}" /></td>
			</tr>
			<tr>
				<td>Auteur (Nom):</td>
				<td><input name="tag_author_firstname"
					value="${tag.tagAuthorfirstname}" /></td>
				<td>Auteur (Prénom):</td>
				<td><input name="tag_author_lastname"
					value="${tag.tagAuthorlastname}" /></td>
			</tr>
			<tr>
				<td>Identitée vérifiée?:</td>
				<td><input type="checkbox" name="idVerified"
					value="${tag.tagIdverified}" /></td>
			</tr>
			<tr>
				<td>Commentaire et signes identifiants:</td>
			</tr>
			<tr>
				<td colspan="4"><textarea form="save_modifications" name="tag_comment" name="commentsTextBox" cols="50"
						rows="5">${tag.tagComment}</textarea> <br /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><button style="margin: 30px" type="submit"
						id="submitButton">Valider</button></td>
				<td><a href="tags">Retour</a></td>
			</tr>
		</table>
	</form>
</center>
<script>
	if (document.getElementById("isOwner").value === "false") {
		var submitB = document.getElementById("submitButton");
		submitB.disabled = true;
	}
	if (document.getElementById("isAdmin").value === "false") {
		var idVerif = document.getElementById("isVerifiedId");
		idVerif.disabled = true;
		submitB.disabled = true;

	}
	
	function stop_start() {
		if (document.getElementById('stop_start').value == 'start') {
			document.getElementById('stop_start').value = 'stop';
			document.getElementById('marquee').start()
		} else {
			document.getElementById('stop_start').value = 'start';
			document.getElementById('marquee').stop()	
		}
	}
</script>
<%@include file="includes/footer.jsp"%>