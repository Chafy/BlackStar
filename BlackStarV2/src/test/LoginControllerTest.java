package test;

import org.testng.annotations.Test;

import fr.sigl.intg.LoginForm;
import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

public class LoginControllerTest {

  @Test
  public void findType() {
    UserloginDAO userloginDAO = new UserloginDAO();
    Userlogin userlogin = userloginDAO.findById(1);
    
    assert (userlogin.getUserType().equals("admin"));
  }

  @Test
  public void submitLogin() {
	  LoginForm loginForm = new LoginForm();
	  Boolean result = loginForm.SubmitAuthentification("admin", "admin");
	  
	  assert(result == true);
  }
}
