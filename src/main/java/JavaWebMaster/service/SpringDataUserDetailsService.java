package JavaWebMaster.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import JavaWebMaster.entity.User;
import JavaWebMaster.repository.UserRepository;

@Service
public class SpringDataUserDetailsService implements UserDetailsService
{
	private final UserRepository userRepository;
	
	@Autowired
	public SpringDataUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = userRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(
			user.getUsername(),
			user.getPassword(),
			Stream.of(user.getRoles())
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));
	}

}
