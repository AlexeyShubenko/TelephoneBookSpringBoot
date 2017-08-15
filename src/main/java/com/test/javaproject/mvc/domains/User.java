package com.test.javaproject.mvc.domains;

import com.test.javaproject.mvc.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="loginName", nullable=false)
	private String loginName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="fio", nullable=false)
	private String fio;
	
	@OneToMany(mappedBy="user")
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public User(){}


	public static class Builder{

		private User user = new User();

		public User.Builder setUserId(UserDto userDto){
			user.setUserId(userDto.getUserId());
			return this;
		}

		public User.Builder setLoginName(UserDto userDto){
			user.setLoginName(userDto.getLoginName());
			return this;
		}

		public User.Builder setPassword(UserDto userDto){
			user.setPassword(userDto.getPassword());
			return this;
		}

		public User.Builder setFio(UserDto userDto){
			user.setFio(userDto.getFio());
			return this;
		}

		public User build(){
			return user;
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
		
}
