package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.Provider;
import net.dealermenu.service.DealerService;
import net.dealermenu.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/defaultSettings/providers")
@SessionAttributes("successMsg")
public class ProviderController {

	@Autowired
	ProviderService providerService;
	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		model.addAttribute("provider", new Provider());
		ProviderForm providerForm = new ProviderForm();
		providerForm.setProviders(dealerService.getProviders(principal
				.getName()));
		model.addAttribute("providerForm", providerForm);
		return "provider/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(
			@ModelAttribute("providerForm") ProviderForm providerForm,
			Model model, Principal principal) {
		for (Long providerId : providerForm.getSelectedIds()) {
			Provider provider = dealerService.getProviderByPrimaryKey(
					principal.getName(), providerId);
			providerService.removeProvider(provider.getId());
			model.addAttribute("successMsg",
					"Provider was deleted successfully.");
		}
		return "redirect:/dealer/defaultSettings/providers";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("provider") @Valid Provider provider,
			BindingResult bindingResult, Model model, Principal principal) {
		// display the form again if there are errors
		if (bindingResult.hasErrors()) {
			// add dealer bean model attribute
			model.addAttribute("provider", provider);
			return "provider/list";
		}
		dealerService.addProvider(principal.getName(), provider);
		model.addAttribute("successMsg", "Provider was created successfully.");
		return "redirect:/dealer/defaultSettings/providers";
	}

}
