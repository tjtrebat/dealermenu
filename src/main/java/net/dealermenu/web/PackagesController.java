package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.PackageType;
import net.dealermenu.domain.Packages;
import net.dealermenu.service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/defaultSettings/packages")
@SessionAttributes("successMsg")
public class PackagesController {

	@Autowired
	private DealerService dealerService;

	@RequestMapping({ "", "/update" })
	public String update(Model model, Principal principal) {
		Packages packages = dealerService.getDealerByLoginId(
				principal.getName()).getPackages();
		if (packages == null)
			packages = new Packages();
		model.addAttribute("packages", packages);
		return "packages/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("packageType") int packageType,
			@RequestParam("alternateLanguage") String alternateLanguage,
			Model model, Principal principal) {
		Dealer dealer = dealerService.getDealerByLoginId(principal.getName());
		if (dealer.getPackages() == null) {
			Packages packages = new Packages();
			packages.setDealer(dealer);
			dealer.setPackages(packages);
		}
		switch (PackageType.values()[packageType]) {
		case PREFERRED:
			dealer.getPackages().setPreferredPackageName(alternateLanguage);
			break;
		case PREMIUM:
			dealer.getPackages().setPremiumPackageName(alternateLanguage);
			break;
		case VALUE:
			dealer.getPackages().setValuePackageName(alternateLanguage);
			break;
		case ECONOMY:
			dealer.getPackages().setEconomyPackageName(alternateLanguage);
			break;
		}
		dealerService.updateDealer(dealer);
		return "redirect:/dealer/defaultSettings/packages";
	}
}
