package net.dealermenu.web;

import java.util.List;

import net.dealermenu.domain.Tax;

public class TaxForm {

	private List<Tax> taxes;

	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}
}
