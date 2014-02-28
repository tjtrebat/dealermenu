package net.dealermenu.web;

import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.Tax;

public class CreateDealForm {

	private Deal deal;
	private List<Tax> taxes;
	private List<Product> products;
	private Map<Long, Boolean> selectedProducts;
	private Map<Long, Double> productValues;

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Map<Long, Boolean> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(Map<Long, Boolean> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	public Map<Long, Double> getProductValues() {
		return productValues;
	}

	public void setProductValues(Map<Long, Double> productValues) {
		this.productValues = productValues;
	}

}
