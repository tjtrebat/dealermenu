package net.dealermenu.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dealermenu.domain.Template;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("templateService")
@Transactional
public class JpaTemplateService implements TemplateService {

	@PersistenceContext
	EntityManager em;

	@Override
	public Template getTemplateByPrimaryKey(Long primaryKey) {
		return em.find(Template.class, primaryKey);
	}

	@Override
	public void removeTemplate(Template template) {
		em.remove(template);
	}

}
