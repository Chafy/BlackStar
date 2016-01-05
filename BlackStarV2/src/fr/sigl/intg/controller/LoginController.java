package fr.sigl.intg.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.sigl.intg.LoginForm;

/** 
 *  {@Gestion de l'authentification}
 */
public class LoginController {

	/*public Boolean login(Connection db, String login, String password) {
		Boolean result = false;
		try {
			Statement st = db.createStatement( 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			String sql = String.format("SELECT * FROM userlogin WHERE user_login='%s' AND user_password='%s';",
	                login,
	                password);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String log = rs.getString("user_login");
				if (rs.getString("user_login").equalsIgnoreCase(login))
					result = true;
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
	public Boolean submitLogin(String login, String password) {
		
		LoginForm loginForm = new LoginForm();
		Boolean result = loginForm.SubmitAuthentification(login, password);
		
		return result;
	}

}