package fr.sigl.intg;

import java.util.List;

import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

public class LoginForm {

  public Boolean SubmitAuthentification(String login, String password) {
	  
	  if (login.equals("") || password.equals(""))
		  return false;
	  
	  Userlogin user = new Userlogin();
	  user.setUserLogin(login);
	  user.setUserPassword(password);
	  
	  UserloginDAO userDAO = new UserloginDAO();
	  List userList = userDAO.findByExample(user);
	  
	  if (userList.isEmpty())
		  return false;
	  	  
	  return true;
  }

  public void DisplayLoginForm() {
  }

}