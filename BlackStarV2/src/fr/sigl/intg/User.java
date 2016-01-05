package fr.sigl.intg;


public class User {

  private Integer id;

  private String login;

  private String password;

  private String type;

  public User(Integer id, String login, String password, String type) {
	super();
	this.id = id;
	this.login = login;
	this.password = password;
	this.type = type;
}

public boolean isAdmin() {
	  return type.equalsIgnoreCase("admin");
  }

  public String getLogin() {
	  return login;
  }

}