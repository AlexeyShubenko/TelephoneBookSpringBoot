package com.test.javaproject.mvc.service.impl;

import com.test.javaproject.mvc.domains.User;
import com.test.javaproject.mvc.dto.UserDto;
import com.test.javaproject.mvc.exceptions.PasswordErrorException;
import com.test.javaproject.mvc.exceptions.UserNotFindException;
import com.test.javaproject.mvc.repository.UserRepository;
import com.test.javaproject.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User.Builder()
				.setLoginName(userDto)
				.setPassword(userDto)
				.setFio(userDto)
				.build();
		userRepository.saveUser(user);
	}

	@Override
	public UserDto verifyUser(String login, String password) {

		User user = userRepository.getUserByLoginName(login);
		if(Objects.isNull(user)){
//			if user is not exist
			throw new UserNotFindException("");
		}
		if(user.getPassword().equals(password)){
			UserDto userDto = new UserDto.Builder()
					.setUserId(user)
					.setLoginName(user)
					.setPassword(user)
					.setFio(user)
					.build();
			return userDto;
		}else {
			throw new PasswordErrorException();
		}

	}

	@Override
	public boolean checkExistingUser(String login) {
		User user = userRepository.getUserByLoginName(login);
		return Objects.nonNull(user);
	}


}
