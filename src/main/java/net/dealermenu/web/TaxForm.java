package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Tax;

public class TaxForm extends CheckboxListForm {

	private List<Tax> taxes;

	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> taxes) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Tax tax : taxes)
			checkboxes.put(tax.getId(), false);
		super.setCheckboxes(checkboxes);
		this.taxes = taxes;
	}
}
