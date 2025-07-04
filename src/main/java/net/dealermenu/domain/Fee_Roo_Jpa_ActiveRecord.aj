// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.dealermenu.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.dealermenu.domain.Fee;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Fee_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Fee.entityManager;
    
    public static final EntityManager Fee.entityManager() {
        EntityManager em = new Fee().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Fee.countFees() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Fee o", Long.class).getSingleResult();
    }
    
    public static List<Fee> Fee.findAllFees() {
        return entityManager().createQuery("SELECT o FROM Fee o", Fee.class).getResultList();
    }
    
    public static Fee Fee.findFee(Long id) {
        if (id == null) return null;
        return entityManager().find(Fee.class, id);
    }
    
    public static List<Fee> Fee.findFeeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Fee o", Fee.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Fee.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Fee.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Fee attached = Fee.findFee(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Fee.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Fee.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Fee Fee.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Fee merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
