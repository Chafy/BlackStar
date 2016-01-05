<%@include file="includes/header.jsp" %>

<center>
<table>
<form action="login" method="post">
		<tr>
			<center style="font:arial; font-size:20px;margin:30px"><b>BlackStar</b></center> 
        <tr>
            <td>Identifiant :</td>
            <td><input name="login_form" value=""/></td>
        </tr>
		<tr>
            <td>Mot de passe :</td>
            <td><input type="password" name="password_form" value=""/></td>
        </tr>
        <tr>
           <td><button type="submit" name="submit_button">Connexion</button></td>
        </tr>
</form>
</table>
<hr/>


<%@include file="includes/footer.jsp" %>
