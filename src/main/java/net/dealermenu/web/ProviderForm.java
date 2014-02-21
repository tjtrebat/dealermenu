package net.dealermenu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Provider;

public class ProviderForm extends CheckboxListForm {

	private List<Provider> providers;

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		Map<Long, Boolean> checkboxes = new HashMap<Long, Boolean>();
		for (Provider provider : providers)
			checkboxes.put(provider.getId(), false);
		super.setCheckboxes(checkboxes);
		this.providers = providers;
	}
}
