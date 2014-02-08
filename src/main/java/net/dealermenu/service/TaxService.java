package net.dealermenu.service;

import net.dealermenu.domain.Tax;

public interface TaxService {

	public void removeTax(Long primaryKey);
	
	public Tax updateTax(Tax tax);
}
