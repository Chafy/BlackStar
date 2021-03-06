package fr.sigl.intg.model;
// Generated Jan 3, 2016 2:05:43 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Userlogin generated by hbm2java
 */
@Entity
@Table(name = "userlogin", schema = "public", catalog = "blackstar")
public class Userlogin implements Serializable {
	private int userId;
	private String userLogin;
	private String userPassword;
	private String userType;
	private Set tags = new HashSet(0);

	public Userlogin() {
	}

	public Userlogin(int userId, String userLogin, String userPassword, String userType) {
		this.userId = userId;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
		this.userType = userType;
	}

	public Userlogin(int userId, String userLogin, String userPassword, String userType, Set tags) {
		this.userId = userId;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
		this.userType = userType;
		this.tags = tags;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userlogin_user_id_seq")
    @SequenceGenerator(name="userlogin_user_id_seq", sequenceName="userlogin_user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Basic
    @Column(name = "user_login")
	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

    @Basic
    @Column(name = "user_password")
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

    @Basic
    @Column(name = "user_type")
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="userlogin")
	public Set getTags() {
		return this.tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
	}

}
