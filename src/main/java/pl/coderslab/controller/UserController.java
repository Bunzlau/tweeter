package pl.coderslab.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			System.out.println("walidacja nie przesz³a");
			return "form/user";
		}
		System.out.println("Walidacja przesz³a");
		userRepository.save(user);
		return "redirect:/";
	}

	private User getUser(String userName) {
		User user = null;
		try {
			user = userRepository.findOneByUserName(userName);
		} catch (Exception e) {

		}
		if (user == null) {
			try {
				user = userRepository.findOneByEmail(userName);
			} catch (Exception e) {

			}
		}
		return user;
	}
	
	@GetMapping("/login")
	public String showLogin()
	{
		return "/form/loginUser";
	}
	
	@PostMapping("/login")
	public String login(HttpSession sess, @RequestParam String userName, @RequestParam String password) {

		User user = getUser(userName);

		if (user != null && BCrypt.checkpw(password, user.getPassword())) {
			System.out.println("Zalogowany");
			sess.setAttribute("logged", true);
			return "redirect:/";
		}
		sess.setAttribute("logged", false);
		String message = "";
		try {
			message = URLEncoder.encode("b³êdny login lub has³o", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return "redirect:/user/login?message=" + message;
	}
}
