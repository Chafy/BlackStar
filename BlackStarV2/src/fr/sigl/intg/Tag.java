package fr.sigl.intg;


import java.util.Date;

/** 
 *  {@Edition d'une fiche par un administrateur, @Consultation d'une fiche de tag}
 */
public class Tag {

  public String name;

  public Date registrationDate;

  public String support;

  public String supportSpecificity;
  
  public String place;

  public String size;

  public String author_firstname;

  public String author_lastname;

  public Boolean idVerified;

  public String usedTechnique;

  public String trashLeft;

  public String comment;

  public Integer id;
  
  public String user_login;

  public Boolean isVerified() {
	  return idVerified;
  }

  public String getTagResponsible() {
	return user_login;
  }

  public Boolean isAllowedToModify(User user) {
	  return true;
  }

public Tag(String name, Date registrationDate, String support, String supportSpecificity, String place, String size,
		String author_firstName, String author_lastName, Boolean idVerified, String usedTechnique, String trashLeft,
		String comment, Integer id, String user_login) {
	super();
	this.name = name;
	this.registrationDate = registrationDate;
	this.support = support;
	this.supportSpecificity = supportSpecificity;
	this.place = place;
	this.size = size;
	this.author_firstname = author_firstName;
	this.author_lastname = author_lastName;
	this.idVerified = idVerified;
	this.usedTechnique = usedTechnique;
	this.trashLeft = trashLeft;
	this.comment = comment;
	this.id = id;
	this.user_login = user_login;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getRegistrationDate() {
	return registrationDate;
}

public void setRegistrationDate(Date registrationDate) {
	this.registrationDate = registrationDate;
}

public String getSupport() {
	return support;
}

public void setSupport(String support) {
	this.support = support;
}

public String getSupportSpecificity() {
	return supportSpecificity;
}

public void setSupportSpecificity(String supportSpecificity) {
	this.supportSpecificity = supportSpecificity;
}

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public String getAuthor_firstname() {
	return author_firstname;
}

public void setAuthor_firstname(String author_firstName) {
	this.author_firstname = author_firstName;
}

public String getAuthor_lastname() {
	return author_lastname;
}

public void setAuthor_lastname(String author_lastName) {
	this.author_lastname = author_lastName;
}

public Boolean getIdVerified() {
	return idVerified;
}

public void setIdVerified(Boolean idVerified) {
	this.idVerified = idVerified;
}

public String getUsedTechnique() {
	return usedTechnique;
}

public void setUsedTechnique(String usedTechnique) {
	this.usedTechnique = usedTechnique;
}

public String getTrashLeft() {
	return trashLeft;
}

public void setTrashLeft(String trashLeft) {
	this.trashLeft = trashLeft;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUser_login() {
	return user_login;
}

public void setUser_login(String user_login) {
	this.user_login = user_login;
}



}