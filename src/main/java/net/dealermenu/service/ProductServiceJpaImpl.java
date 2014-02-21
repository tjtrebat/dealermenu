package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productService")
@Transactional
public class ProductServiceJpaImpl implements ProductService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeProduct(Long primaryKey) {
		em.remove(em.find(Product.class, primaryKey));
	}

	@Override
	public Product updateProduct(Product product) {
		return em.merge(product);
	}

	@Override
	public Product findProduct(Long primaryKey) {
		return em.find(Product.class, primaryKey);
	}
}
