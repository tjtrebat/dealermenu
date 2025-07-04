// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.dealermenu.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.dealermenu.domain.Tax;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Tax_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Tax.entityManager;
    
    public static final EntityManager Tax.entityManager() {
        EntityManager em = new Tax().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Tax.countTaxes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Tax o", Long.class).getSingleResult();
    }
    
    public static List<Tax> Tax.findAllTaxes() {
        return entityManager().createQuery("SELECT o FROM Tax o", Tax.class).getResultList();
    }
    
    public static Tax Tax.findTax(Long id) {
        if (id == null) return null;
        return entityManager().find(Tax.class, id);
    }
    
    public static List<Tax> Tax.findTaxEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Tax o", Tax.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Tax.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Tax.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Tax attached = Tax.findTax(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Tax.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Tax.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Tax Tax.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Tax merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
