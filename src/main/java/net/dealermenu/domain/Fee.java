package net.dealermenu.domain;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Fee {

    /**
     */
    private String feeName;

    /**
     */
    private String displayName;

    /**
     */
    private double defaultValue;

    /**
     */
    private Boolean isActive;

    /**
     */
    private Boolean isTaxable;
    
    /**
     */
    @ManyToOne
    private Dealerinformation dealer;

}
