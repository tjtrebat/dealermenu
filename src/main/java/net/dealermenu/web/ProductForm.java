package net.dealermenu.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Product;

public class ProductForm extends CheckboxListForm implements Serializable {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Product product : products)
			checkboxes.put(product.getId(), false);
		super.setCheckboxes(checkboxes);
		this.products = products;
	}

	public List<Product> getSelectedProducts() {
		List<Product> selectedProducts = new ArrayList<Product>();
		for (Product product : getProducts())
			if (super.getSelectedIds().contains(product.getId()))
				selectedProducts.add(product);
		return selectedProducts;
	}
	
	public void selectProducts(List<Product> selectedProducts) {
		for (Product product : selectedProducts)
			super.getCheckboxes().put(product.getId(), true);
	}

}
