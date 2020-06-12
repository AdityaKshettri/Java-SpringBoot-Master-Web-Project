package JavaWebMaster.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JavaWebMaster.entity.Basic;
import JavaWebMaster.service.BasicService;
import JavaWebMaster.service.UserService;

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
		return "basic-add-form";
	}
	
	@GetMapping("/formForEdit/{id}")
	public String formForEdit(@PathVariable("id") int id, Model model)
	{
		Optional<Basic> theBasic = basicService.findById(id);
		model.addAttribute("theBasic", theBasic);
		model.addAttribute("theId", id);
		return "basic-edit-form";
	}
	
	@PostMapping("/save")
	public String saveBasic(@ModelAttribute("theBasic") Basic theBasic)
	{
		basicService.save(theBasic);
		return "redirect:/basic/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		basicService.deleteById(id);
		return "redirect:/basic/list";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute("theBasic") Basic theBasic, @PathVariable("id") int id)
	{
		theBasic.setId(id);
		basicService.save(theBasic);
		return "redirect:/basic/list";
	}
}
