package net.dealermenu.service;

import java.util.List;
import java.util.Map;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.DealerStatus;
import net.dealermenu.domain.Fee;
import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;
import net.dealermenu.domain.Provider;
import net.dealermenu.domain.Tax;

public interface DealerService {

	public List<Dealer> getDealers();

	public List<Dealer> getDealersByStatus(DealerStatus status);

	public Dealer getDealerByLoginId(String loginId);

	public Dealer getDealerByPrimaryKey(Long primaryKey);

	public void saveDealer(Dealer dealer);

	public Dealer updateDealer(Dealer dealer);

	public void removeDealer(Long primaryKey);

	public List<Deal> getDeals(String loginId);

	public Deal getDealByPrimaryKey(String loginId, Long primaryKey);

	public void addDeal(String loginId, Long dealTemplateId, Deal deal);
	
	public Deal updateDeal(String loginId, Long dealTemplateId, Deal deal);

	public List<DealTemplate> getDealTemplates(String loginId);

	public DealTemplate getDealTemplateByPrimaryKey(String loginId,
			Long primaryKey);

	public void addDealTemplate(String loginId, DealTemplate dealTemplate);

	public void addDealTemplateProducts(String loginId, Long dealTemplateId,
			Map<Long, PackageEntry> packageTypes);

	public void addDealTemplateFees(String loginId, Long dealTemplateId,
			List<Long> feeIds);

	public DealTemplate updateDealTemplate(String loginId,
			DealTemplate dealTemplate);

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
