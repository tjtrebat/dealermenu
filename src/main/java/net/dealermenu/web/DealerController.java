package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.service.DealerService;

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
	private DealerService dealerService;

	@RequestMapping("/activeUsers")
	public String activeUsers() {
		return "dealer/activeUsers";
	}

}
