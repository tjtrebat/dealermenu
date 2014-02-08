package net.dealermenu.web;

import java.security.Principal;

import javax.validation.Valid;

import net.dealermenu.domain.Product;
import net.dealermenu.domain.Provider;
import net.dealermenu.service.DealerinformationDao;
import net.dealermenu.service.ProductService;
import net.dealermenu.service.ProviderService;

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
@RequestMapping({ "/dealer/defaultSettings", "/dealer/defaultSettings/products" })
@SessionAttributes("successMsg")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProviderService providerService;
	@Autowired
	private DealerinformationDao dealerinformationDao;

	@RequestMapping
	public String list(Model model, Principal principal) {
		ProductForm productForm = new ProductForm();
		productForm.setProducts(dealerinformationDao.getProducts(principal
				.getName()));
		model.addAttribute("productForm", productForm);
		return "product/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(@ModelAttribute("productForm") ProductForm productForm,
			Model model, Principal principal) {
		for (Product product : productForm.getProducts()) {
			if (product.getId() != null) {
				productService.removeProduct(dealerinformationDao
						.getProductByPrimaryKey(principal.getName(),
								product.getId()).getId());
				model.addAttribute("successMsg",
						"Products were deleted successfully");
			}
		}
		return "redirect:/dealer/defaultSettings/products";
	}

	@RequestMapping("/create")
	public String create(Model model, Principal principal) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("providers",
				dealerinformationDao.getProviders(principal.getName()));
		model.addAttribute("productCategories",
				dealerinformationDao.getProductCategories(principal.getName()));
		return "product/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "product/create";
		}
		providerService.addProduct(
				dealerinformationDao.getProviderByPrimaryKey(
						principal.getName(), product.getProvider().getId())
						.getId(), product);
		model.addAttribute("successMsg", "Product was created successfully.");
		return "redirect:/dealer/defaultSettings/products";
	}

	@RequestMapping("/update/{primaryKey}")
	public String update(@PathVariable Long primaryKey, Model model,
			Principal principal) {
		Product product = dealerinformationDao.getProductByPrimaryKey(
				principal.getName(), primaryKey);
		model.addAttribute("product", product);
		model.addAttribute("providers",
				dealerinformationDao.getProviders(principal.getName()));
		model.addAttribute("productCategories",
				dealerinformationDao.getProductCategories(principal.getName()));
		return "product/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "product/update";
		}
		Provider provider = dealerinformationDao.getProviderByPrimaryKey(
				principal.getName(), product.getProvider().getId());
		Product productEntity = dealerinformationDao.getProductByPrimaryKey(
				principal.getName(), product.getId());
		productEntity.setProvider(provider);
		BeanUtils.copyProperties(product, productEntity, new String[] { "id",
				"version" });
		productService.updateProduct(productEntity);
		model.addAttribute("successMsg", "Product was updated successfully");
		return "redirect:/dealer/defaultSettings/products";
	}

}
