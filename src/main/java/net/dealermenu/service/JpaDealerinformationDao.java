package net.dealermenu.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.Dealerinformation;
import net.dealermenu.domain.Fee;
import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;
import net.dealermenu.domain.Provider;
import net.dealermenu.domain.Tax;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dealerinformationDao")
@Transactional
public class JpaDealerinformationDao implements DealerinformationDao {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Dealerinformation> getDealerinformations() {
		return (List<Dealerinformation>) em
				.createQuery(
						"SELECT dealerInformation FROM Dealerinformation dealerInformation")
				.getResultList();
	}

	@Override
	public List<Dealerinformation> getDealersByStatus(String status) {
		CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Dealerinformation> qdef = queryBuilder
				.createQuery(Dealerinformation.class);
		Root<Dealerinformation> dealerInformation = qdef
				.from(Dealerinformation.class);
		qdef.where(queryBuilder.equal(dealerInformation.get("userType"),
				"ROLE_USER"), queryBuilder.equal(
				dealerInformation.get("status"), status));
		TypedQuery<Dealerinformation> q = em.createQuery(qdef);
		List<Dealerinformation> activeDealers = q.getResultList();
		return activeDealers;
	}

	@Override
	public Dealerinformation getDealerByLoginId(String loginId) {
		TypedQuery<Dealerinformation> query = em
				.createNamedQuery("Dealerinformation.getDealerByLoginId",
						Dealerinformation.class);
		query.setParameter("loginId", loginId.trim());
		return query.getSingleResult();
	}

	@Override
	public Dealerinformation getDealerByPrimaryKey(Long primaryKey) {
		return em.find(Dealerinformation.class, primaryKey);
	}

	@Override
	public void saveDealer(Dealerinformation dealer) {
		em.persist(dealer);
	}

	@Override
	public Dealerinformation updateDealer(Dealerinformation dealer) {
		return em.merge(dealer);
	}

	@Override
	public void removeDealer(Long primaryKey) {
		Dealerinformation dealer = em.find(Dealerinformation.class, primaryKey);
		em.remove(dealer);
	}

	@Override
	public List<DealTemplate> getDealTemplates(String loginId) {
		TypedQuery<DealTemplate> query = em.createNamedQuery(
				"Dealerinformation.getDealTemplates", DealTemplate.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}

	@Override
	public DealTemplate getDealTemplateByPrimaryKey(String loginId,
			Long primaryKey) {
		TypedQuery<DealTemplate> query = em.createNamedQuery(
				"Dealerinformation.getDealTemplateByPrimaryKey",
				DealTemplate.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public List<Product> getProducts(String loginId) {
		TypedQuery<Product> query = em.createNamedQuery(
				"Dealerinformation.getProducts", Product.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}
	
	@Override
	public Product getProductByPrimaryKey(String loginId, Long primaryKey) {
		TypedQuery<Product> query = em.createNamedQuery(
				"Dealerinformation.getProductByPrimaryKey", Product.class);
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
				"Dealerinformation.getFeeByPrimaryKey", Fee.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addFee(String loginId, Fee fee) {
		Dealerinformation dealer = getDealerByLoginId(loginId);
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
				"Dealerinformation.getTaxByPrimaryKey", Tax.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addTax(String loginId, Tax tax) {
		Dealerinformation dealer = getDealerByLoginId(loginId);
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
				"Dealerinformation.getProductCategoryByPrimaryKey",
				ProductCategory.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addProductCategory(String loginId,
			ProductCategory productCategory) {
		Dealerinformation dealer = getDealerByLoginId(loginId);
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
				"Dealerinformation.getProviderByPrimaryKey", Provider.class);
		query.setParameter("loginId", loginId.trim());
		query.setParameter("primaryKey", primaryKey);
		return query.getSingleResult();
	}

	@Override
	public void addProvider(String loginId, Provider provider) {
		Dealerinformation dealer = getDealerByLoginId(loginId);
		provider.setDealer(dealer);
		dealer.getProviders().add(provider);
	}

}
