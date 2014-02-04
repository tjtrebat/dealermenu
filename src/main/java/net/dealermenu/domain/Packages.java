package net.dealermenu.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.OneToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Packages {

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
    private Dealerinformation dealer;
}
