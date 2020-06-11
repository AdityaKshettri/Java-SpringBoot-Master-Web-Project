package JavaWebMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import JavaWebMaster.entity.Basic;
import JavaWebMaster.entity.User;
import JavaWebMaster.repository.BasicRepository;
import JavaWebMaster.repository.UserRepository;

@SpringBootApplication
public class JavaMasterApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BasicRepository basicRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaMasterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User user1 = userRepository.save(new User("Adi", "{noop}1234", "ADMIN", "USER"));
		User user2 = userRepository.save(new User("Ksh", "{noop}1234", "USER"));
		
		basicRepository.save(new Basic("basic1", user1));
		basicRepository.save(new Basic("basic2", user2));
		basicRepository.save(new Basic("basic3", user1));
	}

}
