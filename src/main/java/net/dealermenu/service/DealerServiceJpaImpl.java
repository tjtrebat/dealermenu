package net.dealermenu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
import net.dealermenu.domain.UserRoles;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dealerService")
@Transactional
public class DealerServiceJpaImpl implements DealerService {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> getDealers() {
		return (List<Dealer>) em
				.createQuery("SELECT dealer FROM Dealer dealer")
				.getResultList();
	}

	@Override
	public List<Dealer> getDealersByStatus(DealerStatus status) {
		CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Dealer> qdef = queryBuilder.createQuery(Dealer.class);
		Root<Dealer> dealer = qdef.from(Dealer.class);
		qdef.where(
				queryBuilder.equal(dealer.get("userType"), UserRoles.ROLE_USER),
				queryBuilder.equal(dealer.get("status"), status));
		TypedQuery<Dealer> q = em.createQuery(qdef);
		return q.getResultList();
	}

	@Override
	public Dealer getDealerByLoginId(String loginId) {
		TypedQuery<Dealer> query = em.createNamedQuery(
				"Dealer.getDealerByLoginId", Dealer.class);
		query.setParameter("loginId", loginId.trim());
		return query.getSingleResult();
	}

	@Override
	public Dealer getDealerByPrimaryKey(Long primaryKey) {
		return em.find(Dealer.class, primaryKey);
	}

	@Override
	public void saveDealer(Dealer dealer) {
		em.persist(dealer);
	}

	@Override
	public Dealer updateDealer(Dealer dealer) {
		return em.merge(dealer);
	}

	@Override
	public void removeDealer(Long primaryKey) {
		Dealer dealer = em.find(Dealer.class, primaryKey);
		em.remove(dealer);
	}

	@Override
	public List<Deal> getDeals(String loginId) {
		TypedQuery<Deal> query = em.createNamedQuery("Dealer.getDeals",
				Deal.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}

	@Override
	public Deal getDealByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Deal> query = em.createNamedQuery(
				"Dealer.getDealByPrimaryKey", Deal.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addDeal(String loginId, Long dealTemplateId, Deal deal) {
		DealTemplate dealTemplate = getDealTemplateByPrimaryKey(loginId,
				dealTemplateId);
		deal.setDealTemplate(dealTemplate);
		dealTemplate.getDeals().add(deal);
	}
	
	@Override
	public Deal updateDeal(String loginId, Long dealTemplateId, Deal deal) {
		DealTemplate dealTemplate = getDealTemplateByPrimaryKey(loginId,
				dealTemplateId);
		deal.setDealTemplate(dealTemplate);
		return em.merge(deal);
	}

	@Override
	public List<DealTemplate> getDealTemplates(String loginId) {
		TypedQuery<DealTemplate> query = em.createNamedQuery(
				"Dealer.getDealTemplates", DealTemplate.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}

	@Override
	public DealTemplate getDealTemplateByPrimaryKey(String loginId,
			Long primaryKey) {
		TypedQuery<DealTemplate> query = em.createNamedQuery(
				"Dealer.getDealTemplateByPrimaryKey", DealTemplate.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addDealTemplate(String loginId, DealTemplate dealTemplate) {
		Dealer dealer = getDealerByLoginId(loginId);
		dealTemplate.setDealer(dealer);
		dealer.getDealTemplates().add(dealTemplate);
	}

	@Override
	public void addDealTemplateProducts(String loginId, Long dealTemplateId,
			Map<Long, PackageEntry> packageTypes) {
		DealTemplate dealTemplate = getDealTemplateByPrimaryKey(loginId,
				dealTemplateId);
		Map<Product, PackageEntry> products = new HashMap<Product, PackageEntry>();
		for (Entry<Long, PackageEntry> packageType : packageTypes.entrySet())
			products.put(getProductByPrimaryKey(loginId, packageType.getKey()),
					packageType.getValue());
		dealTemplate.setPackageTypes(products);
	}

	@Override
	public void addDealTemplateFees(String loginId, Long dealTemplateId,
			List<Long> feeIds) {
		DealTemplate dealTemplate = getDealTemplateByPrimaryKey(loginId,
				dealTemplateId);
		List<Fee> fees = new ArrayList<Fee>();
		for (Long feeId : feeIds)
			fees.add(getFeeByPrimaryKey(loginId, feeId));
		dealTemplate.setFees(fees);
	}

	@Override
	public DealTemplate updateDealTemplate(String loginId,
			DealTemplate dealTemplate) {
		Dealer dealer = getDealerByLoginId(loginId);
		dealTemplate.setDealer(dealer);
		return em.merge(dealTemplate);
	}

	@Override
	public List<Product> getProducts(String loginId) {
		TypedQuery<Product> query = em.createNamedQuery("Dealer.getProducts",
				Product.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}

	@Override
	public Product getProductByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Product> query = em.createNamedQuery(
				"Dealer.getProductByPrimaryKey", Product.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public List<Fee> getFees(String loginId) {
		List<Fee> fees = getDealerByLoginId(loginId).getFees();
		fees.size();
		return fees;
	}

	@Override
	public Fee getFeeByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Fee> query = em.createNamedQuery(
				"Dealer.getFeeByPrimaryKey", Fee.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addFee(String loginId, Fee fee) {
		Dealer dealer = getDealerByLoginId(loginId);
		fee.setDealer(dealer);
		dealer.getFees().add(fee);
	}

	@Override
	public List<Tax> getTaxes(String loginId) {
		List<Tax> taxes = getDealerByLoginId(loginId).getTaxes();
		taxes.size();
		return taxes;
	}

	@Override
	public Tax getTaxByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Tax> query = em.createNamedQuery(
				"Dealer.getTaxByPrimaryKey", Tax.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addTax(String loginId, Tax tax) {
		Dealer dealer = getDealerByLoginId(loginId);
		tax.setDealer(dealer);
		dealer.getTaxes().add(tax);
	}

	@Override
	public List<ProductCategory> getProductCategories(String loginId) {
		List<ProductCategory> productCategories = getDealerByLoginId(loginId)
				.getProductCategories();
		productCategories.size();
		return productCategories;
	}

	@Override
	public ProductCategory getProductCategoryByPrimaryKey(String loginId,
			Long primaryKey) {
		TypedQuery<ProductCategory> query = em.createNamedQuery(
				"Dealer.getProductCategoryByPrimaryKey", ProductCategory.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addProductCategory(String loginId,
			ProductCategory productCategory) {
		Dealer dealer = getDealerByLoginId(loginId);
		productCategory.setDealer(dealer);
		dealer.getProductCategories().add(productCategory);
	}

	@Override
	public List<Provider> getProviders(String loginId) {
		List<Provider> providers = getDealerByLoginId(loginId).getProviders();
		providers.size();
		return providers;
	}

	@Override
	public Provider getProviderByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Provider> query = em.createNamedQuery(
				"Dealer.getProviderByPrimaryKey", Provider.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addProvider(String loginId, Provider provider) {
		Dealer dealer = getDealerByLoginId(loginId);
		provider.setDealer(dealer);
		dealer.getProviders().add(provider);
	}

}
