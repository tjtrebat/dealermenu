package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.DealTemplate;

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

}
