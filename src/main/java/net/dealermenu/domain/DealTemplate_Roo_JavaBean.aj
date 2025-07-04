// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.dealermenu.domain;

import java.util.List;
import java.util.Map;
import net.dealermenu.domain.Deal;
import net.dealermenu.domain.DealTemplate;
import net.dealermenu.domain.DealType;
import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.Fee;
import net.dealermenu.domain.PackageEntry;
import net.dealermenu.domain.Product;

privileged aspect DealTemplate_Roo_JavaBean {
    
    public String DealTemplate.getCreatedBy() {
        return this.createdBy;
    }
    
    public void DealTemplate.setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public String DealTemplate.getTemplateName() {
        return this.templateName;
    }
    
    public void DealTemplate.setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    
    public DealType DealTemplate.getType() {
        return this.type;
    }
    
    public void DealTemplate.setType(DealType type) {
        this.type = type;
    }
    
    public Dealer DealTemplate.getDealer() {
        return this.dealer;
    }
    
    public void DealTemplate.setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
    
    public Map<Product, PackageEntry> DealTemplate.getPackageTypes() {
        return this.packageTypes;
    }
    
    public void DealTemplate.setPackageTypes(Map<Product, PackageEntry> packageTypes) {
        this.packageTypes = packageTypes;
    }
    
    public List<Fee> DealTemplate.getFees() {
        return this.fees;
    }
    
    public void DealTemplate.setFees(List<Fee> fees) {
        this.fees = fees;
    }
    
    public List<Deal> DealTemplate.getDeals() {
        return this.deals;
    }
    
    public void DealTemplate.setDeals(List<Deal> deals) {
        this.deals = deals;
    }
    
}
