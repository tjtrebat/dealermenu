package net.dealermenu.service;

import java.util.List;

import net.dealermenu.domain.Product;

public interface ProductService {

	public void removeProduct(Product product);

	public List<Product> findProductsByLoginId(String name);
}
