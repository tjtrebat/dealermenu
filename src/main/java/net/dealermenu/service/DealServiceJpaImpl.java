package net.dealermenu.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dealService")
@Transactional
public class DealServiceJpaImpl implements DealService {

	@PersistenceContext
	EntityManager em;

	@Override
	public Deal getDealByPrimaryKey(Long dealId) {
		return em.find(Deal.class, dealId);
	}
	
	@Override
	public void removeDeal(Long dealId) {
		em.remove(getDealByPrimaryKey(dealId));
	}

	@Override
	public Map<Product, Double> getProductValues(Long dealId) {
		Deal deal = getDealByPrimaryKey(dealId);
		deal.getProductValues().size();
		return deal.getProductValues();
	}

}
