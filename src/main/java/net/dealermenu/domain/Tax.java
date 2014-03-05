package net.dealermenu.domain;
import java.io.Serializable;

import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Tax implements Serializable {

    /**
     */
	@NotBlank
    private String profileName;

    /**
     */
    private String taxType;

    /**
     */
    private double rate;

    /**
     */
    private double startingTaxableAmt;

    /**
     */
    private double maxTaxableAmt;

    /**
     */
    private double maxTotalTax;

    /**
     */
    private Boolean isDefault;

    /**
     */
    @ManyToOne
    private Dealer dealer;
}
