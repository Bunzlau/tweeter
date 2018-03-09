package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.model.Tweet;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	TweetRepository tweetRepository;
	
	@GetMapping("/add")
	public String addTweet(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "form/tweet";
	}
	
	@PostMapping("/add")
	public String postAddTweet(@Valid Tweet tweet, BindingResult result) {
		if(result.hasErrors()) {
			return "form/tweet";
		}
		return "";
	}
}
