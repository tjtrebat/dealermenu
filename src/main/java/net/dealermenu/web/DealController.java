package net.dealermenu.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.PackageType;
import net.dealermenu.domain.Product;
import net.dealermenu.service.DealService;
import net.dealermenu.service.DealTemplateService;
import net.dealermenu.service.DealerService;

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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping({ "/dealer", "/dealer/deals" })
@SessionAttributes("successMsg")
public class DealController {

	@Autowired
	private DealerService dealerService;
	@Autowired
	private DealTemplateService dealTemplateService;
	@Autowired
	private DealService dealService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		// add DealTemplateForm to model
		DealTemplateForm dealTemplateForm = new DealTemplateForm();
		dealTemplateForm.setDealTemplates(dealerService
				.getDealTemplates(principal.getName()));
		model.addAttribute("dealTemplateForm", dealTemplateForm);
		// add DealForm to model
		DealForm dealForm = new DealForm();
		dealForm.setDeals(dealerService.getDeals(principal.getName()));
		model.addAttribute("dealForm", dealForm);
		return "deal/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(@ModelAttribute("dealForm") DealForm dealForm,
			Model model, Principal principal) {
		for (Long dealId : dealForm.getSelectedIds()) {
			Deal deal = dealerService.getDealByPrimaryKey(principal.getName(),
					dealId);
			dealService.removeDeal(deal.getId());
			model.addAttribute("successMsg", "Deals were deleted successfully");
		}
		return "redirect:/dealer/deals";
	}

	@RequestMapping(value = "/update/{primaryKey}")
	public String update(@PathVariable Long primaryKey, Model model,
			Principal principal) {
		Deal deal = dealerService.getDealByPrimaryKey(principal.getName(),
				primaryKey);
		deal.setProductValues(dealService.getProductValues(deal.getId()));
		deal.setSelectedProducts(new HashMap<Long, Boolean>());
		deal.setProductValuesKeyedById(new HashMap<Long, Double>());
		for (Entry<Product, Double> entry : deal.getProductValues().entrySet()) {
			deal.getSelectedProducts().put(entry.getKey().getId(), true);
			deal.getProductValuesKeyedById().put(entry.getKey().getId(),
					entry.getValue());
		}
		Set<Product> products = dealTemplateService.getPackageTypes(
				deal.getDealTemplate().getId()).keySet();
		setSelectedProducts(deal, products);
		setProductValuesKeyedById(deal, products);
		model.addAttribute("deal", deal);
		model.addAttribute("taxes", dealerService.getTaxes(principal.getName()));
		model.addAttribute(
				"products",
				getDealTemplateProductsByPackageType(deal.getDealTemplate()
						.getId(), deal.getPackageType()));
		model.addAttribute("packageTypes", PackageType.values());
		switch (deal.getDealTemplate().getType()) {
		case FINANCE:
			return "deal/finance/update";
		case LEASE:
			return "deal/lease/update";
		case CASH:
			break;
		}
		return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("deal") @Valid Deal deal,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			Set<Product> products = dealTemplateService.getPackageTypes(
					deal.getDealTemplate().getId()).keySet();
			setSelectedProducts(deal, products);
			setProductValuesKeyedById(deal, products);
			model.addAttribute("deal", deal);
			model.addAttribute("taxes",
					dealerService.getTaxes(principal.getName()));
			model.addAttribute(
					"products",
					getDealTemplateProductsByPackageType(deal.getDealTemplate()
							.getId(), deal.getPackageType()));
			model.addAttribute("packageTypes", PackageType.values());
			switch (deal.getDealTemplate().getType()) {
			case FINANCE:
				return "deal/finance/update";
			case LEASE:
				return "deal/lease/update";
			case CASH:
				break;
			default:
				return null;
			}
		}
		Map<Product, Double> productValues = new HashMap<Product, Double>();
		for (Long productId : deal.getSelectedProducts().keySet())
			if (deal.getSelectedProducts().get(productId) != null)
				productValues.put(dealerService.getProductByPrimaryKey(
						principal.getName(), productId), deal
						.getProductValuesKeyedById().get(productId));
		deal.setProductValues(productValues);
		Deal dealEntity = dealerService.getDealByPrimaryKey(
				principal.getName(), deal.getId());
		BeanUtils.copyProperties(deal, dealEntity, new String[] { "id",
				"version", "dealTemplate" });
		dealerService.updateDeal(principal.getName(), deal.getDealTemplate()
				.getId(), dealEntity);
		return "redirect:/dealer/deals";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(
			@ModelAttribute("dealTemplateForm") DealTemplateForm dealTemplateForm,
			Model model, Principal principal) {
		for (DealTemplate dealTemplate : dealTemplateForm.getDealTemplates()) {
			Deal deal = new Deal();
			deal.setDealTemplate(dealerService.getDealTemplateByPrimaryKey(
					principal.getName(), dealTemplate.getId()));
			deal.setFees(dealTemplateService.getSumOfFeeValues(dealTemplate
					.getId()));
			Set<Product> products = dealTemplateService.getPackageTypes(
					deal.getDealTemplate().getId()).keySet();
			setSelectedProducts(deal, products);
			setProductValuesKeyedById(deal, products);
			model.addAttribute("deal", deal);
			model.addAttribute("taxes",
					dealerService.getTaxes(principal.getName()));
			model.addAttribute(
					"products",
					getDealTemplateProductsByPackageType(dealTemplate.getId(),
							PackageType.values()[0]));
			model.addAttribute("packageTypes", PackageType.values());
			switch (deal.getDealTemplate().getType()) {
			case FINANCE:
				return "deal/finance/create";
			case LEASE:
				return "deal/lease/create";
			case CASH:
				break;
			}
			break;
		}
		return null;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("deal") @Valid Deal deal,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			Set<Product> products = dealTemplateService.getPackageTypes(
					deal.getDealTemplate().getId()).keySet();
			setSelectedProducts(deal, products);
			setProductValuesKeyedById(deal, products);
			model.addAttribute("deal", deal);
			model.addAttribute("taxes",
					dealerService.getTaxes(principal.getName()));
			model.addAttribute(
					"products",
					getDealTemplateProductsByPackageType(deal.getDealTemplate()
							.getId(), deal.getPackageType()));
			model.addAttribute("packageTypes", PackageType.values());
			switch (deal.getDealTemplate().getType()) {
			case FINANCE:
				return "deal/finance/create";
			case LEASE:
				return "deal/lease/create";
			case CASH:
				break;
			default:
				return null;
			}
		}
		Map<Product, Double> productValues = new HashMap<Product, Double>();
		for (Long productId : deal.getSelectedProducts().keySet())
			if (deal.getSelectedProducts().get(productId) != null)
				productValues.put(dealerService.getProductByPrimaryKey(
						principal.getName(), productId), deal
						.getProductValuesKeyedById().get(productId));
		deal.setProductValues(productValues);
		dealerService.addDeal(principal.getName(), deal.getDealTemplate()
				.getId(), deal);
		return "redirect:/dealer/deals";
	}

	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public String getProductList(@RequestParam Long dealTemplateId,
			@RequestParam int index, @RequestParam Deal deal, Model model,
			Principal principal) {
		DealTemplate dealTemplate = dealerService.getDealTemplateByPrimaryKey(
				principal.getName(), dealTemplateId);
		if (deal != null) {
			deal.setProductValues(dealService.getProductValues(deal.getId()));
			deal.setSelectedProducts(new HashMap<Long, Boolean>());
			deal.setProductValuesKeyedById(new HashMap<Long, Double>());
			for (Entry<Product, Double> entry : deal.getProductValues()
					.entrySet()) {
				deal.getSelectedProducts().put(entry.getKey().getId(), true);
				deal.getProductValuesKeyedById().put(entry.getKey().getId(),
						entry.getValue());
			}
		} else
			deal = new Deal();
		Set<Product> products = getDealTemplateProductsByPackageType(
				dealTemplate.getId(), PackageType.values()[index]);
		setSelectedProducts(deal, products);
		setProductValuesKeyedById(deal, products);
		model.addAttribute("deal", deal);
		model.addAttribute("products", products);
		return "deal/productList";
	}

	public Set<Product> getDealTemplateProductsByPackageType(
			Long dealTemplateId, PackageType packageType) {
		Set<Product> products = new HashSet<Product>();
		for (Entry<Product, PackageEntry> entry : dealTemplateService
				.getPackageTypes(dealTemplateId).entrySet()) {
			if (packageEntryContainsPackageType(entry.getValue(), packageType))
				products.add(entry.getKey());
		}
		return products;
	}

	public boolean packageEntryContainsPackageType(PackageEntry packageEntry,
			PackageType packageType) {
		boolean contains = false;
		switch (packageType) {
		case PREFERRED:
			if (packageEntry.getIsPreferred())
				contains = true;
			break;
		case PREMIUM:
			if (packageEntry.getIsPremium())
				contains = true;
			break;
		case VALUE:
			if (packageEntry.getIsValue())
				contains = true;
			break;
		case ECONOMY:
			if (packageEntry.getIsEconomy())
				contains = true;
			break;
		}
		return contains;
	}

	public void setSelectedProducts(Deal deal, Set<Product> products) {
		Map<Long, Boolean> selectedProducts = new HashMap<Long, Boolean>();
		for (Product product : products) {
			boolean isSelected = false;
			if (deal.getSelectedProducts() != null
					&& deal.getSelectedProducts().get(product.getId()) != null)
				isSelected = true;
			selectedProducts.put(product.getId(), isSelected);
		}
		deal.setSelectedProducts(selectedProducts);
	}

	public void setProductValuesKeyedById(Deal deal, Set<Product> products) {
		Map<Long, Double> productValuesKeyedById = new HashMap<Long, Double>();
		for (Product product : products) {
			double productValue = product.getDefaultPrice();
			if (deal.getProductValuesKeyedById() != null
					&& deal.getProductValuesKeyedById().get(product.getId()) != null)
				productValue = deal.getProductValuesKeyedById().get(
						product.getId());
			productValuesKeyedById.put(product.getId(), productValue);
		}
		deal.setProductValuesKeyedById(productValuesKeyedById);
	}

}
