package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.ProductCategory;
import net.dealermenu.service.DealerService;
import net.dealermenu.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dealer/defaultSettings/productCategory")
@SessionAttributes("successMsg")
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	private DealerService dealerService;

	@RequestMapping
	public String list(Model model, Principal principal) {
		model.addAttribute("productCategory", new ProductCategory());
		ProductCategoryForm productCategoryForm = new ProductCategoryForm();
		productCategoryForm.setProductCategories(dealerService
				.getProductCategories(principal.getName()));
		model.addAttribute("productCategoryForm", productCategoryForm);
		return "productCategory/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(
			@ModelAttribute("productCategoryForm") ProductCategoryForm productCategoryForm,
			Model model, Principal principal) {
		for (Long productCategoryId : productCategoryForm.getSelectedIds()) {
			ProductCategory productCategory = dealerService
					.getProductCategoryByPrimaryKey(principal.getName(),
							productCategoryId);
			productCategoryService.removeProductCategory(productCategory
					.getId());
			model.addAttribute("successMsg",
					"Product category was deleted successfully.");
		}
		return "redirect:/dealer/defaultSettings/productCategory";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(
			@ModelAttribute("productCategory") @Valid ProductCategory productCategory,
			BindingResult bindingResult, Model model, Principal principal) {
		// display the form again if there are errors
		if (bindingResult.hasErrors()) {
			// add dealer bean model attribute
			model.addAttribute("productCategory", productCategory);
			return "productCategory/list";
		}
		dealerService.addProductCategory(principal.getName(), productCategory);
		model.addAttribute("successMsg",
				"Product category was created successfully.");
		return "redirect:/dealer/defaultSettings/productCategory";
	}

}
