package net.dealermenu.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.service.DealerinformationDao;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Nick
 * 
 */
@Controller("admin")
@RequestMapping("/admin")
@SessionAttributes("successMsg")
public class AdminController {

	@Autowired
	private DealerinformationDao dealerinformationDao;

	@RequestMapping({ "", "/dealers/activeDealers" })
	public String activeDealers(Model model) {
		DealerForm dealerForm = new DealerForm();
		dealerForm.setDealers(dealerinformationDao
				.getDealersByStatus("ActiveDealers"));
		model.addAttribute("dealerForm", dealerForm);
		return "admin/activeDealers";
	}

	@RequestMapping(value = { "", "/dealers/activeDealers" }, method = RequestMethod.POST)
	public String activeDealers(
			@ModelAttribute("dealerForm") DealerForm dealerForm, Model model) {
		processDealerForm(dealerForm);
		model.addAttribute("successMsg", "Dealer has been denied successfully.");
		return "redirect:/admin/dealers/activeDealers";
	}

	@RequestMapping("/dealers/awaitingDealers")
	public String awaitingDealers(Model model) {
		DealerForm dealerForm = new DealerForm();
		dealerForm.setDealers(dealerinformationDao
				.getDealersByStatus("AwaitingDealers"));
		model.addAttribute("dealerForm", dealerForm);
		return "admin/awaitingDealers";
	}

	@RequestMapping(value = "/dealers/awaitingDealers", method = RequestMethod.POST)
	public String awaitingDealers(
			@ModelAttribute("dealerForm") DealerForm dealerForm, Model model) {
		processDealerForm(dealerForm);
		model.addAttribute("successMsg", "Dealer has been denied successfully.");
		return "redirect:/admin/dealers/awaitingDealers";
	}

	@RequestMapping(value = "/dealers/awaitingDealers/approve", method = RequestMethod.GET)
	public String approveDealer(@RequestParam("pk") Long primaryKey,
			Model model) {
		model.addAttribute("dealer",
				dealerinformationDao.getDealerByPrimaryKey(primaryKey));
		return "admin/approveDealer";
	}

	@RequestMapping(value = "/dealers/awaitingDealers/approve", method = RequestMethod.POST)
	public String approveDealer(
			@ModelAttribute("dealer") @Valid Dealerinformation dealer,
			BindingResult bindingResult, Model model) {

		// get Dealerinformation object using dealerName
		Dealerinformation dealerInformation = dealerinformationDao
				.getDealerByPrimaryKey(dealer.getId());

		BeanUtils.copyProperties(dealerInformation, dealer, new String[] {
				"loginId", "password" });

		// Check if the user name is already taken
		Dealerinformation dealerWithSameLogin = dealerinformationDao
				.getDealerByLoginId(dealer.getLoginId());
		if (dealerWithSameLogin != null
				&& !dealerWithSameLogin.getId().equals(dealer.getId()))
			// add an error message to the bindingResult
			bindingResult.rejectValue("loginId", "error.dealer",
					"Sorry, that Login Id already exists.");

		// display the form again if there are errors
		if (bindingResult.hasErrors()) {
			// add dealer bean model attribute
			model.addAttribute("dealer", dealer);
			return "admin/approveDealer";
		}

		dealer.setStatus("ActiveDealers");

		// merges the dealerInformation object into persistence context
		dealerinformationDao.updateDealer(dealer);

		model.addAttribute("successMsg", "Dealer was approved successfully.");

		return "redirect:/admin/dealers/activeDealers";
	}

	@RequestMapping(value = "/dealers/awaitingDealers/checkAvailability", method = RequestMethod.POST)
	public @ResponseBody
	String checkAvailability(@RequestParam String loginId) {
		String msg;
		String cssClass;
		if (dealerinformationDao.getDealerByLoginId(loginId) == null) {
			msg = "Login Id is available.";
			cssClass = "success";
		} else {
			msg = "Sorry, that Login Id already exists.";
			cssClass = "error";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", msg);
		map.put("cssClass", cssClass);
		ObjectMapper m = new ObjectMapper();
		String output = null;
		try {
			output = m.writeValueAsString(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}

	@RequestMapping("/dealers/deniedDealers")
	public String deniedDealers(Model model) {
		DealerForm dealerForm = new DealerForm();
		dealerForm.setDealers(dealerinformationDao
				.getDealersByStatus("DeniedDealers"));
		model.addAttribute("dealerForm", dealerForm);
		return "admin/deniedDealers";
	}

	@RequestMapping(value = "/dealers/deniedDealers", method = RequestMethod.POST)
	public String deniedDealers(
			@ModelAttribute("dealerForm") DealerForm dealerForm, Model model) {
		for (Dealerinformation dealer : dealerForm.getDealers()) {
			if (dealer.getId() != null) {
				dealerinformationDao.removeDealer(dealerinformationDao
						.getDealerByPrimaryKey(dealer.getId()));
				model.addAttribute("successMsg",
						"Dealer(s) has been deleted successfully.");
			}
		}
		return "redirect:/admin/dealers/deniedDealers";
	}

	@RequestMapping("/dealers/{primaryKey}")
	public String dealerInfo(@PathVariable Long primaryKey, Model model) {
		model.addAttribute("dealer",
				dealerinformationDao.getDealerByPrimaryKey(primaryKey));
		return "admin/dealerInfo";
	}

	@RequestMapping("/dealers/createDealer")
	public String createDealer(Model model) {
		Dealerinformation dealer = new Dealerinformation();
		model.addAttribute("dealer", dealer);
		return "admin/createDealer";
	}

	@RequestMapping(value = "/dealers/createDealer", method = RequestMethod.POST)
	public String createDealer(
			@ModelAttribute("dealer") @Valid Dealerinformation dealer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("dealer", dealer);
			return "admin/createDealer";
		}
		dealer.setStatus("AwaitingDealers");
		dealer.setUserType("ROLE_USER");
		dealerinformationDao.saveDealer(dealer);
		model.addAttribute("successMsg", "Dealer was created successfully.");
		return "redirect:/admin/dealers/createDealer";
	}

	/**
	 * Processes the checkbox input parameters set with values equal to the
	 * status ActiveDealers, AwaitingDealers, or DeniedDealers.
	 * 
	 * @param dealerForm
	 */
	public void processDealerForm(DealerForm dealerForm) {
		for (Dealerinformation dealer : dealerForm.getDealers()) {
			if (dealer.getStatus() != null) {
				Dealerinformation dealerInformation = dealerinformationDao
						.getDealerByPrimaryKey(dealer.getId());
				BeanUtils.copyProperties(dealerInformation, dealer,
						new String[] { "status" });
				dealerinformationDao.updateDealer(dealer);
			}
		}
	}

}
