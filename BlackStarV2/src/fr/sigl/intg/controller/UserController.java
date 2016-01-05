package fr.sigl.intg.controller;

import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

/** 
 *  @{Ajout d'un utilisateur}
 */
public class UserController {

	UserloginDAO ulDAO;
	
	
	public UserController() {
		ulDAO = new UserloginDAO();
	}
	
	public void addUser(String login, String password, String type) {
		
		Userlogin newUser = new Userlogin();
		
		newUser.setUserLogin(login);
		newUser.setUserPassword(password);
		newUser.setUserType(type);
		
		ulDAO.persist(newUser);

  }

  public void getCurrentUser() {
  }

}