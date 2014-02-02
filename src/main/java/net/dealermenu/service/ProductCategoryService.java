package net.dealermenu.service;

import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;

public interface ProductCategoryService {

	public void removeProduct(ProductCategory productCategory, Product product);

	public ProductCategory getProductCategoryByPrimaryKey(Integer id);

	public void removeProduct(Product product);
}
