package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.service.DealerinformationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer")
@SessionAttributes("successMsg")
public class DealerController {

	@Autowired
	private DealerinformationDao dealerinformationDao;

	@RequestMapping({ "", "/deals" })
	public String deals(Model model, Principal principal) {
		//Dealerinformation dealer = dealerinformationDao
		//		.getDealerByLoginId(principal.getName());
		return "dealer/deals";
	}

	@RequestMapping("/activeUsers")
	public String activeUsers() {
		return "dealer/activeUsers";
	}

}
