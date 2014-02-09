package net.dealermenu.service;

import java.util.List;

import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.domain.Fee;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;
import net.dealermenu.domain.Provider;
import net.dealermenu.domain.Tax;

public interface DealerinformationDao {

	public List<Dealerinformation> getDealerinformations();

	public List<Dealerinformation> getDealersByStatus(String status);

	public Dealerinformation getDealerByLoginId(String loginId);

	public Dealerinformation getDealerByPrimaryKey(Long primaryKey);

	public void saveDealer(Dealerinformation dealer);

	public Dealerinformation updateDealer(Dealerinformation dealer);

	public void removeDealer(Long primaryKey);
	
	public List<DealTemplate> getDealTemplates(String loginId);
	
	public DealTemplate getDealTemplateByPrimaryKey(String loginId, Long primaryKey);
	
	public List<Product> getProducts(String loginId);
	
	public Product getProductByPrimaryKey(String loginId, Long primaryKey);

	public List<Fee> getFees(String loginId);

	public Fee getFeeByPrimaryKey(String loginId, Long primaryKey);

	public void addFee(String loginId, Fee fee);

	public List<Tax> getTaxes(String loginId);

	public Tax getTaxByPrimaryKey(String loginId, Long primaryKey);

	public void addTax(String loginId, Tax tax);

	public List<ProductCategory> getProductCategories(String loginId);

	public ProductCategory getProductCategoryByPrimaryKey(String loginId,
			Long primaryKey);

	public void addProductCategory(String loginId,
			ProductCategory productCategory);

	public List<Provider> getProviders(String loginId);

	public Provider getProviderByPrimaryKey(String loginId, Long primaryKey);

	public void addProvider(String loginId, Provider provider);

}
