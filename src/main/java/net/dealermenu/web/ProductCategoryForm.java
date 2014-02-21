package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.ProductCategory;

public class ProductCategoryForm extends CheckboxListForm {

	private List<ProductCategory> productCategories;

	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (ProductCategory productCategory : productCategories)
			checkboxes.put(productCategory.getId(), false);
		super.setCheckboxes(checkboxes);
		this.productCategories = productCategories;
	}
}
