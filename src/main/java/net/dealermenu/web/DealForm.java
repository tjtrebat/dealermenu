package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Deal;

public class DealForm extends CheckboxListForm {

	private List<Deal> deals;

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Deal deal : deals)
			checkboxes.put(deal.getId(), false);
		super.setCheckboxes(checkboxes);
		this.deals = deals;
	}
}
