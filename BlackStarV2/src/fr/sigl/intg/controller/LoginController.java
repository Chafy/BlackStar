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

	public Boolean submitLogin(String login, String password) {
		
		LoginForm loginForm = new LoginForm();
		Boolean result = loginForm.SubmitAuthentification(login, password);
		
		return result;
	}

}