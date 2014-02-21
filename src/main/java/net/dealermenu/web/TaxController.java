package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.Tax;
import net.dealermenu.service.DealerService;
import net.dealermenu.service.TaxService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/defaultSettings/taxes")
@SessionAttributes("successMsg")
public class TaxController {

	@Autowired
	TaxService taxService;
	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		TaxForm taxForm = new TaxForm();
		taxForm.setTaxes(dealerService.getTaxes(principal.getName()));
		model.addAttribute("taxForm", taxForm);
		return "tax/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(@ModelAttribute("taxForm") TaxForm taxForm, Model model,
			Principal principal) {
		for (Long taxId : taxForm.getSelectedIds()) {
			Tax tax = dealerService.getTaxByPrimaryKey(principal.getName(),
					taxId);
			taxService.removeTax(tax.getId());
			model.addAttribute("successMsg", "Taxes were deleted successfully");
		}
		return "redirect:/dealer/defaultSettings/taxes";
	}

	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("tax", new Tax());
		return "tax/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("tax") @Valid Tax tax,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("tax", tax);
			return "tax/create";
		}
		dealerService.addTax(principal.getName(), tax);
		model.addAttribute("successMsg", "Taxes were created successfully");
		return "redirect:/dealer/defaultSettings/taxes";
	}

	@RequestMapping("/update/{primaryKey}")
	public String update(@PathVariable Long primaryKey, Model model,
			Principal principal) {
		Tax tax = dealerService.getTaxByPrimaryKey(principal.getName(),
				primaryKey);
		model.addAttribute("tax", tax);
		return "tax/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("tax") @Valid Tax tax,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("tax", tax);
			return "tax/update";
		}
		Tax taxEntity = dealerService.getTaxByPrimaryKey(principal.getName(),
				tax.getId());
		BeanUtils.copyProperties(tax, taxEntity, new String[] { "id",
				"version", "dealer" });
		taxService.updateTax(taxEntity);
		model.addAttribute("successMsg", "Taxes were updated successfully");
		return "redirect:/dealer/defaultSettings/taxes";
	}

}
