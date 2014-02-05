package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.domain.PackageType;
import net.dealermenu.domain.Packages;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;
import net.dealermenu.domain.Template;
import net.dealermenu.service.DealerinformationDao;
import net.dealermenu.service.ProductCategoryService;
import net.dealermenu.service.ProductService;
import net.dealermenu.service.TemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("dealer")
@RequestMapping("/dealer")
@SessionAttributes("successMsg")
public class DealerController {

	@Autowired
	private ProductService productService;
	@Autowired
	private DealerinformationDao dealerinformationDao;
	@Autowired
	TemplateService templateService;
	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping({ "", "/deals" })
	public String deals(Model model, Principal principal) {
		Dealerinformation dealer = dealerinformationDao
				.getDealerByLoginId(principal.getName());
		return "dealer/deals";
	}

	@RequestMapping({ "/defaultSettings", "/defaultSettings/products" })
	public String products(Model model, Principal principal) {
		ProductForm productForm = new ProductForm();
		productForm.setProducts(productService.findProductsByLoginId(principal
				.getName()));
		model.addAttribute("productForm", productForm);
		return "dealer/defaultSettings/products";
	}

	@RequestMapping(value = "/defaultSettings/products", method = RequestMethod.POST)
	public String products(
			@ModelAttribute("productForm") ProductForm productForm, Model model) {
		for (Product product : productForm.getProducts()) {
			if (product.getId() != null) {
				System.out.println("Removing product " + product.getId());
				// productService.removeProduct(product);
			}
		}
		return "redirect:/dealer/defaultSettings/products";
	}

	@RequestMapping("/defaultSettings/createProduct")
	public String createProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "dealer/defaultSettings/createProduct";
	}

	@RequestMapping(value = "/defaultSettings/createProduct", method = RequestMethod.POST)
	public String createProduct(
			@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "dealer/defaultSettings/createProduct";
		}
		productService.saveProduct(product);
		model.addAttribute("successMsg", "Product was created successfully.");
		return "redirect:/dealer/defaultSettings/createProduct";
	}

	@RequestMapping("/defaultSettings/packages")
	public String packages(Model model, Principal principal) {
		Packages packages = dealerinformationDao.getDealerByLoginId(
				principal.getName()).getPackages();
		if (packages == null)
			packages = new Packages();
		model.addAttribute("packages", packages);
		return "dealer/defaultSettings/packages";
	}

	@RequestMapping(value = "/defaultSettings/packages", method = RequestMethod.POST)
	public String packages(@RequestParam("packageType") int packageType,
			@RequestParam("alternateLanguage") String alternateLanguage,
			Model model, Principal principal) {
		Dealerinformation dealer = dealerinformationDao
				.getDealerByLoginId(principal.getName());
		Packages packages = dealer.getPackages();
		if (packages == null)
			packages = new Packages();
		switch (PackageType.values()[packageType]) {
		case PREFERRED:
			packages.setPreferredPackageName(alternateLanguage);
			break;
		case PREMIUM:
			packages.setPremiumPackageName(alternateLanguage);
			break;
		case VALUE:
			packages.setValuePackageName(alternateLanguage);
			break;
		case ECONOMY:
			packages.setEconomyPackageName(alternateLanguage);
			break;
		}
		dealer.setPackages(packages);
		dealerinformationDao.updateDealer(dealer);
		model.addAttribute("packages", dealer.getPackages());
		return "redirect:/dealer/defaultSettings/packages";
	}

	@RequestMapping("/defaultSettings/fees")
	public String fees() {
		return "dealer/defaultSettings/fees";
	}

	@RequestMapping("/defaultSettings/taxes")
	public String taxes() {
		return "dealer/defaultSettings/taxes";
	}

	@RequestMapping("/defaultSettings/productCategory")
	public String productCategory(Model model, Principal principal) {
		ProductCategoryForm productCategoryForm = new ProductCategoryForm();
		productCategoryForm.setProductCategories(productCategoryService
				.getProductCategoriesByLoginId(principal.getName()));
		model.addAttribute("productCategoryForm", productCategoryForm);
		model.addAttribute("productCategory", new ProductCategory());
		return "dealer/defaultSettings/productCategory";
	}

	@RequestMapping(value = "/defaultSettings/productCategory", method = RequestMethod.POST)
	public String productCategory(
			@ModelAttribute("productCategoryForm") ProductCategoryForm productCategoryForm,
			Model model, Principal principal) {
		for (ProductCategory productCategory : productCategoryForm
				.getProductCategories()) {
			if (productCategory.getId() != null) {
				productCategoryService.removeProductCategory(productCategory
						.getId());
			}
		}
		model.addAttribute("successMsg",
				"Product categories have been deleted successfully.");
		return "redirect:/dealer/defaultSettings/productCategory";
	}

	@RequestMapping(value = "/defaultSettings/createProductCategory", method = RequestMethod.POST)
	public String createProductCategory(
			@ModelAttribute("productCategory") @Valid ProductCategory productCategory,
			BindingResult bindingResult, Model model, Principal principal) {
		// display the form again if there are errors
		if (bindingResult.hasErrors()) {
			// add dealer bean model attribute
			model.addAttribute("productCategory", productCategory);
			return "dealer/defaultSettings/productCategory";
		}
		dealerinformationDao.addProductCategory(principal.getName(),
				productCategory);
		model.addAttribute("successMsg",
				"Product category was created successfully.");
		return "redirect:/dealer/defaultSettings/productCategory";
	}

	@RequestMapping("/defaultSettings/provider")
	public String provider() {
		return "dealer/defaultSettings/provider";
	}

	@RequestMapping("/dealTemplates")
	public String dealTemplates(Model model, Principal principal) {
		Dealerinformation dealer = dealerinformationDao
				.getDealerByLoginId(principal.getName());
		TemplateForm templateForm = new TemplateForm();
		templateForm.setTemplates(dealer.getTemplates());
		model.addAttribute("templateForm", templateForm);
		return "dealer/dealTemplates";
	}

	@RequestMapping(value = "/dealTemplates", method = RequestMethod.POST)
	public String dealTemplates(
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
		return "redirect:/admin/dealers/dealTemplates";
	}

	/*
	 * @RequestMapping(value = "/dealTemplates/{primaryKey}", method =
	 * RequestMethod.GET) public String dealTemplates(@PathVariable Integer
	 * primaryKey, Model model) { return "dealer/dealTemplates/templateInfo"; }
	 */

	@RequestMapping("/activeUsers")
	public String activeUsers() {
		return "dealer/activeUsers";
	}

}
