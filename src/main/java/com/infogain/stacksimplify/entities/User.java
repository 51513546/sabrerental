package com.infogain.stacksimplify.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@Column(name="EMAIL_ADDRESS",length = 50,nullable = false,unique = true)
	private String email;
	
	@Size(min=2,message="First Name Should Have Atleast 2 Char Above.")
	@Column(name="FIRST_NAME",length = 50,nullable = false)
	private String firstname;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="LAST_NAME",length = 50,nullable = false)
	private String lastname;
	@Column(name="ROLL",length = 50,nullable = false)
	private String rollno;
	@Column(name="SSN",nullable = false,length = 50)
	private String ssn;
	
	@NotEmpty(message ="User Name Is Required,Please Provide Username.")	
	@Column(name="USER_NAME",length = 50,nullable = false,unique = true)
	private String username;

	public User() {
	
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy ="user")
	private List<Order> listOfOrder;
	

	public List<Order> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<Order> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	public User(Long id, String username, String firstname, String lastname, String email, String rollno, String ssn) {
		
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.rollno = rollno;
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public Long getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public String getRollno() {
		return rollno;
	}

	public String getSsn() {
		return ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", rollno=" + rollno + ", ssn=" + ssn + "]";
	}

}
