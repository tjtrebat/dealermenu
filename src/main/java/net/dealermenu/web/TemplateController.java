package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.domain.Template;
import net.dealermenu.service.DealerinformationDao;
import net.dealermenu.service.TemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/dealer/templates")
@SessionAttributes("successMsg")
public class TemplateController {

	@Autowired
	TemplateService templateService;
	@Autowired
	private DealerinformationDao dealerinformationDao;
	
	@RequestMapping
	public String list(Model model, Principal principal) {
		Dealerinformation dealer = dealerinformationDao
				.getDealerByLoginId(principal.getName());
		TemplateForm templateForm = new TemplateForm();
		templateForm.setTemplates(dealer.getTemplates());
		model.addAttribute("templateForm", templateForm);
		return "template/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(
			@ModelAttribute("templateForm") TemplateForm templateForm,
			Model model) {
		for (Template template : templateForm.getTemplates()) {
			if (template.getId() != null) {
				templateService.removeTemplate(templateService
						.getTemplateByPrimaryKey(template.getId()));
				model.addAttribute("successMsg",
						"Template(s) has been deleted successfully.");
			}
		}
		return "redirect:/dealers/templates";
	}

	/*
	 * @RequestMapping(value = "/dealTemplates/{primaryKey}", method =
	 * RequestMethod.GET) public String dealTemplates(@PathVariable Integer
	 * primaryKey, Model model) { return "dealer/dealTemplates/templateInfo"; }
	 */

}
