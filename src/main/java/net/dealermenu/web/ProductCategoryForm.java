package net.dealermenu.web;

import java.util.List;

import net.dealermenu.domain.ProductCategory;

public class ProductCategoryForm {

	private List<ProductCategory> productCategories;

	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}
}
