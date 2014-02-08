package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.Fee;
import net.dealermenu.service.DealerinformationDao;
import net.dealermenu.service.FeeService;

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
@RequestMapping("/dealer/defaultSettings/fees")
@SessionAttributes("successMsg")
public class FeeController {

	@Autowired
	private FeeService feeService;
	@Autowired
	private DealerinformationDao dealerinformationDao;

	@RequestMapping
	public String list(Model model, Principal principal) {
		FeeForm feeForm = new FeeForm();
		feeForm.setFees(dealerinformationDao.getFees(principal.getName()));
		model.addAttribute("feeForm", feeForm);
		return "fee/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(@ModelAttribute("feeForm") FeeForm feeForm, Model model,
			Principal principal) {
		for (Fee fee : feeForm.getFees()) {
			if (fee.getId() != null) {
				feeService.removeFee(dealerinformationDao.getFeeByPrimaryKey(
						principal.getName(), fee.getId()).getId());
				model.addAttribute("successMsg",
						"Fees were deleted successfully");
			}
		}
		return "redirect:/dealer/defaultSettings/fees";
	}

	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("fee", new Fee());
		return "fee/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("fee") @Valid Fee fee,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("fee", fee);
			return "fee/create";
		}
		dealerinformationDao.addFee(principal.getName(), fee);
		model.addAttribute("successMsg", "Fees were created successfully");
		return "redirect:/dealer/defaultSettings/fees";
	}

	@RequestMapping("/update/{primaryKey}")
	public String update(@PathVariable Long primaryKey, Model model,
			Principal principal) {
		Fee fee = dealerinformationDao.getFeeByPrimaryKey(principal.getName(),
				primaryKey);
		model.addAttribute("fee", fee);
		return "fee/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("fee") @Valid Fee fee,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("fee", fee);
			return "fee/update";
		}
		Fee feeEntity = dealerinformationDao.getFeeByPrimaryKey(
				principal.getName(), fee.getId());
		BeanUtils.copyProperties(fee, feeEntity, new String[] { "id",
				"version", "dealer" });
		feeService.updateFee(feeEntity);
		model.addAttribute("successMsg", "Fees were updated successfully");
		return "redirect:/dealer/defaultSettings/fees";
	}

}
