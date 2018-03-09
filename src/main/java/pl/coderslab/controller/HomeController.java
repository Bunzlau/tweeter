package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.model.User;

@Controller
public class HomeController {

	@RequestMapping("")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "form/user";
	}
	
	

}
