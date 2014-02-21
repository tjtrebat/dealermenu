package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Fee;

public class FeeForm extends CheckboxListForm {

	private List<Fee> fees;

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Fee fee : fees)
			checkboxes.put(fee.getId(), false);
		super.setCheckboxes(checkboxes);
		this.fees = fees;
	}

	public void selectFees(List<Fee> selectedFees) {
		for (Fee fee : selectedFees)
			super.getCheckboxes().put(fee.getId(), true);
	}

}
