// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.dealermenu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import net.dealermenu.domain.Packages;

privileged aspect Packages_Roo_Jpa_Entity {
    
    declare @type: Packages: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Packages.id;
    
    @Version
    @Column(name = "version")
    private Integer Packages.version;
    
    public Long Packages.getId() {
        return this.id;
    }
    
    public void Packages.setId(Long id) {
        this.id = id;
    }
    
    public Integer Packages.getVersion() {
        return this.version;
    }
    
    public void Packages.setVersion(Integer version) {
        this.version = version;
    }
    
}
