package net.dealermenu.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.Fee;
import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dealTemplateService")
@Transactional
public class DealTemplateServiceJpaImpl implements DealTemplateService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeDealTemplate(Long primaryKey) {
		em.remove(em.find(DealTemplate.class, primaryKey));
	}

	@Override
	public Map<Product, PackageEntry> getPackageTypes(Long dealTemplateId) {
		DealTemplate dealTemplate = em.find(DealTemplate.class, dealTemplateId);
		Map<Product, PackageEntry> packageTypes = dealTemplate
				.getPackageTypes();
		packageTypes.size();
		return packageTypes;
	}

	@Override
	public List<Fee> getFees(Long dealTemplateId) {
		DealTemplate dealTemplate = em.find(DealTemplate.class, dealTemplateId);
		List<Fee> fees = dealTemplate.getFees();
		fees.size();
		return fees;
	}

	@Override
	public Double getSumOfFeeValues(Long dealTemplateId) {
		TypedQuery<Double> query = em.createNamedQuery(
				"DealTemplate.getSumOfFeeValues", Double.class);
		query.setParameter("primaryKey", dealTemplateId);
		return query.getSingleResult();
	}

}
