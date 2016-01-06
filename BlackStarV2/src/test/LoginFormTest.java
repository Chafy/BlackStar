package test;

import java.util.List;

import org.testng.annotations.Test;

import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

public class LoginFormTest {

  @Test
  public void DisplayLoginForm() {
    assert(true);
  }

  @Test
  public void SubmitAuthentification() {
	  Userlogin user = new Userlogin();
	  user.setUserLogin("admin");
	  user.setUserPassword("admin");
	  
	  UserloginDAO userDAO = new UserloginDAO();
	  List userList = userDAO.findByExample(user);
	  
	  assert(!userList.isEmpty());
  }
}
