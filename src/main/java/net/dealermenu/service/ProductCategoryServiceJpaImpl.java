package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.ProductCategory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productCategoryService")
@Transactional
public class ProductCategoryServiceJpaImpl implements ProductCategoryService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeProductCategory(Long primaryKey) {
		em.remove(em.find(ProductCategory.class, primaryKey));
	}

}
