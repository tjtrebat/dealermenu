package net.dealermenu.service;

import net.dealermenu.domain.Product;

public interface ProviderService {

	public void removeProvider(Long primaryKey);

	public void addProduct(Long primaryKey, Product product);

}
