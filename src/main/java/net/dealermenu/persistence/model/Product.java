package net.dealermenu.persistence.model;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@NamedQueries({ @NamedQuery(name = "Product.findProductsByLoginId", query = "SELECT product FROM Product product WHERE product.productCategory.dealer.loginId = :loginId") })
public class Product {

	@Column(name = "vProductName")
	private String productName;

	@Column(name = "vProvider")
	private String provider;

	@Column(name = "vProductDescription")
	private String description;

	@Column(name = "vMaximumPrice")
	private Double maxPrice;

	@Column(name = "vDefaultPrice")
	private Double defaultPrice;

	@Column(name = "vMinimumPrice")
	private Double minPrice;

	@Column(name = "vCost")
	private Double cost;

	@Column(name = "vFinance")
	private Boolean isFinance;

	@Column(name = "vCash")
	private Boolean isCash;

	@Column(name = "vLease")
	private Boolean isLease;

	@Column(name = "vBalloon")
	private Boolean isBalloon;

	@ManyToOne
	private ProductCategory productCategory;

}
