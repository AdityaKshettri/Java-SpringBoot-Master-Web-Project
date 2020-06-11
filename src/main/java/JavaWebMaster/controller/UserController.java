package JavaWebMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JavaWebMaster.entity.User;
import JavaWebMaster.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login(Model model) 
	{
		User theUser = new User();
		model.addAttribute("theUser", theUser);
		return "user-login-form";
	}
	
	@GetMapping("/signup")
	public String signUp(Model model)
	{
		User theUser = new User();
		model.addAttribute("theUser", theUser);
		//model.addAttribute("userRoles", getUserRoles());
		return "user-signup-form";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute("theUser") User theUser)
	{
		userService.save(theUser);
		return "redirect:/user/login";
	}
	
	/*
	@ModelAttribute("userRoles")
	public List<String> getUserRoles()
	{
		List<String> userRoles = new ArrayList<String>();
		userRoles.add("ADMIN");
		userRoles.add("USER");
		return userRoles;
	}
	*/
}
