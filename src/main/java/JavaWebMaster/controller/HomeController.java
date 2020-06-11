package JavaWebMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import JavaWebMaster.service.BasicService;
import JavaWebMaster.service.UserService;

@Controller
public class HomeController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasicService basicService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("authenticated", userService.isAuthenticated());
		model.addAttribute("basics", basicService.findAll());
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
