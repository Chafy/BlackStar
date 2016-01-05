package fr.sigl.intg.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.sigl.intg.LoginForm;
import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

/** 
 *  {@Gestion de l'authentification}
 */
public class LoginController {

	public Boolean submitLogin(String login, String password) {

		LoginForm loginForm = new LoginForm();
		Boolean result = loginForm.SubmitAuthentification(login, password);

		return result;
	}

	public String findType(String login) {
		Userlogin user = new Userlogin();
		user.setUserLogin(login);
		UserloginDAO userDAO = new UserloginDAO();
		List userList = userDAO.findByExample(user);

		String result = "";
		if (!userList.isEmpty()) {
			user = (Userlogin) userList.get(0);
			result = user.getUserType();
		}
		
		return result;
	}

}