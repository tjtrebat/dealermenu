package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Dealer;

public class DealerForm extends CheckboxListForm {

	private List<Dealer> dealers;

	public List<Dealer> getDealers() {
		return dealers;
	}

	public void setDealers(List<Dealer> dealers) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Dealer dealer : dealers)
			checkboxes.put(dealer.getId(), false);
		super.setCheckboxes(checkboxes);
		this.dealers = dealers;
	}

}
