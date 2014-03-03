package net.dealermenu.web;

import javax.validation.Valid;

import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.DealerStatus;
import net.dealermenu.domain.UserRoles;
import net.dealermenu.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/registration")
@SessionAttributes("successMsg")
public class RegistrationController {

	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String registration(Model model) {
		Dealer dealer = new Dealer();
		model.addAttribute("dealer", dealer);
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registration(@ModelAttribute("dealer") @Valid Dealer dealer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("dealer", dealer);
			return "registration";
		}
		dealer.setStatus(DealerStatus.AWAITING);
		dealer.setUserType(UserRoles.ROLE_USER);
		dealerService.saveDealer(dealer);
		model.addAttribute("successMsg",
				"Dealer registration completed successfully. "
						+ "Username and password will be sent to your "
						+ "e-mail address after verification");
		return "redirect:/";
	}
}
