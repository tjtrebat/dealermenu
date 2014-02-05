package net.dealermenu.service;

import java.util.List;

import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;

public interface ProductCategoryService {

	public void removeProduct(ProductCategory productCategory, Product product);

	public ProductCategory getProductCategoryByPrimaryKey(Integer id);

	public void removeProduct(Product product);

	public List<ProductCategory> getProductCategoriesByLoginId(String loginId);
	
	public void removeProductCategory(Long primaryKey);
}
