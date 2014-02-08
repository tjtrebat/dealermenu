package net.dealermenu.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Tax {

    /**
     */
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
    private Dealerinformation dealer;
}
