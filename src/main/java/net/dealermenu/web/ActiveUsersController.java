package net.dealermenu.web;

import net.dealermenu.domain.Dealer;
import net.dealermenu.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/activeUsers")
@SessionAttributes("successMsg")
public class ActiveUsersController {

	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String activeUsers(Model model) {
		Dealer dealer = new Dealer();
		model.addAttribute("dealer", dealer);
		return "dealer/activeUsers";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String activeUsers(@ModelAttribute("dealer") Dealer dealer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("dealer", dealer);
			return "dealer/activeUsers";
		}
		if (checkAvailability(dealer.getLoginId()))
			model.addAttribute("successMsg", "Login Id is available");
		else {
			bindingResult.addError(new ObjectError("loginId",
					"Sorry, that Login Id already exists."));
			return "dealer/activeUsers";
		}
		return "redirect:/dealer/activeUsers";
	}

	public boolean checkAvailability(String loginId) {
		if (dealerService.getDealerByLoginId(loginId) == null)
			return true;
		else
			return false;
	}

}
