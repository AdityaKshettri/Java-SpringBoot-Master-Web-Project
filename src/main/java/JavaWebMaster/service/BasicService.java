package JavaWebMaster.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaWebMaster.entity.Basic;
import JavaWebMaster.entity.User;
import JavaWebMaster.repository.BasicRepository;

@Service
public class BasicService 
{
	@Autowired
	private BasicRepository basicRepository;
	
	@Autowired
	private UserService userService;
	
	public List<Basic> findAll() {
		return basicRepository.findAll();
	}
	
	public List<Basic> findByOwner() 
	{
		User currentUser = userService.getCurrentUser();
		return basicRepository.findByOwner(currentUser);
	}
	
	@Transactional
	public void save(Basic theBasic)
	{
		User currentUser = userService.getCurrentUser();
		theBasic.setOwner(currentUser);
		basicRepository.save(theBasic);
	}
}
