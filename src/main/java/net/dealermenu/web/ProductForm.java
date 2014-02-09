package net.dealermenu.web;

import java.io.Serializable;
import java.util.List;

import net.dealermenu.domain.Product;

public class ProductForm implements Serializable {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
