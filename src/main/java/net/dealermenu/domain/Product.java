package net.dealermenu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Product implements Serializable {

	@Column(name = "vProductName")
	@NotBlank(message = "Product name may not be empty")
	private String productName;

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

	/**
     */
	@ManyToOne
	@NotNull(message = "Provider may not be null")
	private Provider provider;

	@ManyToOne
	private ProductCategory productCategory;

}
