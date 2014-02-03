package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.Product;
import net.dealermenu.domain.ProductCategory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("productCategoryService")
@Transactional
public class ProductCategoryServiceJpaImpl implements ProductCategoryService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeProduct(ProductCategory productCategory, Product product) {
		productCategory.getProducts().remove(product);
	}

	@Override
	public ProductCategory getProductCategoryByPrimaryKey(Integer primaryKey) {
		return em.find(ProductCategory.class, primaryKey);
	}

	@Override
	public void removeProduct(Product product) {
		product = em.find(Product.class, product.getId());
		em.remove(product);
	}

}
