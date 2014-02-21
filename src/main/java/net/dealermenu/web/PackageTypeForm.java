package net.dealermenu.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.Product;

public class PackageTypeForm implements Serializable {

	private List<Product> products;
	private Map<Long, PackageEntry> packageTypes;

	public PackageTypeForm() {
		setPackageTypes(new HashMap<Long, PackageEntry>());
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		for (Product product : products)
			getPackageTypes().put(product.getId(), new PackageEntry());
		this.products = products;
	}

	public Map<Long, PackageEntry> getPackageTypes() {
		return packageTypes;
	}

	public void setPackageTypes(Map<Long, PackageEntry> packageTypes) {
		this.packageTypes = packageTypes;
	}

	public void selectPackageTypes(
			Map<Product, PackageEntry> selectedPackageTypes) {
		for (Entry<Product, PackageEntry> packageType : selectedPackageTypes
				.entrySet())
			getPackageTypes().put(packageType.getKey().getId(),
					packageType.getValue());
	}

}
