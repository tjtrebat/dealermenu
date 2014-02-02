package net.dealermenu.web;

import java.security.Principal;

import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.Template;
import net.dealermenu.service.DealerinformationDao;
import net.dealermenu.service.ProductService;
import net.dealermenu.service.TemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("dealer")
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	private ProductService productService;
	@Autowired
	private DealerinformationDao dealerinformationDao;
	@Autowired
	TemplateService templateService;

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
				//productService.removeProduct(product);
			}
		}
		return "redirect:/dealer/defaultSettings/products";
	}

	@RequestMapping("/defaultSettings/packages")
	public String packages() {
		return "dealer/defaultSettings/packages";
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
	public String productCategory() {
		return "dealer/defaultSettings/productCategory";
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
