package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.DealTemplate;
import net.dealermenu.service.DealTemplateService;
import net.dealermenu.service.DealerinformationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/dealtemplates")
@SessionAttributes("successMsg")
public class DealTemplateController {

	@Autowired
	DealTemplateService dealTemplateService;
	@Autowired
	private DealerinformationDao dealerinformationDao;

	@RequestMapping
	public String list(Model model, Principal principal) {
		DealTemplateForm dealTemplateForm = new DealTemplateForm();
		dealTemplateForm.setDealTemplates(dealerinformationDao
				.getDealTemplates(principal.getName()));
		model.addAttribute("dealTemplateForm", dealTemplateForm);
		return "dealtemplate/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(
			@ModelAttribute("templateForm") DealTemplateForm dealTemplateForm,
			Model model, Principal principal) {
		for (DealTemplate dealTemplate : dealTemplateForm.getDealTemplates()) {
			if (dealTemplate.getId() != null) {
				dealTemplateService.removeDealTemplate(dealerinformationDao
						.getDealTemplateByPrimaryKey(principal.getName(),
								dealTemplate.getId()).getId());
				model.addAttribute("successMsg",
						"Deal Template has been deleted successfully.");
			}
		}
		return "redirect:/dealers/dealtemplates";
	}

}
