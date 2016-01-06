package test;

import org.testng.annotations.Test;
import fr.sigl.intg.controller.UserController;

public class UserControllerTest {

  @Test
  public void UserController() {
	  UserController userController = new UserController();
	  assert(userController != null);
  }

  @Test
  public void addUser() {
    assert(true);
  }

  @Test
  public void getCurrentUser() {
    assert(true);
  }
}
