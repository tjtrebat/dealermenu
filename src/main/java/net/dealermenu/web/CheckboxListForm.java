package net.dealermenu.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckboxListForm implements Serializable {

	private Map<Long, Boolean> checkboxes;

	public Map<Long, Boolean> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(Map<Long, Boolean> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public List<Long> getSelectedIds() {
		List<Long> selectedIds = new ArrayList<Long>();
		if (getCheckboxes() != null)
			for (Long id : getCheckboxes().keySet())
				if (getCheckboxes().get(id) != null && getCheckboxes().get(id))
					selectedIds.add(id);
		return selectedIds;
	}

}
