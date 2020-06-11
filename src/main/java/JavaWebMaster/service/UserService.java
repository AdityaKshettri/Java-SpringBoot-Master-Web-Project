package JavaWebMaster.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import JavaWebMaster.entity.User;
import JavaWebMaster.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public User getCurrentUser()
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userRepository.findByUsername(username);
		return currentUser;
	}
	
	@Transactional
	public void save(User newUser)
	{
		newUser.setPassword("{noop}" + newUser.getPassword());
		userRepository.save(newUser);
	}
	
	public boolean isAuthenticated()
	{
		if(getCurrentUser() == null)
			return false;
		return true;
	}

}
