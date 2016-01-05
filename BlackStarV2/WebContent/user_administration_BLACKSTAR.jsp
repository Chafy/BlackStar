<%@include file="includes/header.jsp"%>

<center>
	<table>
		<tr>
			<td><center style="font-size: 16px; margin: 20px 10px 60px 10px">
					<b>Gestion des utilisateurs</b>
				</center></td>
		</tr>
	</table>
	<form action="add_user" method="post">
		<table cellpadding="10">
			<tr>
			</tr>

			<tr>
				<td>Identifiant:</td>
				<td><input name="login_userform" value="" /></td>
				<td>Mot de passe:</td>
				<td><input name="password_userform" value="" /></td>
				<td>Profil:</td>
				<td><select name="type_userform">
						<option value="user">Utilisateur</option>
						<option value="admin">Administrateur</option>
				</select></td>
				<td><button type="submit" name="addUser_button">Ajouter un utilisateur</button></td>

			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td><a href="tags">Retour</a></td>
		</tr>

	</table>
</center>

<%@include file="includes/footer.jsp"%>