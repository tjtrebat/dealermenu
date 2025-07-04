// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.dealermenu.domain;

import java.util.List;
import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.Fee;

privileged aspect Fee_Roo_JavaBean {
    
    public String Fee.getFeeName() {
        return this.feeName;
    }
    
    public void Fee.setFeeName(String feeName) {
        this.feeName = feeName;
    }
    
    public String Fee.getDisplayName() {
        return this.displayName;
    }
    
    public void Fee.setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public double Fee.getDefaultValue() {
        return this.defaultValue;
    }
    
    public void Fee.setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    public Boolean Fee.getIsActive() {
        return this.isActive;
    }
    
    public void Fee.setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public Boolean Fee.getIsTaxable() {
        return this.isTaxable;
    }
    
    public void Fee.setIsTaxable(Boolean isTaxable) {
        this.isTaxable = isTaxable;
    }
    
    public Dealer Fee.getDealer() {
        return this.dealer;
    }
    
    public void Fee.setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
    
    public List<DealTemplate> Fee.getDealTemplates() {
        return this.dealTemplates;
    }
    
    public void Fee.setDealTemplates(List<DealTemplate> dealTemplates) {
        this.dealTemplates = dealTemplates;
    }
    
}
