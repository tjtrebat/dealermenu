package net.dealermenu.service;

import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Fee;
import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.Product;

public interface DealTemplateService {

	public void removeDealTemplate(Long primaryKey);

	public Map<Product, PackageEntry> getPackageTypes(Long dealTemplateId);

	public List<Fee> getFees(Long dealTemplateId);

}
