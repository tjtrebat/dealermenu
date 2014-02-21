package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.DealTemplate;
import net.dealermenu.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping({ "/dealer", "/dealer/deals" })
@SessionAttributes("successMsg")
public class DealController {

	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		DealTemplateForm dealTemplateForm = new DealTemplateForm();
		dealTemplateForm.setDealTemplates(dealerService
				.getDealTemplates(principal.getName()));
		model.addAttribute("dealTemplateForm", dealTemplateForm);
		return "deal/list";
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public String list(Model
	 * model, Principal principal) {
	 * 
	 * return "deal/list"; }
	 */

	@RequestMapping("/create")
	public String create(
			@ModelAttribute("dealTemplateForm") DealTemplateForm dealTemplateForm,
			Model model) {
		for (DealTemplate dealTemplate : dealTemplateForm.getDealTemplates())
			System.out.println(dealTemplate.getId());
		return "deal/create";
	}

}
