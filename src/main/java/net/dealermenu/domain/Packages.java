package net.dealermenu.domain;
import java.io.Serializable;

import javax.persistence.OneToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Packages implements Serializable {

    /**
     */
    private String preferredPackageName;

    /**
     */
    private String premiumPackageName;

    /**
     */
    private String valuePackageName;

    /**
     */
    private String economyPackageName;

    /**
     */
    @OneToOne
    private Dealer dealer;
}
