package net.dealermenu.web;

import java.security.Principal;
import java.util.Set;

import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.UserRoles;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("login")
public class LoginController {

	@RequestMapping(value = { "", "/login" }, method = RequestMethod.GET)
	public String login(Model model, Principal principal) {
		if (principal != null) {
			Set<String> roles = AuthorityUtils
					.authorityListToSet(((Authentication) principal)
							.getAuthorities());
			if (roles.contains(UserRoles.ROLE_ADMIN))
				return "redirect:/admin";
			else if (roles.contains(UserRoles.ROLE_USER))
				return "redirect:/dealer";
		}
		model.addAttribute("dealer", new Dealer());
		return "login";
	}

}
