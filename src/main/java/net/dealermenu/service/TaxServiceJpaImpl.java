package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dealermenu.domain.Tax;

@Repository("taxService")
@Transactional
public class TaxServiceJpaImpl implements TaxService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void removeTax(Long primaryKey) {
		em.remove(em.find(Tax.class, primaryKey));
	}

	@Override
	public Tax updateTax(Tax tax) {
		return em.merge(tax);
	}

}
