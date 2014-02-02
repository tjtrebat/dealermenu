package net.dealermenu.web;

import net.dealermenu.domain.Dealerinformation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("login")
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("dealerInformation", new Dealerinformation());
		return "login";
	}

}
