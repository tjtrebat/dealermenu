package net.dealermenu.service;

import net.dealermenu.domain.Product;

public interface ProductService {

	public void removeProduct(Long primaryKey);

	public Product updateProduct(Product product);
	
	public Product findProduct(Long primaryKey);

}
