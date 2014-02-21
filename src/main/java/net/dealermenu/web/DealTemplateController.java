package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.DealTemplate;
import net.dealermenu.service.DealTemplateService;
import net.dealermenu.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	private DealerService dealerService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		DealTemplateForm dealTemplateForm = new DealTemplateForm();
		dealTemplateForm.setDealTemplates(dealerService
				.getDealTemplates(principal.getName()));
		model.addAttribute("dealTemplateForm", dealTemplateForm);
		return "dealtemplate/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(
			@ModelAttribute("templateForm") DealTemplateForm dealTemplateForm,
			Model model, Principal principal) {
		for (Long dealTemplateId : dealTemplateForm.getSelectedIds()) {
			DealTemplate dealTemplate = dealerService
					.getDealTemplateByPrimaryKey(principal.getName(),
							dealTemplateId);
			dealTemplateService.removeDealTemplate(dealTemplate.getId());
			model.addAttribute("successMsg",
					"Deal Template has been deleted successfully.");
		}
		return "redirect:/dealer/dealtemplates";
	}

	@RequestMapping(value = "/info/{primaryKey}")
	public String dealTemplateInfo(@PathVariable Long primaryKey, Model model,
			Principal principal) {
		DealTemplate dealTemplate = dealerService.getDealTemplateByPrimaryKey(
				principal.getName(), primaryKey);
		model.addAttribute("packageTypes",
				dealTemplateService.getPackageTypes(dealTemplate.getId()));
		model.addAttribute("fees",
				dealTemplateService.getFees(dealTemplate.getId()));
		return "dealtemplate/info";
	}
}
