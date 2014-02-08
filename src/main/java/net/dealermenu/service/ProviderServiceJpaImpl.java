package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.Product;
import net.dealermenu.domain.Provider;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("providerService")
@Transactional
public class ProviderServiceJpaImpl implements ProviderService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void removeProvider(Long primaryKey) {
		em.remove(em.find(Provider.class, primaryKey));
	}

	@Override
	public void addProduct(Long primaryKey, Product product) {
		Provider provider = em.find(Provider.class, primaryKey);
		product.setProvider(provider);
		provider.getProducts().add(product);
	}

}
