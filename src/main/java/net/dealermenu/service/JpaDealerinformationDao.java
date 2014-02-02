package net.dealermenu.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.dealermenu.domain.Dealerinformation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("dealerinformationDao")
@Transactional(propagation = Propagation.SUPPORTS)
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
		qdef.where(
				queryBuilder.equal(dealerInformation.get("userType"), "dealer"),
				queryBuilder.equal(dealerInformation.get("status"), status));
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
	public Dealerinformation saveDealer(Dealerinformation dealer) {
		return em.merge(dealer);
	}

	@Override
	public void removeDealer(Dealerinformation dealerInformation) {
		em.remove(dealerInformation);
	}

}
