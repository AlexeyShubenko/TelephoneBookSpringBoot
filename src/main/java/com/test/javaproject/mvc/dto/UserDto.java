package com.test.javaproject.mvc.dto;

import com.test.javaproject.mvc.domains.User;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserDto implements Serializable{

	private Long userId;

	@Size(min=3, message="{user.size.login}")
	private String loginName;

	@Size(min=5, message="{user.size.password}")
	private String password;

	@Size(min=5, message="{user.size.fio}")
	private String fio;

	public UserDto(){}

	public UserDto(String loginName, String password, String fio) {
		this.loginName = loginName;
		this.password = password;
		this.fio = fio;
	}

	public static class Builder{

		private UserDto userDto = new UserDto();

		public Builder setUserId(User user){
			userDto.setUserId(user.getUserId());
			return this;
		}

		public Builder setLoginName(User user){
			userDto.setLoginName(user.getLoginName());
			return this;
		}

		public Builder setPassword(User user){
			userDto.setPassword(user.getPassword());
			return this;
		}

		public Builder setFio(User user){
			userDto.setFio(user.getFio());
			return this;
		}

		public UserDto build(){
			return userDto;
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

	@Override
	public String toString() {
		return "UserDto{" +
				"user_id=" + userId +
				", loginName='" + loginName + '\'' +
				", password='" + password + '\'' +
				", fio='" + fio + '\'' +
				'}';
	}
}
