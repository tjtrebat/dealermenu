package net.dealermenu.domain;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PackageEntry implements Serializable {

    private Boolean isPreferred;

    private Boolean isPremium;

    private Boolean isValue;

    private Boolean isEconomy;

    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public Boolean getIsValue() {
        return isValue;
    }

    public void setIsValue(Boolean isValue) {
        this.isValue = isValue;
    }

    public Boolean getIsEconomy() {
        return isEconomy;
    }

    public void setIsEconomy(Boolean isEconomy) {
        this.isEconomy = isEconomy;
    }

    /**
     */
    private double price;

}
