package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.DealTemplate;

public class DealTemplateForm extends CheckboxListForm {

	private List<DealTemplate> dealTemplates;

	public List<DealTemplate> getDealTemplates() {
		return dealTemplates;
	}

	public void setDealTemplates(List<DealTemplate> dealTemplates) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (DealTemplate dealTemplate : dealTemplates)
			checkboxes.put(dealTemplate.getId(), false);
		super.setCheckboxes(checkboxes);
		this.dealTemplates = dealTemplates;
	}

}
