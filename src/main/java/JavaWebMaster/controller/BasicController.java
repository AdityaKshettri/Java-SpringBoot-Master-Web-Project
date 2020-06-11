package JavaWebMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JavaWebMaster.entity.Basic;
import JavaWebMaster.service.BasicService;

@Controller
@RequestMapping("/basic")
public class BasicController 
{
	@Autowired
	private BasicService basicService;
	
	@GetMapping("/list")
	public String listBasics(Model model)
	{
		model.addAttribute("basics", basicService.findByOwner());
		return "basic-list";
	}
	
	@GetMapping("/formForAdd")
	public String formForAdd(Model model)
	{
		Basic theBasic = new Basic();
		model.addAttribute("theBasic", theBasic);
		return "basic-form";
	}
	
	@PostMapping("/save")
	public String saveBasic(@ModelAttribute("theBasic") Basic theBasic)
	{
		basicService.save(theBasic);
		return "redirect:/basic/list";
	}
}
