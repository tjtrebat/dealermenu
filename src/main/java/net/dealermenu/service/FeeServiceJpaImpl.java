package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dealermenu.domain.Fee;

@Repository("feeService")
@Transactional
public class FeeServiceJpaImpl implements FeeService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeFee(Long primaryKey) {
		em.remove(em.find(Fee.class, primaryKey));
	}

	@Override
	public Fee updateFee(Fee fee) {
		return em.merge(fee);
	}

}
