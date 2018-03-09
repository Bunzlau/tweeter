package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/register")
	public String registerShow(Model model) {
		model.addAttribute("user", new User());
		return "form/user";
	}

	@PostMapping("/register")
	public String registerSave(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "form/user";
		} 
		userRepository.save(user);
		return "redirect:";
	}
}
