package net.dealermenu.service;

import java.util.Map;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.Product;

public interface DealService {

	public Deal getDealByPrimaryKey(Long dealId);

	public void removeDeal(Long dealId);

	public Map<Product, Double> getProductValues(Long dealId);
}
