package net.dealermenu.domain;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Deal {

	@Transient
	Map<Long, Double> productValuesKeyedById;

	@Transient
	Map<Long, Boolean> selectedProducts;

	/**
     */
	@NotBlank(message="Buyer name may not be empty")
	private String buyerName;

	/**
     */
	private double sellingPrice;

	/**
     */
	private double trade;

	/**
     */
	private double payoff;

	/**
     */
	private double customerCash;

	/**
     */
	private double rebate;

	/**
     */
	private String vehicleType;

	/**
     */
	private String stock;

	/**
     */
	private int mileage;

	/**
     */
	private String vin;

	/**
     */
	@ManyToOne
	private Tax tax;

	/**
     */
	private double apr;

	/**
     */
	private int term;

	/**
     */
	private double apr1;

	/**
     */
	private int term1;

	/**
     */
	private double msrp;

	/**
     */
	private double lev;

	/**
     */
	private double baseAmtFinanced;

	/**
     */
	@Enumerated
	private PackageType packageType;

	@ElementCollection
	@CollectionTable(name = "PROD_VALUES")
	@MapKeyJoinColumn(name = "PROD_ID")
	private Map<Product, Double> productValues;

	/**
     */
	private double fees;

	/**
     */
	private Boolean isSigned;

	/**
     */
	@ManyToOne
	private DealTemplate dealTemplate;
}
