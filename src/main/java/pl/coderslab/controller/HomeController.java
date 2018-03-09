package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.repository.TweetRepository;

@Controller
public class HomeController {
	@Autowired
	TweetRepository tweetRepository;
	
	@RequestMapping("")
	public String homepage(Model model) {
		model.addAttribute("tweets", tweetRepository.findAllTweetsOrderByreatedDesc());
		return "homePage";
	}
	
	

}
