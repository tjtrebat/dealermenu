package net.dealermenu.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.dealermenu.domain.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productService")
@Transactional
public class ProductServiceJpaImpl implements ProductService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void saveProduct(Product product) {
		em.persist(product);
	}

	@Override
	public void removeProduct(Product product) {
		em.remove(product);
	}

	@Override
	public List<Product> findProductsByLoginId(String loginId) {
		TypedQuery<Product> query = em.createNamedQuery(
				"Product.findProductsByLoginId", Product.class);
		query.setParameter("loginId", loginId.trim());
		return query.getResultList();
	}

}
